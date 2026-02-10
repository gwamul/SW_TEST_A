package 정광석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2009_파리퇴치_Main {
	static int t;
	static int maxSum = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		t = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=t; tc++) {
			sb.append("#").append(tc).append(" " );
			maxSum = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine());
			

			int n,m;
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int[][] board = new int[n][n];
			int[][] sumboard  = new int[n+1][n+1];
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				
				for(int j=0; j<n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			for (int i = 1; i <= n; i++) {
			    for (int j = 1; j <= n; j++) {
			         sumboard[i][j] = board[i-1][j-1] + sumboard[i - 1][j] + sumboard[i][j - 1] - sumboard[i - 1][j - 1];
			    }
			}
			
//			for(int i=0 ;i<n ;i++) {
//				System.out.println(Arrays.toString(sumboard[i]));
//			}
//			
			int sum = 0;
			for(int i=1 ;i <= n-m+1; i++) {
				for(int j=1; j<=n-m+1; j++) {
					sum = sumboard[m+i-1][m+j-1] - sumboard[m+i-1][j-1] - sumboard[i-1][m+j-1] + sumboard[i-1][j-1];
					maxSum= Math.max(sum, maxSum);
							
				}
			}
			
			sb.append(maxSum);
			sb.append("\n");

		}
		System.out.println(sb.toString());
		
	}
}
