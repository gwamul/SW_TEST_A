package saffy_algo.BaekJoon.골드.골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon1068_트리_Main {
	
	static int[] parent;
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		parent  = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			parent[i] = Integer.parseInt(st.nextToken());
		}
	
	
		int remove = Integer.parseInt(br.readLine());
		sol(remove);
		
		int ans = 0;
		for(int i=0; i<n; i++) {
			if(parent[i] == -888) continue;
			boolean flag = false;
			for(int j=0; j<n; j++) {
				if(i == parent[j]) {
					flag = true;
					break;
				}
			}
			if(flag) continue;
			else ans++;
		}
		//System.out.println(Arrays.toString(parent));
		System.out.println(ans);
	}
	
	static void sol(int start) {
		parent[start] = -888;
		for(int i=0; i<n; i++) {
			if(start == parent[i]) sol(i);
		}
	}
}
