import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_17073_나무위의빗물 {
	static int N;
	static int W;
	static List<Integer>[] tree;
	static int leaf;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		W = sc.nextInt();
		
		tree = new ArrayList[N + 1];
		leaf = 0;
		
		for(int i = 0; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < N - 1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			tree[a].add(b);
			tree[b].add(a);
		}
		
		findLeaf();
		
		System.out.println((double)W / leaf);
	}
	
	static void findLeaf() {
		for(int i = 2; i <= N; i++) {
			if(tree[i].size() == 1) {
				leaf++;
			}
		}
	}
}
