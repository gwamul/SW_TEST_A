package saffy_algo.BaekJoon.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon13335_트럭_Main {
	static 	int n,w,l;
	static int[] board;
	static int min_time;
	/*
	 * 
	 * 다리를 지나가는 건 어떻게 구현해야 하나?
	 * 트럭은 다리 위에 w초 존재할 수 있음.
	 * 
	 * n이 작다.
	 * queue size가 작다.
	 * 큐에 0을 w 만큼 넣어 놓고, sum으로 총 합을 계속 가지고 있는다.
	 * 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();



		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // 트럭의 수
		w = Integer.parseInt(st.nextToken()); // 다리 기길이
		l = Integer.parseInt(st.nextToken());

		board = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			board[i] = Integer.parseInt(st.nextToken());
		}

		Queue<Integer> q = new ArrayDeque<>();
		for(int i=0; i<w; i++) q.offer(0);
		int sum = 0;
		int idx = 0;
		int time = 0;
		while(!q.isEmpty()) {
			int cross = q.poll();
			System.out.println(cross);
			sum -= cross;
			time++;
			if(idx < n) {

				if(sum + board[idx] <= l) {
					q.offer(board[idx]);
					sum += board[idx];
					idx++;
				}else {
					q.offer(0);
				}
			}
		}
		System.out.println("hello");
		System.out.println(time);

	}


}
