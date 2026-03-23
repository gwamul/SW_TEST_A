package BJ;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ1260_DFS와BFS {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int V=sc.nextInt();
		int E=sc.nextInt();
		int d=sc.nextInt();
		
		ArrayList<Integer>[] adj=new ArrayList[V+1];
		
		for(int i=1; i<=V; i++) {
			adj[i]=new ArrayList<>();
		}
		for(int i=0; i<E; i++) {
			int s=sc.nextInt();
			int e=sc.nextInt();
			
			adj[s].add(e);
			adj[e].add(s);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
		    sb.append(i).append(": ");
		    for (int next : adj[i]) {
		        sb.append(next).append(" ");
		    }
		    sb.append("\n");
		}
		System.out.print(sb);
	}

}
