import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon_1325_효율적해킹 {
	static int N, M;
	static int[] count;
	static int max;
	static List<Integer>[] trust;
	static boolean[] hacked;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		trust = new ArrayList[N + 1];
		for(int i = 0; i <= N; i++) {
			trust[i] = new ArrayList<>();
		}
		max = Integer.MIN_VALUE;
		count = new int[N + 1];
		
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); //A
			int b = Integer.parseInt(st.nextToken()); //B를 신뢰한다
			
			trust[b].add(a);
			
		}
		
		
		hacked = new boolean[N + 1];
		for(int i = 1; i <= N; i++) {
			Arrays.fill(hacked, false);
			hacking(i);
		}
		
		for(int i = 1; i <= N; i++) {
			if(count[i] > max) max = count[i];
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			if(count[i] == max)
				sb.append(i).append(" ");
		}
		
		System.out.println(sb.toString());
		
		
	}
	
	static void hacking(int start) {
		hacked[start] = true;
		Queue<Integer> check = new ArrayDeque<>();
		check.offer(start);

		
		while(!check.isEmpty()) {
			int curr = check.poll();
			for(int next : trust[curr]) {
				if(hacked[next]) continue;
				hacked[next] = true;
				count[start]++;
				check.offer(next);
			}
			
		}
	}
}
