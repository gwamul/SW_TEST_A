import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Baekjoon_1068_트리 {
	static int N;
	static List<Integer>[] tree;
	static int cut;
	static int leaf;
	static int root;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		tree = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) {
			int p = sc.nextInt();

			if (p == -1) {
				root = i;
				continue;
			}
			tree[p].add(i);
		}

		cut = sc.nextInt();

		leaf = 0;
		if (cut == root) {
			leaf = 0;
		} else {
			findLeaf(root);
		}

		System.out.println(leaf);
	}

static void findLeaf(int root) {
	int cLeaf = 0;
		for(int c : tree[root]) {
			if(c != cut) {
				cLeaf++;
				findLeaf(c);
			}
			
		}
		if(cLeaf == 0) leaf++;
	}

}
