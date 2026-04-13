package saffy_algo.SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1226_Main {
	
	
	
	static int[][] board;
	static boolean[][] visited;
	static int[] dx = new int[] {0,0,1,-1};
	static int[] dy = new int[] {1,-1,0,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		for(int t = 1; t <= 10; t++) {
			int tc = Integer.parseInt(br.readLine());
			sb.append("#").append(tc).append(" ");
			board = new int[16][16];
			visited = new boolean[16][16];
			int answer = 0;
			int sx=0,sy=0,ex=0,ey =0;
			for(int i=0; i<16; i++) {
				String line = br.readLine();
				for(int j=0; j<16; j++) {
					int temp = line.charAt(j) - '0';
					board[i][j] = temp;
					
					
					
					if(temp == 2) {
						sx = i;
						sy = j;
					}
					else if(temp == 3) {
						ex = i;
						ey = j;
					}
				}
				
				
			}
			
			answer = sol(sx, sy, ex, ey);
			
			
			
			
			
			sb.append(answer);
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
		
	}
	
	static int sol(int sx, int  sy, int ex, int ey) {
		
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {sx, sy});
		visited[sx][sy] = true;
		
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int tx = tmp[0];
			int ty = tmp[1];
			
			if(tx == ex && ty == ey) {
				return 1;
			}
			
			
			for(int i=0 ;i<4; i++) {
				int nx = tx + dx[i];
				int ny = ty + dy[i];
				if(0<=nx && nx < 16 && 0<=ny && ny < 16) {
					if(visited[nx][ny]) continue;
					if(board[nx][ny] == 1) continue;
					q.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
				}
			}
		}
		
		
		
		
		
		return 0;
		
		
		
	} 
}
