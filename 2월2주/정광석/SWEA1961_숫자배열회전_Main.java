package 정광석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1961_숫자배열회전_Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			
			int n = Integer.parseInt(br.readLine());
			int[][] board = new int[n][n];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) board[i][j] = Integer.parseInt(st.nextToken());
			}

			sb.append("#"+tc+"\n");
			sb.append(sol(n, board));
			//sb.append("\n");
			
		}
		System.out.println(sb.toString());
	}
	
	static String sol(int n, int[][] board) {
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {	
				//1. 90도 : 시계방향
				sb.append(board[n-1-j][i]);	
			}
			sb.append(" ");
			for(int j=0; j<n; j++) {
				//2. 180도
				sb.append(board[n-1-i][n-1-j]);
			}
			sb.append(" ");
			for(int j=0; j<n; j++) {
				//3. -90도
				sb.append(board[j][n-1-i]);
			}
			sb.append("\n");
		}
		
		
		
		
		return sb.toString();
	}
}
