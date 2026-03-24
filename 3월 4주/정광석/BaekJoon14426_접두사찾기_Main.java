package saffy_algo.BaekJoon.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BaekJoon14426_접두사찾기_Main {
	
	static class Node{
		HashMap<Character, Node> child;
		
		boolean leafNode;

		public Node() {
			super();
			this.child = new HashMap<>();
			this.leafNode = false;
		}
	}
	
	static class Trie{
		Node root;
		
		public Trie() {
			this.root = new Node();
		}
		
		public void insert(String str) {
			Node node = this.root;
			
			for(int i=0; i<str.length(); i++) {
				char c = str.charAt(i);
				
				node.child.putIfAbsent(c, new Node());
				node = node.child.get(c);
			}
			
			node.leafNode = true;
		}
		
		public boolean search(String str) {
			Node node = this.root;
			
			for(int i=0; i<str.length(); i++) {
				char c = str.charAt(i);
				if(node.child.containsKey(c)) {
					node = node.child.get(c);
				}else {
					return false;
				}
			}
			
			return true;
		}
		
		public boolean delete(String str) {
			boolean result = delete(this.root , str, 0);
			return result;
		}
		
		
		private boolean delete(Node node, String str, int idx) {
			char c = str.charAt(idx);
			if(!node.child.containsKey(c)) return false;
			
			Node cur = node.child.get(c);
			idx ++; 
			if(idx == str.length()) {
				if(!cur.leafNode) return false;
				
				cur.leafNode = false;
				
				if(cur.child.isEmpty()) node.child.remove(c);
			}else {
				if(!this.delete(cur, str, idx)) return false;
				if(!cur.leafNode && cur.child.isEmpty()) node.child.remove(c);
				
			}
			return true;
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Trie tree = new Trie();
		int cnt = 0;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for(int i=0; i<n; i++) {
			String line = br.readLine();
			tree.insert(line);
		}
		for(int i=0; i<m; i++) {
			String line = br.readLine();
			if(tree.search(line)) cnt++;
		}
		System.out.println(cnt);
		
		
	}
}	
