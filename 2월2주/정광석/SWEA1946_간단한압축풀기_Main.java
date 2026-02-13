package 정광석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1946_간단한압축풀기_Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb.append("#"+tc+"\n");
			
			int n = Integer.parseInt(br.readLine());
			int cnt = 0;
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				char c =st.nextToken().charAt(0);
				int k = Integer.parseInt(st.nextToken());
				
				for(int j=0; j<k; j++) {
					sb.append(c);
					cnt ++; 
					if(cnt%10 == 0) sb.append("\n");
				}
			}

			
			sb.append("\n");
			
		}
		System.out.println(sb.toString());
	}
	
}
