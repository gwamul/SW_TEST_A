package D4;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1238_Contact {
	static int N;
	static int S;
	static List<Integer>[] contact; 
	static int[] count;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			N = sc.nextInt();
			S = sc.nextInt();
			contact = new ArrayList[101];
			visited = new boolean[101];
			count = new int[101];
			
			for(int i = 1; i <= 100; i++) {
				contact[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < N / 2; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				
				contact[from].add(to);
			}
			
			emergency(S);
			
			int maxidx = 0;
			for(int i = 1; i <= 100; i++) {
				if(count[i] >= count[maxidx]) {
					maxidx = i;
				}
			}
			
			System.out.println("#" + tc + " " + maxidx);
		}
	}
	
	static void emergency(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(start);
		visited[start] = true;
		count[start] = 1;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			for(int next : contact[curr]) {
				if(!visited[next]) {
					queue.add(next);
					visited[next] = true;
					count[next] = count[curr] + 1;
				}
			}
		}
	}
}
