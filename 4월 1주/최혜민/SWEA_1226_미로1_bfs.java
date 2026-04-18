package D4;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1226_미로1_bfs {
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
			
			int result = bfs(sR, sC);
			
			System.out.println("#" + tc + " " + result);
		}
	}
	
	static int bfs(int sR, int sC) {
		Queue<Node> q = new ArrayDeque<>();
		
		q.add(new Node(sR, sC));
		visited[sR][sC] = true;
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			int cr = curr.r;
			int cc = curr.c;
			
			for(int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(nr < 0 || nr >= 16 || nc < 0 || nc >= 16) continue;
				
				if(map[nr][nc] == 0 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					q.add(new Node(nr, nc));
				}
				
				if(map[nr][nc] == 3) {
					return 1;
				}
			}
		}
		return 0;
	}
}
