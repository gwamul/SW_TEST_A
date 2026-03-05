package 정광석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon2206_벽부수고이동하기_Main {
	static int min_dist = Integer.MAX_VALUE;
	static List<int[]> walls;
	static int n,m;
	static int[][] board;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();



		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		walls = new ArrayList<>();


		board  = new int[n][m];
		for(int i=0; i<n; i++) {
			String line = br.readLine();
			for(int j=0; j<m; j++) {
				board[i][j] = line.charAt(j)- '0';
				if(board[i][j] == 1) {
					walls.add(new int[] {i,j});
				}
			}
		}

		bfs();
		
		System.out.println(min_dist == Integer.MAX_VALUE ? -1 : min_dist);

	}

	static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0,0,1,0});
		boolean[][][] visited = new boolean[n][m][2];
		visited[0][0][0]= true;
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int tx = temp[0];
			int ty = temp[1];
			int cnt = temp[2];
			int canDo = temp[3];
			
			if(tx == n-1 && ty == m-1) {
				min_dist = Math.min(min_dist, cnt);
				return;
			}
			for(int i=0; i<4; i++) {
				int nx = tx + dx[i];
				int ny = ty + dy[i];
				if(0<=nx && nx < n && 0<=ny && ny < m) {
					
					if(board[nx][ny] == 1) {
						//벽이 있음.
						if(canDo == 0 && !visited[nx][ny][1]) {
							visited[nx][ny][1] = true;
							q.offer(new int[] {nx,ny,cnt+1,1});
						}
						
					}else {
						if(!visited[nx][ny][canDo]) {
							visited[nx][ny][canDo] = true;
							q.offer(new int[] {nx,ny,cnt+1,canDo});
						}
					}
					
				}
			}
		}
		
		
	}
}
