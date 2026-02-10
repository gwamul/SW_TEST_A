package 정광석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1989_초심자의회문검사_Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine().trim());
		for(int tc = 1; tc<= t ;tc++) {
			int answer = 1;
			String str = br.readLine().trim();
			int s=0;
			int e = str.length()-1;
			while(s<=e) {
				//System.out.println(str.charAt(s) + " " + str.charAt(e));
				if(str.charAt(s) == str.charAt(e)) {
					//ok
					
					s++;
					e--;
				}else {
					answer = 0;
					break;
				}
			}
			
			
			
			
			sb.append("#"+tc).append(" ").append(answer+"\n");
		}
		System.out.println(sb.toString());



	}

}
