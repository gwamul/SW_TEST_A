import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Backjoon_1743_음식물피하기 {
	static int N, M, K;
	static boolean[][] room;
	static int max;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] visited;
	
	static class Food {
		int r, c;
		
		public Food(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		room = new boolean[N + 1][M + 1];
		max = Integer.MIN_VALUE;
		
		for(int i = 0; i < K; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			
			room[r][c] = true;			
			}
		
		visited = new boolean[N + 1][M + 1];
		for(int r = 1; r <= N; r++) {
			for(int c = 1; c <= M; c++) {
				if(room[r][c]) {
					int count = bfs(new Food(r, c));
					max = Math.max(max, count);
				}
			}
		}
		
		System.out.println(max);
	}
	
	static int bfs(Food start) {
		int count = 1;
		visited[start.r][start.c] = true;
		
		Queue<Food> check = new ArrayDeque<>();
		
		check.offer(start);
		
		while(!check.isEmpty()) {
			Food curr = check.poll();
			int r = curr.r;
			int c = curr.c;
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nc >= 1 && nc <= M && nr >= 1 && nr <= N) {
					if(room[nr][nc] && !visited[nr][nc]) {
						visited[nr][nc] = true;
						count++;
						
						check.offer(new Food(nr, nc));
					}
				}
			}
		}
		
		return count;
	}
}
