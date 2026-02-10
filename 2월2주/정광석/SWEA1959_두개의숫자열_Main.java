package 정광석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 *
2
3 5
1 5 3
3 6 -7 5 4
7 6
6 0 5 5 -1 1 6
-4 1 8 7 -9 3
 * 
 */
public class SWEA1959_두개의숫자열_Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
	
		
		int t = Integer.parseInt(br.readLine().trim());
		for(int tc=1; tc<=t; tc++) {
			int answer = 0;
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] a = new int[n];
			int[] b = new int[m];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<m; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}
			if(n<m) {
				answer = sol(a,b);
			}else {
				answer = sol(b,a);
			}
			
			
			sb.append("#").append(tc).append(" ").append(answer);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static int sol(int[] small, int[] big) {
		int max_x = Integer.MIN_VALUE;
		for(int i=0; i<=big.length-small.length; i++) {
			int product_x = 0;
			for(int j=0; j<small.length; j++) {
				product_x += big[i+j]*small[j];
				
			}
			//System.out.println(product_x);
			max_x = Math.max(max_x, product_x);
		}
		
		
		return max_x;
	}
}
