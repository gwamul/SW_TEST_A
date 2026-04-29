#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>


using namespace std;
int n,q;
int sx, sy, ex, ey;
/*
1
5
GGGGG
GXGTG
GGTTG
GGGYG
GTGGG
3
7 RRAALAA
8 RRAALAAA
12 RAARRALAALAA
*/
int dx[4] = {-1,0,1,0};
int dy[4] = {0,1,0,-1};


vector<vector<char>> board;


int main(){
    int t; cin >> t;
    for(int tc = 1; tc<= t;  tc++){

        
        cin >> n;
        board.resize(n, vector<char>(n));
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
        cout << "#"<<tc <<" ";
        cin >> q;
        for(int i=0; i<q; i++){
            int c;
            string s;
            cin >> c;
            cin >> s;
            int x = sx;
            int y = sy;
            int dir = 0;
            bool flag = true;
            for(char& cmd : s){
                //cout << "x: " << x << " y: " << y << endl;
                if(cmd == 'A'){
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    if(0<= nx && nx < n && 0 <= ny && ny < n){
                        if(board[nx][ny] == 'T'){
                            continue;
                        }else{
                            x = nx;
                            y = ny;
                        }
                    }else{
                        continue;
                    }
                }
                else if(cmd == 'L'){
                    dir = (dir + 3) % 4;
                }else if(cmd == 'R'){
                    dir = (dir + 1) % 4;
                }
            }

            if(flag){
                if( x == ex && y == ey) {
                    flag = true;
                }else{
                    flag = false;
                }
            }
            if(flag) cout << 1 << " ";
            else cout << 0 << " ";
            
        }
        cout << endl;



        
    }
    return 0;
}