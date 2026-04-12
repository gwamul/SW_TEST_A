#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;
int n,m;
/*
2
1 0
3 2
1 2
3 2


1
7 8
1 2
2 3
2 4
3 4
3 7
4 7
4 5
5 6

answer = 7 나와야 한다고

*/

vector<vector<int>> adj;
vector<bool> visited;
int max_dist = -1;
void dfs(int start, int cnt){
    max_dist = max(max_dist, cnt);
    for(int next: adj[start]){
        if(visited[next]) continue;
        visited[next] = true;
        dfs(next,cnt+1);
        visited[next] = false;
    }
}


int main(){
    int t; cin >> t;
    for(int tc = 1; tc<=t; tc++){
        cin >> n  >> m;
        adj.resize(n+1);
        visited.resize(n+1);
        for(int i=0; i<m; i++){
            int x,y;
            cin >> x>>y;
            adj[x].push_back(y);
            adj[y].push_back(x);

        }

        
        for(int i=1; i<=n; i++){
            visited[i] = true;
            dfs(i, 1);
           
            visited[i] = false;
        }

        cout << "#" << tc << " " << max_dist << endl;
    }

    return 0;

}