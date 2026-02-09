package 정광석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1954_달팽이숫자_Main {
	
	static int[] dx = {0 , 1, 0, -1};
	static int[] dy = {1 , 0, -1, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] board = new int[n][n];
			int r = 0, c = 0, dir = 0;
			
			
			for(int i=1; i<=n*n; i++) {
				board[r][c] = i;
				
				int nr = r + dx[dir];
				int nc = c + dy[dir];
				
				if(nr < 0 || nr >= n || nc < 0 || nc >= n || board[nr][nc] != 0) {
					
						dir = (dir+1)%4;
						nr = r + dx[dir];
						nc = c + dy[dir];
					
				}
				r = nr;
				c = nc;
			}
			
			sb.append("#").append(tc).append("\n");
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					sb.append(board[i][j] + " ");
				}
				sb.append("\n");
			}
			
		}
		System.out.println(sb.toString());
	}
}
