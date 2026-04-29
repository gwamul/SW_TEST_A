import java.util.Scanner;

public class SWEA_2814_최장경로 {
	static int N;
	static int M;
	static int[][] map;
	static int longest;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			map = new int[N + 1][N + 1];
			
			visited = new boolean[N + 1];
			for(int i = 0; i < M; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				
				if(from > N || to > N) continue;
				
				map[from][to] = 1;
				map[to][from] = 1;
			}
			
			longest = 0;
			for(int i = 1; i <= N; i++) {
				dfs(i, 1);
			}
			
			System.out.println("#" + tc + " " + longest);
		}
	}
	
	static void dfs(int start, int count) {
		longest = Math.max(longest, count);
		
		visited[start] = true;;
		
		for(int i = 1; i <= N; i++) {
			if(map[start][i] == 1 && !visited[i]) {
				dfs(i, count + 1);
			}
		}
		visited[start] = false;
	}
}
