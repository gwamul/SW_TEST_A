package BJ_3월4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ11725_트리의부모찾기 {
	/*
	 * 자바의 기본 스택 크기는 보통 1MB N=10만이라면 편향 트리 형태라면 재귀 깊이가 10만 단계로 stackoverflow 에러.
	 * dfs는 n=10000 인 경우까지만 시도해볼만 함
	 * 
	 * 루트 없는 트리 간선 개수 = 정점 -1;
	 */

	static boolean[] visited;
	static int[] p;
	static List<Integer>[] adj;

	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;

		//정점 1부터 시작
		adj = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		
		//간선 개수 n-1!!!!!!!!!!!!!!!!!!!!
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adj[a].add(b);
			adj[b].add(a);
		}
		


		p = new int[N + 1];
		visited = new boolean[N + 1];
		
		bfs(1);

		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= N; i++) {
			sb.append(p[i]).append("\n");

		}
		System.out.println(sb);
	}

	static void bfs(int n) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(n);
		visited[n] = true;

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int x : adj[cur]) {
				if (!visited[x]) {
					visited[x] = true;
					p[x] = cur;
					//다음 탐색을 위해 반복 문 안 돌고 있는 현재 x 큐 삽입 
					q.add(x);
				}
			}
		}
	}
}
