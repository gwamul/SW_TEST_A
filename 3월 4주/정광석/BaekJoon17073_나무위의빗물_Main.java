package saffy_algo.BaekJoon.골드.골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon17073_나무위의빗물_Main {
	/*
	 * 결과적으로는 리프노드에 모든 물이 쌓인다.
	 * 루트 노드에서 물이 나가기 시작, 
	 * 결국 기댓값 > 0 == 리프 노드들
	 * 전체 물은 리프 노드에 모두 나눠져있을 것.
	 * w / 리프 노드 개수
	 * 
	 * 리프 노드의 개수를 세라
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int n;
		n = Integer.parseInt(st.nextToken());
		double w = Integer.parseInt(st.nextToken());
		
		int parents[] = new int[n+1];
		List<Integer>[] childrens = new ArrayList[n+1];
		for(int i=0; i<=n; i++) childrens[i] = new ArrayList<>();
		
		List<Integer>[] adj = new ArrayList[n+1];
		for(int i=1; i<=n; i++) adj[i] = new ArrayList<>();
		
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int u,v;
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			adj[u].add(v);
			adj[v].add(u);
		}
		
		
		parents[1] = 0;
		childrens[0].add(1);
		
		boolean[] visited = new boolean[n+1];
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(1);
		visited[1] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int next : adj[cur]) {
				if(visited[next]) continue;
				q.offer(next);
				childrens[cur].add(next);
				parents[next] = cur;
				visited[next] = true;
			}
		}
		
		//System.out.println(Arrays.toString(parents));
		int leafCount = 0;
		for(int i=0; i<=n; i++) {
			if(childrens[i].isEmpty()) leafCount++;
		}
		System.out.println(w / leafCount);
		
		
			
	}
}
