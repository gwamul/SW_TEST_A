package 정광석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1926_간단한369게임_Main {
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=n; i++) {
			sol(i);
		}
		System.out.println(sb.toString());
	}
	
	
	static void sol(int i) {
		int a = i;
		int cnt = 0;
		while(a>0) {
			int t = a%10;
			if(t == 3 || t==6 || t==9) cnt++;
			a = a/10;
		}
		if(cnt>0) {
			for(int s=0; s<cnt; s++) {
				sb.append("-");
				
			}
		}else {
			sb.append(i);
		}
		sb.append(" " );
	}
}
