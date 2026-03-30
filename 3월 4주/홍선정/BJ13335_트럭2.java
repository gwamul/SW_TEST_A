package BJ_3월4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ13335_트럭 {
	/*
	 * n개의 트럭
	 * w대의 트럭만 가능
	 * 다리 길이 w
	 * unit time 에 단위 길이만큼 이동
	 * 최대 가능 하중 L
	 */
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(st.nextToken()); //트럭 수
		int w=Integer.parseInt(st.nextToken()); // 다리 길이
		int L=Integer.parseInt(st.nextToken()); // 다리 최대하중
		
		Deque<Integer> trucks=new ArrayDeque<>();
		
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			trucks.add(Integer.parseInt(st.nextToken()));
		}
		
		Deque<Integer> bridge=new ArrayDeque<>();
		for(int i=0; i<w; i++) {
			bridge.add(0);
		}
		
		int time=0;
		int curW=0;
		while(!bridge.isEmpty()) {  
			time++;
			curW-=bridge.poll();
			
			if(!trucks.isEmpty()) {
				if(curW+trucks.peek()<=L) {
					int t=trucks.poll();
					bridge.add(t);
					curW+=t;
				}else {
					bridge.add(0);
				}
			}
		}
		System.out.println(time);

	}

}
