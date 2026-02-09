package 정광석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1204_최빈수구하기_Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=t; tc++) {
			int test_case = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] scores = new int[101];
			for(int i=0; i<1000; i++) {
				int s =  Integer.parseInt(st.nextToken());
				scores[s] += 1;
			}
			int max_cnt = Integer.MIN_VALUE;
			int max_cnt_num = 0;
			for(int i=0; i<101; i++) {
				if(max_cnt <= scores[i]) {
					max_cnt = scores[i];
					max_cnt_num = i;
				}
				
			}
			
			sb.append("#").append(test_case).append(" ").append(max_cnt_num).append("\n");
			
		}
		System.out.println(sb.toString());
	}
}
