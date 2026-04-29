package saffy_algo.BaekJoon.골드.골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon13023_ABCDE_Main {
	static int n,m;
	static List<Integer>[] graph;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new ArrayList[n];
		visited = new boolean[n];
		for(int i=0; i<n; i++) graph[i] = new ArrayList<>();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a,b;
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		boolean flag = false;
		for(int i=0; i<n; i++) {
			if(sol(0, i)) {
				flag = true;
				break;
			}
		}
		System.out.println(flag ? 1 : 0);
	}
	
	static boolean sol(int cnt, int cur) {
		if(cnt >= 5 ) return true;
		
		for(int next : graph[cur]) {
			if(visited[next]) continue;
			visited[next] = true;
			if(sol(cnt+1, next)) return true;
			visited[next] = false;
		}
		
		
		return false;
	}
}
