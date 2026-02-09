package 정광석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1940_가랏RC카_Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=t; tc++) {
			int v = 0;
			int dist = 0;
			int n = Integer.parseInt(br.readLine()); //cmd 개수
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				
				int cmd = Integer.parseInt(st.nextToken());
				if(cmd == 0) {
					dist += v;
				}
				else if(cmd == 1) {
					//가속
					//(v  + ( v + a ) ) / 2
					int a = Integer.parseInt(st.nextToken());
					v = v+a;
					dist += v;
					
				}else if(cmd == 2) {
					// 가속
					int a = Integer.parseInt(st.nextToken());
					v -= a;
					if(v<0) v = 0;
					dist += v;
				}
				
			}
			sb.append("#").append(tc).append(" ").append(dist).append("\n");
			
		}
		System.out.println(sb.toString());
	}
}