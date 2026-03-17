package saffy_algo.BaekJoon.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon11403_경로찾기_Main {
	static int[][] board, result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		board =  new int[n][n];
		result = new int[n][n];
		
		for(int i=0;i <n;i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<n; i++) {
			sol(i,n);
		}
		
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		
		System.out.println(sb.toString());
	}
	
	static void sol(int start, int n) {
		Queue<Integer> q = new ArrayDeque<>();
		
		boolean[] visited= new boolean[n];
		q.offer(start);
		
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i=0; i<n; i++) {
				if(!visited[i] && board[cur][i] == 1) {
					q.offer(i);
					visited[i] = true;
					result[start][i] = 1;
				}
			}
		}
		
		
	}
}
