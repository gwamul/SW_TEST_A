import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Backjoon_2589_보물섬 {
	static int N, M;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int max;
	
	static class Location {
		int r, c, d;
		public Location(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new char[N][M];
		sc.nextLine();
		
		for(int i = 0; i < N; i++) {
			String s = sc.nextLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
			}
		} //map입력
		
		max = Integer.MIN_VALUE;
		
		Queue<Location> queue = new ArrayDeque<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				int distance = 0;
				if(map[i][j] == 'L') {
					bfs(i, j);
				}
			}
		}
		
		System.out.println(max);
	}
	
	static void bfs(int r, int c) {
		Queue<Location> check = new ArrayDeque<>();
		
		visited = new boolean[N][M];
		
		check.offer(new Location(r, c, 0));
		visited[r][c] = true;
		
		while(!check.isEmpty()) {
			Location curr = check.poll();
			
			
			for(int d = 0; d < 4; d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if(map[nr][nc] == 'L' && !visited[nr][nc]) {
						visited[nr][nc] = true;
						check.offer(new Location(nr, nc, curr.d + 1));
					}
				}
			}
			max = Math.max(max, curr.d);
		}
	}
}
