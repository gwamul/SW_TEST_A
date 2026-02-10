package 정광석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1970_쉬운거스름돈_Main {
	
	static int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine().trim());
		for(int tc=1; tc<=t; tc++) {
			sb.append("#").append(tc).append("\n");
			int n = Integer.parseInt(br.readLine().trim());
			
			for(int i=0; i<money.length; i++) {
				int bill = money[i];
				sb.append(n/bill + " ");
				n = n%bill;
			}
			
			
			
			
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
