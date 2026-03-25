package saffy_algo.BaekJoon.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon11725_트리의부모찾기_Main {
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		List<Integer>[] adj = new ArrayList[n+1];
		for(int i=1; i<=n; i++) adj[i] = new ArrayList<>();
		int[] parents = new int[n+1];
		boolean[] visited = new boolean[n+1];
		
		for (int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a,b;
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(1);
		visited[1] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int next : adj[cur]) {
				if(visited[next]) continue;
				q.offer(next);
				visited[next] = true;
				parents[next] = cur;
			}
		}
		//System.out.println(Arrays.toString(parents));
		
		for(int i=2; i<=n; i++) {
			sb.append(parents[i]).append("\n");
		}
		System.out.println(sb);
		
	}
}
