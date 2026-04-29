package SWEA_D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ13023_ABCDE {
	static ArrayList<Integer>[] adj;
	static boolean[] visited;
	static boolean flag=false;
	
	static int V, E;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int V=Integer.parseInt(st.nextToken());
		int E=Integer.parseInt(st.nextToken());
		
		
		adj=new ArrayList[V];
		visited=new boolean[V];
		for(int i=0; i<V; i++) {
			adj[i]=new ArrayList<>();
		}
		
		for(int i=0; i<E; i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			
			adj[s].add(e);
			adj[e].add(s);
		}
		
		
		for(int i=0; i<V; i++) {
			dfs(1,0);
			if(flag) break;
		}
		System.out.println();
		
	}
	static void dfs(int n, int depth) {
		if(depth==4) {
			flag=true;
			return;
		}
		
		visited[n]=true;
		
		for (int next : adj[n]) {
            if (!visited[next]) {
                dfs(next, depth + 1);
                if (flag) return;
            }
        }

        visited[n] = false; 
		
	}
	

}
