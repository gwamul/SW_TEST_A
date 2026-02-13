package 정광석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1986_지그재그숫자_Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb.append("#"+tc+" ");
			
			int n = Integer.parseInt(br.readLine());
			if(n%2 == 0) {
				//짝수
				sb.append(-1 * (n/2));
			}
			else {
				sb.append( n-(n/2));
			}

			
			sb.append("\n");
			
		}
		System.out.println(sb.toString());
	}
}
