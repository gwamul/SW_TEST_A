import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Backjoon_11403_경로찾기 {
	static int N;
	static int[][] graph;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		graph = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				graph[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(bfs(i, j) + " ");
			}
			System.out.println();
		}
	} // main

	static int bfs(int start, int end) {
		int result = 0;
		visited = new boolean[N];

		Queue<Integer> check = new ArrayDeque<>();
		check.offer(start);

		while (!check.isEmpty()) {
			int curr = check.poll();
			
			for(int j = 0; j < N; j++) {
				if(graph[curr][j] == 1 && !visited[j]) {
					if(j == end) return 1;
					
					visited[j] = true;
					check.offer(j);
				}
			}
		}
		return 0;
	}
}
