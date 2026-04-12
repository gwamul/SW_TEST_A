#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;
int n;
int sx, sy, ex, ey;

int dx[4] = {0,0,1,-1};
int dy[4] = {1,-1,0,0};

vector<vector<int>> board;
int main(){
    int t; cin >> t;

    for(int tc = 1; tc <= t; tc++){


        cin >> n;

        board.assign(n, vector<int>(n, 0));

        for(int i=0; i<n; i++){
            string s; cin >> s;
            for(int j=0; j<n; j++){
                board[i][j] = s[j] - '0';
                if(board[i][j] == 2){
                    sx = i;
                    sy = j;
                    board[i][j] = 0;
                }else if(board[i][j] == 3){
                    ex = i;
                    ey = j;
                    board[i][j] = 0;
                }
            }
        }
        queue<pair<pair<int, int>, int>> q;
        vector<vector<bool>> visited(n, vector<bool>(n, false));
        q.push({{sx, sy}, 0});
        visited[sx][sy] = true;

        int ans = 0;
        while(!q.empty()){
            pair<pair<int, int>, int> temp = q.front(); q.pop();
            pair<int, int> coord = temp.first;
            int tx = coord.first;
            int ty = coord.second;
            int cnt = temp.second;

            if(tx == ex && ty == ey){
                ans = cnt-1;
                break;
            }
            for(int i=0; i<4; i++){
                int nx = tx + dx[i];
                int ny = ty + dy[i];
                if(0<=nx && nx < n && 0<= ny && ny < n){
                    if(visited[nx][ny]) continue;
                    if(board[nx][ny] == 1) continue;
                    visited[nx][ny] = true;
                    q.push({{nx, ny}, cnt+1});
                }
            }

        }





        cout << "#" << tc << " " << ans << endl;
    }

    return 0;
    
}