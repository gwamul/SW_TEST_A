#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;
int t;
int n,k;
/*
앞, 오른90 왼90
목적지 까지 최소 조작으로 가고 싶음.
밸수 있는 나무 개수가 k

T : 이동 불가 나무

N 작고, K 는 최대 5

*/
struct Node{
    int x;
    int y;
    int dir;
    int cut;
    int control;
};

int ex, ey;

vector<vector<char>> board;
int dx[4] = {-1,0,1,0};// 상 우 하 좌
int dy[4] = {0,1,0,-1};

int sol(int sx, int sy, int k){

    queue<Node> q;
    vector<vector<vector<vector<bool>>>> visited(
        n, vector<vector<vector<bool>>>(
            n, vector<vector<bool>>(
                4, vector<bool>(k + 1, false)
            )
        )
    );
    visited[sx][sy][0][k] = true;
    q.push({sx, sy, 0, k, 0});
    int min_control = 9999999;
    while(!q.empty()){
        Node cur = q.front(); q.pop();
        int tx = cur.x;
        int ty = cur.y;
        int dir = cur.dir;
        int cut = cur.cut;
        int control = cur.control;
        //cout << tx << " " << ty <<" " << dir << " " << cut << " " << control << endl;
        if(tx == ex && ty == ey){
            min_control = min(min_control, control);
        }
        // 직진
        int nx = tx + dx[dir];
        int ny = ty + dy[dir];
        if(0<= nx && nx < n && 0 <= ny && ny < n){
            if(board[nx][ny] == 'G'){
                //그냥 갈 수 있는 곳
                if(visited[nx][ny][dir][cut]) continue;
                visited[nx][ny][dir][cut] = true;
                q.push({nx, ny, dir, cut , control + 1});
            }else{
                if(cut == 0) continue;
                if(visited[nx][ny][dir][cut-1]) continue;
                visited[nx][ny][dir][cut-1] = true;
                q.push({nx, ny, dir, cut-1 , control + 1});
            }
        }


        // 우회전
        int ndir = (dir + 1) % 4;
        if(!visited[tx][ty][ndir][cut]) {
            visited[tx][ty][ndir][cut] = true;
            q.push({tx, ty, ndir, cut, control + 1});
        }

        // 3. 좌회전 로직
        ndir = (dir + 3) % 4;
        if(!visited[tx][ty][ndir][cut]) {
            visited[tx][ty][ndir][cut] = true;
            q.push({tx, ty, ndir, cut, control + 1});
        }
        
    }

    return min_control == 9999999 ? -1 :  min_control;


}



int main(){

    cin >> t;
    for(int tc = 1; tc <= t; tc ++){

        cin >> n >> k;
        board.assign(n, vector<char>(n));

        int sx, sy;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                cin >> board[i][j];
                if(board[i][j] == 'X'){
                    sx = i;
                    sy = j;
                    board[i][j] = 'G';
                }else if(board[i][j] == 'Y'){
                    ex = i;
                    ey = j;
                    board[i][j] = 'G';
                }
            }
        }
        


        cout << "#" << tc << " " <<sol(sx, sy, k)  << endl;

    }


    return 0;
}