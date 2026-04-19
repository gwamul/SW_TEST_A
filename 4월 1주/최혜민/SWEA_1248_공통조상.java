package D5;
import java.util.Scanner;

public class SWEA_1248_공통조상 {
	static int[][] tree;
	static int V;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			V = sc.nextInt();
			int E = sc.nextInt();
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			
			tree = new int[V + 1][3];
			
			for(int i = 0; i < E; i++) {
				int parent = sc.nextInt();
				int child = sc.nextInt();
				if(tree[parent][0] == 0)
					tree[parent][0] = child;
				else{
					tree[parent][1] = child;
				}
				tree[child][2] = parent;
			}
			
			int root = lowest(v1, v2);
			
			System.out.println("#" + tc + " " + root + " " + size(root));
		}
	}
	
	public static int lowest(int v1, int v2) {
		boolean[] visited = new boolean[V + 1];
		
		while(v1 != 0) {
			visited[v1] = true;
			v1 = tree[v1][2];
		}
		
		while(v2 != 0) {
			if(visited[v2] == true) return v2;
			v2 = tree[v2][2];
		}
		return 0;
	}
	
	public static int size(int root) {
		if(root == 0) return 0;
		return 1 + size(tree[root][0]) + size(tree[root][1]);
	}
}
