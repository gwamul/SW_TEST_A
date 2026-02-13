package 정광석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1966_숫자를정렬하자_Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb.append("#"+tc+" ");
			
			int n = Integer.parseInt(br.readLine());
			int[] nums = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(nums);
			for(int i=0; i<n; i++) {
				sb.append(nums[i] + " ");
			}
			
			sb.append("\n");
			
		}
		System.out.println(sb.toString());
	}
}
