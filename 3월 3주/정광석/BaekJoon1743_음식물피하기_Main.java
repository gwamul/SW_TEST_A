package saffy_algo.BaekJoon.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1743_음식물피하기_Main {

	
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {-1,1,0,0};
	static int[][] board;
	static int n,m;
	static boolean[][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int  k;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		visited = new boolean[n][m];
		
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int r,c;
			r = Integer.parseInt(st.nextToken())-1;
			c = Integer.parseInt(st.nextToken())-1;
			board[r][c] = 1;
				
		}
		
		//System.out.println(dfs(0,0));
		int ans = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!visited[i][j] && board[i][j] == 1) {
					ans = Math.max(ans, dfs(i,j));
				}
			}
		}
		System.out.println(ans);
		
	}
	
	static int dfs(int x, int y) {
		if (x<0 || x>= n || y<0 || y>=m) {
	        return 0;
	    }
	    if (board[x][y] == 0 || visited[x][y]) {
	        return 0;
	    }

	    visited[x][y] = true;
	    int count = 1;
	    for(int i = 0; i < 4; i++) {
	        int nx = x + dx[i];
	        int ny = y + dy[i];
	        
	        count += dfs(nx, ny);
	    }
	    return count;
	}
}
