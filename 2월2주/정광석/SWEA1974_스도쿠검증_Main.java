package 정광석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1974_스도쿠검증_Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=t;tc++) {
			int[][] board = new int[9][9];
			int answer = 1;
			int flag = (1<<9) -1;
			
			for(int i=0; i<9; i++) {
				st = new StringTokenizer(br.readLine());
				int sum = 0;
				for(int j=0; j<9; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					sum |= 1<<board[i][j]-1;
					
				}
				//System.out.println(sum);
				if(sum!=flag) {
					answer = 0;
					break;
				}
			}
			//System.out.println(answer);
			for(int i=0; i<9; i++) {
				int sum =0;
				for(int j=0; j<9; j++) {
					sum |= 1<<board[j][i]-1;
				}
				if(sum!=flag) {
					answer = 0;
					break;
				}
				
			}
			//System.out.println(answer);

			for(int i=0;i <3; i++) {
				for(int j=0; j<3; j++) {
					int sum = 0;
					//System.out.println(i + " " + j);
					for(int s=i*3; s<i*3+3; s++) {
						for(int e=j*3; e<j*3+3; e++) {
							sum|= 1<<board[s][e]-1;
						}
					}
					//System.out.println(sum);
					if(sum!=flag) {
						answer = 0;
						break;
					}
				}
			}
			
			System.out.println("#"+tc+ " " + answer);
			
			
			
			
			
		}
	}
}
