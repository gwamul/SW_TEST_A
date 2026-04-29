import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_5105_미로의거리 {
	static int sR, sC;
	static int tR, tC;
	static int N;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] visited;
	static class Node {
		int r, c;
		int count;
		
		 public Node(int r, int c, int count) {
			this.r = r;
			this.c = c;
			this.count = count;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			
			map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				String line = sc.next();
				for(int j = 0; j < N; j++) {
					map[i][j] = line.charAt(j) - '0';
					
					if(map[i][j] == 2) {
						sR = i;
						sC = j;
					}
					
					if(map[i][j] == 3) {
						tR = i;
						tC = j;
					}
				}
			}
			
			visited = new boolean[N][N];
			int result = find(sR, sC);
			
			System.out.println("#" + tc + " " + result);
		}
	}
	
	static int find(int sr, int sc) {
		Queue<Node> q = new ArrayDeque<>();
		
		q.add(new Node(sr, sc, 0));
		visited[sr][sc] = true;
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			int r = curr.r;
			int c = curr.c;
			
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				
				if(map[nr][nc] == 3) {
					return curr.count;
				}
				
				if(!visited[nr][nc] && map[nr][nc] == 0) {
					q.add(new Node(nr, nc, curr.count + 1));
					visited[nr][nc] = true;
				}
			}
		}
		return 0;
	}
}
