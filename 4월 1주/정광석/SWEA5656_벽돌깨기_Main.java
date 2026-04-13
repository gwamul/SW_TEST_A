package saffy_algo.SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA5656_벽돌깨기_Main {
	
	static int n,w,h;
	static int[][] board;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int max_c;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			max_c = Integer.MIN_VALUE;
			board = new int[h][w];
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append("#").append(tc).append(" ");
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void sol(int cnt, int[][] board) {
		if(cnt == n) {
			int ans = count(board);
			max_c = Math.max(max_c, ans);
			return;
		}
		
		int[][] tempboard = copyboard(board);
		for(int i=0; i<w; i++) {
			sol(cnt+1, afterbomb(tempboard, i));
		}
	}
	
	static boolean inBound(int x, int y) {
		if(0<=x && x<h && 0<=y && y < w) return true;
		return false;
	}

	private static int[][] afterbomb(int[][] board, int i) {
		// TODO Auto-generated method stub
		int[][] newboard = new int[h][w];
		boolean[][] bomb = new boolean[h][w];
		
		
		
		
		return null;
	}

	private static int[][] copyboard(int[][] board) {
		// TODO Auto-generated method stub
		int[][] newboard = new int[h][w];
		for(int i=0; i<h; i++) {
			newboard[i] = board[i].clone();
		}
		return newboard;
	}

	private static int count(int[][] board) {
		// TODO Auto-generated method stub
		int cnt = 0;
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(board[i][j]!=0) cnt++;
			}
		}
		return cnt;
	}
}
