package 정광석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA2005_파스칼의삼각형_Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();


		int t = Integer.parseInt(br.readLine().trim());
		for(int tc=1; tc<=t; tc++) {
			int n = Integer.parseInt(br.readLine().trim());
			sb.append("#"+tc+"\n");
			sb.append(sol(n-1));
		}
		System.out.println(sb.toString());
	}
	public static String sol(int n) {
		StringBuilder sb = new StringBuilder();
		int[] nums = new int[n+1];

		for(int i=0; i<=n; i++) {
			nums[0] = 1;
			int temp;
			for(int j=i; j>0; j--) {
				nums[j] = nums[j-1]+ nums[j];
			}


			for(int j=0; j<=i; j++) {
				sb.append(nums[j]+" ");
			}
			sb.append("\n");

		}


		return sb.toString();
	}

}
