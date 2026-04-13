import java.util.LinkedList;
import java.util.Scanner;

public class Baekjoon_13023_ABCDE {
	static int N;
	static int M;
	static LinkedList<Integer>[] friend;
	static boolean[] visited;
	static boolean find;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		friend = new LinkedList[N];
		
		for(int i = 0; i < N; i++) {
			friend[i] = new LinkedList<>();
		}
		
		for(int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			friend[from].add(to);
			friend[to].add(from);
		} //입력
		
		find = false;
		for(int i = 0; i < N; i++) {
			visited = new boolean[N];
			dfs(i, 0);
			if(find) break;
		}
		System.out.println(find ? 1 : 0);
	}
	
	static void dfs(int start, int depth) {
		if(depth == 4) {
			find = true;
			return;
		}
		
		visited[start] = true;
		
		for(int next : friend[start]) {
			if(!visited[next]) {
				dfs(next, depth + 1);
				
				if(find) return;
			}
		}
		
		visited[start] = false;
	}
}
