package 정광석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
3
KOREAKOREAKOREAKOREAKOREAKOREA
SAMSUNGSAMSUNGSAMSUNGSAMSUNGSA
GALAXYGALAXYGALAXYGALAXYGALAXY    
 */
public class SWEA2007_패턴마디의길이_Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine().trim());
		for(int tc = 1; tc<=t; tc++) {
			
			String line = br.readLine();
			char[] charline = line.toCharArray();
			
			int start = 0;
			int end = 0;
			for(int i=1; i<=10; i++) {
				int flag = 0;
				for(int j=0; j<i; j++) {
					if(charline[j] != charline[i+j]) {
						flag =1;
						break;
					}
				}
				if(flag==0) {
					sb.append("#"+tc+" ").append(i).append("\n");
					break;
				}
			}
			
			
			
			
			
		}
		System.out.println(sb.toString());
	}
}
