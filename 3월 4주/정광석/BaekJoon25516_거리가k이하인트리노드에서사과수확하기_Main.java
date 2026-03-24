package saffy_algo.BaekJoon.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon25516_거리가k이하인트리노드에서사과수확하기_Main {
	/*
	 * 0번 정점이 루트
	 * 모든 간선은 1
	 * 각 정점에는 사과 0 or 1 개
	 * 루트에서거리가 k 이하인 노드에 있는 사과 수확
	 * 수확 가능한 사과 개수
	 * 
	 * 트리를 만들고, 루트에서 거리를 bfs로 체크 
	 * 
	 * n이 크니까 List로 관리
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int n,k;
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		
		List<Integer>[] adj = new ArrayList[n];
		for(int i=0; i<n; i++) adj[i] = new ArrayList<>();
		
		
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int p, c;
			p = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			adj[p].add(c);
			
		}
		int[] appleCnt = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			appleCnt[i] = Integer.parseInt(st.nextToken());
		}
		
		
		//bfs
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0,0});//root, 거리
		int cnt = 0;
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int cur = temp[0];
			int dist = temp[1];
			
			
			if(dist<=k) {
				cnt += appleCnt[cur];
			}
			else {
				continue;
			}
			for(int child : adj[cur]) {
				q.offer(new int[] {child, dist+1});
			}
		}
		
		System.out.println(cnt);
		
	}

}
