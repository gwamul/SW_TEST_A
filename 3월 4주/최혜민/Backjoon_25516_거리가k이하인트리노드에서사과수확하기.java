import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Backjoon_25516_거리가k이하인트리노드에서사과수확하기 {
	static int N;
	static int D;
	static ArrayList<Integer>[] tree;
	static int[] apple;
	static int count;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		
		tree = new ArrayList[N];
		
		for(int i = 0; i < N; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			tree[p].add(c);
		}
		
		apple = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			apple[i] = Integer.parseInt(st.nextToken());
		}
		
		count = 0;
		findApple(0, 0);
		
		System.out.println(count);
	}
	
	static void findApple(int root, int distance) {
		if(apple[root] == 1) {
			count++;
		}
		if(distance == D) return;
		
		for(int child : tree[root]) {
			findApple(child, distance + 1);
		}
	}
}
