package BJ_3월4주차;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ25516_거리가k이하인트리노드에서사과수확하기 {
	//bfs, dfs가 둘다 가능한 것 같은데 최적 알고리즘????
	static int[] visited;
	static ArrayList<Integer>[] adj;
	static int V, E, N;
	static int cnt;
	static int[] ap;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		V = sc.nextInt();
		E = V - 1;

		N = sc.nextInt();
		adj = new ArrayList[V];

		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			adj[a].add(b);
		}

		ap = new int[V];
		for (int i = 0; i < V; i++) {
			ap[i] = sc.nextInt();
		}

		dfs(0, 0);

		System.out.println(cnt);
	}

	static void dfs(int n, int dis) {
		if (ap[n] == 1) {
			cnt++;
		}

		if (dis == N)
			return;

		for (int x : adj[n]) {
			dfs(n, dis + 1);
		}
	}

}
