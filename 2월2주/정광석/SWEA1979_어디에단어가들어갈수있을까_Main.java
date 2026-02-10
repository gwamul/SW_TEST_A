package 정광석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1979_어디에단어가들어갈수있을까_Main {
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int totalCnt;
	static int[][] board;
	static boolean[][][] visited;
	static int n, k;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			totalCnt = 0;
			board = new int[n][n];
			visited = new boolean[n][n][4];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					
				}
			}
			
			for(int i=0; i<n; i++) {
				
				int start = 0;
				int cnt = 0;
				
				for(int j=0; j<n; j++) {
					System.out.println(cnt);
					if(board[i][j] == 1 && cnt==0) {
						start = j;
						cnt++;
					}
					else if(board[i][j] == 1) {
						cnt++;
					}else {
						int len = j - start + 1;
						if(len==k) totalCnt ++;
						cnt = 0;
					}
				}
			}
			
			
			
			
			sb.append("#"+tc+" " ).append(totalCnt).append("\n");
			
		}
		System.out.println(sb.toString());
	}
	
	
}
