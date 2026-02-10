package 정광석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1859_백만장자프로젝트_Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] price = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			
			long earn = 0;
			int cnt = 0;
			int max_value = Integer.MIN_VALUE;
			int buy_price = 0;
			for(int i=n-1; i>=0; i--) {
				//뒤에 있는 값이 큰 값, 즉 오름차순일 때 산다.
				if(price[i] > max_value) {
					max_value = price[i];
				}
				earn += max_value - price[i];
			}
			sb.append("#").append(tc).append(" ").append(earn + "\n");
			
		}
		System.out.println(sb.toString());
	
	}
	
}
