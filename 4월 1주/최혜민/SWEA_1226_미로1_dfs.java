package D4;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1226_미로1_dfs {
	static int[][] map;
	static int sR, sC;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static class Node {
		int r;
		int c;
		
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();
			
			map = new int[16][16];
			visited = new boolean[16][16];
			
			for(int i = 0; i < 16; i++) {
				String line = sc.next();
				for(int j = 0; j < 16; j++) {
					map[i][j] = line.charAt(j) - '0';
					
					if(map[i][j] == 2) {
						sR = i;
						sC = j;
					}
				}
			}
			
			int result = dfs(sR, sC);
			
			System.out.println("#" + tc + " " + result);
		}
	}
	
	static int dfs(int sR, int sC) {
		visited[sR][sC] = true;
		
		for(int d = 0; d < 4; d++) {
			int nr = sR + dr[d];
			int nc = sC + dc[d];
			
			if(nr < 0 || nr >= 16 || nc < 0 || nc >= 16) continue;
			if(visited[nr][nc]) continue;
			if(map[nr][nc] == 3) return 1;
			if(map[nr][nc] == 0) {
				if(dfs(nr, nc) == 1) return 1;				
			}
		}
		
		return 0;
	}
}
