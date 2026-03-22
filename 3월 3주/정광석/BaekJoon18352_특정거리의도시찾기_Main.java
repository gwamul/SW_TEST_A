package saffy_algo.BaekJoon.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon18352_특정거리의도시찾기_Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		
		st = new StringTokenizer(br.readLine());
		int n,m,k,x;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		List<Integer>[] board = new ArrayList[n+1];
		for(int i=1; i<=n; i++) board[i] = new ArrayList<>();
		
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a,b;
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			board[a].add(b);
		}
		List<Integer> result = new ArrayList<>();
		boolean[] visited = new boolean[n+1];
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]); //오름차순 정렬
		pq.offer(new int[] {x, 0});
		visited[x] = true;
		while(!pq.isEmpty()) {
			int[] temp = pq.poll();
			int cur = temp[0];
			int cnt = temp[1];
			if(cnt == k) {
				result.add(cur);
				continue;
			}
			
			
			for(int next : board[cur]) {
				if(!visited[next]) {
					pq.offer(new int[] {next, cnt+1});
					visited[next] = true;
				}
			}
		}
		if(result.size() == 0) {
			System.out.println(-1);
			System.exit(0);
		}
		
		Collections.sort(result);
		for(int a: result) sb.append(a).append("\n");
		
		System.out.println(sb.toString());
	}
}
