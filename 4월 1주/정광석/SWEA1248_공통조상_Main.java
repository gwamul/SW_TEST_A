package saffy_algo.SWEA.D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA1248_공통조상_Main {
	static List<Integer>[] adj;
	static int[] depth, parent, child;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			
			st = new StringTokenizer(br.readLine());
			int v,e,a,b;
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			adj = new ArrayList[v+1];
			depth = new int[v+1];
			parent = new int[v+1];
			child = new int[v+1];
			for(int i=1; i<=v; i++) adj[i] = new ArrayList<>();
			
			
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<e; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adj[from].add(to);
			}
			set_depth(1, 0);
			
			
			int lcaNode = lca(a,b);
			//System.out.println(lcaNode + " " + child[lcaNode]);
			
			
			sb.append("#").append(tc).append(" ").append(lcaNode).append(" ").append(child[lcaNode]).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int set_depth(int root, int val) {
		// TODO Auto-generated method stub
		parent[root] = val;
		depth[root] = depth[val] + 1;
		int cnt = 1;
		for(int next : adj[root]) {
			if(next == val) continue;
			cnt += set_depth(next, root);
		}
		child[root] = cnt;
		return cnt;
	}
	
	private static int lca(int a, int b) {
		int na = a;
		int nb = b;
		if(depth[a] < depth[b]) {
			na = b;
			nb = a;
		}
		
		while(depth[na] != depth[nb]) na = parent[na];
		
		while(na!=nb) {
			na = parent[na];
			nb= parent[nb];
		}
		return na;
	}
}	
