package 정광석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA1983_조교의성적매기기_Main {
	static String[] grades = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			
			int n, k;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			Double[] scores = new Double[n];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int m = Integer.parseInt(st.nextToken());
				int f = Integer.parseInt(st.nextToken());
				int h = Integer.parseInt(st.nextToken());
				double total = 0.35*m + 0.45*f + 0.2*h;
				scores[i] = total;
			}
			
			double kScore = scores[k-1];
			
			Arrays.sort(scores, Collections.reverseOrder());
			//System.out.println(Arrays.toString(scores));
			int rank = 0;
			for(int i = 0; i<n; i++) {
				if(scores[i] == kScore) {
					rank = i;
					break;
				}
			}
			//System.out.println((1+rank)/n*10);
			
			sb.append("#").append(tc).append(" ").append(grades[10*rank/n ]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
