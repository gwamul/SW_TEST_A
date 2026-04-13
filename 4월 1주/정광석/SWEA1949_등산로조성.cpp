#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int board[10][10];
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
int N;

struct State {
    int x, y, cnt;
};

int bfs(int sx, int sy) {
    queue<State> q;

    int max_dist[10][10];
    for(int i=0; i<N; i++) for(int j=0; j<N; j++) max_dist[i][j] = -1;

    q.push({sx, sy, 1});
    max_dist[sx][sy] = 1;

    int total_max = 1;

    while(!q.empty()){
        State curr = q.front(); q.pop();
        total_max = max(total_max, curr.cnt);

        for(int i=0; i<4; i++){
            int nx = curr.x + dx[i];
            int ny = curr.y + dy[i];

            if(nx >= 0 && nx < N && ny >= 0 && ny < N){

                if(board[nx][ny] < board[curr.x][curr.y]){

                    if(max_dist[nx][ny] < curr.cnt + 1){
                        max_dist[nx][ny] = curr.cnt + 1;
                        q.push({nx, ny, curr.cnt + 1});
                    }
                }
            }
        }
    }
    return total_max;
}

int main(){
    int t;
    cin >> t;
    for(int tc = 1; tc <= t; tc ++){
        int k;
        cin >> N >> k;
        int max_height = -1;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                cin >> board[i][j];
                max_height = max(max_height, board[i][j]);
            }
        }

        vector<pair<int, int>> start_points;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++) if(board[i][j] == max_height) start_points.push_back({i, j});
        }

        int result = 0;

        for(auto sp : start_points) result = max(result, bfs(sp.first, sp.second));


        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                int origin = board[i][j];
                for(int a=1; a<=k; a++){
                    board[i][j] = origin - a;
                    for(auto sp : start_points){

                        if(board[sp.first][sp.second] != max_height) continue;
                        result = max(result, bfs(sp.first, sp.second));
                    }
                }
                board[i][j] = origin;
            }
        }
        cout << "#" << tc << " " << result << endl;
    }
    return 0;
}
