package 정광석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 
 * 
5
1 2 2
1 2 3
1 2 4
1 2 5
10 7 1293
 */
public class SWEA21425_plusequal_Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		int t = Integer.parseInt(br.readLine());
		for(int tc=0; tc<t; tc++) {
			st = new StringTokenizer(br.readLine());
			int a,b,n;
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			
			sb.append(sol(a,b,n)).append("\n");
		}
		System.out.println(sb.toString());
	}
	public static int sol(int a, int b, int n) {
		// x + y , y + (x + y) 
		int x = a;
		int y = b;
		int cnt = 0;
		while(true) {
			if(x>n || y>n) return cnt;
			if(x<y) {
				x = x+y;
			}
			else {
				y = x+y;
			}
			cnt++;
			
		}
		
		
	}
}
