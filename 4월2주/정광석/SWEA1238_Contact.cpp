#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int t = 10;
int n, start;

vector<vector<int>> board;

int bfs(int s){
    //cout << "bfs start" << endl;
    vector<bool> visited(101, false);
    visited[s] = true;
    queue<pair<int, int > > q;
    q.push({s,0});
    int max_cnt = -1;
    vector<int> result;
    while(!q.empty()){
        pair<int, int> temp = q.front(); q.pop();
        int now = temp.first;
        int cnt = temp.second;
       // cout << now << " " << cnt << endl;
        if(cnt > max_cnt){
            result.clear();
            result.push_back(now);
            max_cnt = cnt;
        }else if(cnt == max_cnt){
            result.push_back(now);
        }
        for(int next : board[now]){
            if(visited[next]) continue;
            visited[next] = true;
            q.push({next, cnt+1});
        }
    }

    sort(result.begin(), result.end(), greater<int>());
    return result[0];

}


int main(){
    

    for(int tc = 1; tc<=10 ;tc ++){
    cin >> n >> start;
    
    board.assign(101, vector<int>(0));
    for(int i=0; i<n/2; i++){
        int from ,to; cin >> from >> to;
        board[from].push_back(to);
    }

    cout <<"#"<<tc << " "<< bfs(start) << endl;
}
}