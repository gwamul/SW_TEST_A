package 정광석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1984_중간평균값구하기_Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
	
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=t; tc++) {
			int min_value = Integer.MAX_VALUE;
			int max_value = Integer.MIN_VALUE;
			int sum = 0;
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<10; i++) {
				int num = Integer.parseInt(st.nextToken());
				sum += num;
				min_value = Math.min(min_value, num);
				max_value = Math.max(max_value, num);
			}
			sum -= ( min_value + max_value);
			sb.append("#").append(tc).append(" " ).append((4+sum)/8).append("\n");
			
		} 
		System.out.println(sb.toString());
	}
}

