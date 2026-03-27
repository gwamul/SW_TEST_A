import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Backjoon_11725_트리의부모찾기 {
	static int N;
	static List<Integer>[] tree;
	static int[] parent;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		tree = new ArrayList[N + 1];
		
		for(int i = 0; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}
		
		parent = new int[N + 1];
		
		for(int i = 0; i < N - 1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			tree[a].add(b);
			tree[b].add(a);
		}
		
		bfs(1);
		
		for(int i = 2; i <= N; i++) {
			System.out.println(parent[i]);
		}
	}
	
	static void bfs(int start) {
		boolean[] visited = new boolean[N + 1];
		visited[start] = true;
		
		Queue<Integer> pfind = new ArrayDeque<>();
		pfind.offer(start);
		
		while(!pfind.isEmpty()) {
			int p = pfind.poll();
			
			for(int c : tree[p]) {
				if(!visited[c]) {
					visited[c] = true;
					parent[c] = p;
					pfind.offer(c);
				}
			}
		}
	}
}
