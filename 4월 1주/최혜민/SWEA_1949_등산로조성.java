import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class SWEA_1949_등산로조성 {
	static int N;
	static int K;
	static int highest;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int result;
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			map = new int[N][N];
			
			highest = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					
					if(map[i][j] > highest)
						highest = map[i][j];
				}
			}
			
			visited = new boolean[N][N];
			result = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == highest) {
						dfs(i, j, highest, 1, false);						
					}
				}
			}
			
			System.out.println("#" + tc + " " + result);
		}
	}
	
	static void dfs(int r, int c, int height, int dist, boolean kUsed) {
		if(dist > result) {
			result = dist;
		}
		
		visited[r][c] = true;
		
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			if(visited[nr][nc]) continue;
			
			if(map[nr][nc] < height) {
				dfs(nr, nc, map[nr][nc], dist + 1, kUsed);
			}
			else if(!kUsed && map[nr][nc] - K < height) {
				dfs(nr, nc, map[nr][nc] - (map[nr][nc] - height + 1), dist + 1, true);
			}
		}
		
		visited[r][c] = false;
		
	}
}
