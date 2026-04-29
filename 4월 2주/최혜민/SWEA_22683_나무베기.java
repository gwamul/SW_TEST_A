package D3;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_22683_나무베기 {
	static int N;
	static int K;
	static char[][] map;
	static int startR, startC;
	static int targetR, targetC;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static class Node {
		int r, c, d, k, count;

		public Node(int r, int c, int d, int k, int count) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
			this.k = k;
			this.count = count;
		}
		
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			
			map = new char[N][N];
			
			for(int i = 0; i < N; i++) {
				String line = sc.next();
				for(int j = 0; j < N; j++) {
					map[i][j] = line.charAt(j);
					if(map[i][j] == 'X') {
						startR = i;
						startC = j;
					}
					
					if(map[i][j] == 'Y') {
						targetR = i;
						targetC = j;
					}
				}
			} //입력
			
			int result = drive();
			
			System.out.println("#" + tc + " " + result);
			
		}
	}
	
	static int drive() {
		Queue<Node> q = new LinkedList<>();
		int[][][] visited = new int[N][N][K + 1];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				Arrays.fill(visited[i][j], Integer.MAX_VALUE);
			}
		}
		
		q.add(new Node(startR, startC, 0, 0, 0));
		visited[startR][startR][0] = 0;
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			
			int r = curr.r;
			int c = curr.c;
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				
				int change = Rotate(curr.d, d);
				int nextCount = curr.count + change + 1;
				int nextK = curr.k;
				
				if(map[nr][nc] == 'T') {
					nextK++;
				}
				
				if(nextK <= K && visited[nr][nc][nextK] > nextCount) {
					visited[nr][nc][nextK] = nextCount;
					q.add(new Node(nr, nc, d, nextK, nextCount));
				}
			}
		}
		
		int result = Integer.MAX_VALUE;
		for(int k = 0; k <= K; k++) {
			result = Math.min(result, visited[targetR][targetC][k]);
		}
		
		return (result == Integer.MAX_VALUE) ? -1 : result;
	}
	
	static int Rotate(int curD, int targetD) {
		if(curD == targetD) return 0;
		int diff = Math.abs(curD - targetD);
		if(diff == 2) return 2;
		return 1;
	}
}
