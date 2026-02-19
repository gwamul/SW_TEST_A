package 정광석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 
3 
3 1 3 31
5 5 8 15
7 17 12 24  
 */
public class SWEA1948_날짜계산기_Main {
	static int[] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc = 1; tc<=T; tc++) {
			
			int m1,d1,m2,d2;
			st = new StringTokenizer(br.readLine());
			m1 = Integer.parseInt(st.nextToken());
			d1 = Integer.parseInt(st.nextToken());
			m2 = Integer.parseInt(st.nextToken());
			d2 = Integer.parseInt(st.nextToken());
			
			
			
			
			
			
			
			sb.append("#"+tc+" ").append(getDays(m2,d2) - getDays(m1,d1)+1).append("\n");
		}
		System.out.println(sb.toString());
	}
	static int getDays(int m, int d) {
		int sum = 0;
		for(int i=1; i<m; i++) {
			sum += days[i];
		}
		sum += d;
		
		
		
		return sum;
		
	}
}
