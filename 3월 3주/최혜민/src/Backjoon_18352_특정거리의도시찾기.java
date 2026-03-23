import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Backjoon_18352_특정거리의도시찾기 {
	static int N, M, K, X;
	static List<Integer>[] road;
	static int[] min;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		X = sc.nextInt();

		min = new int[N + 1];

		road = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			road[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			road[a].add(b);
		}

		bfs(X);

		boolean find = false;
		for (int i = 1; i <= N; i++) {
			if (min[i] == K) {
				find = true;
				System.out.println(i);
			}
		}

		if (!find)
			System.out.println(-1);
	}

	static void bfs(int start) {
		visited = new boolean[N + 1];
		Queue<Integer> check = new ArrayDeque<>();
		check.offer(start);
		visited[start] = true;

		int distance = 0;

		while (!check.isEmpty()) {
			int size = check.size();
			for (int i = 0; i < size; i++) {
				int curr = check.poll();
				min[curr] = distance;
				for (int next : road[curr]) {
					if (!visited[next]) {
						visited[next] = true;
						check.offer(next);
					}
				}
			}
			distance++;
		}
	}
}
