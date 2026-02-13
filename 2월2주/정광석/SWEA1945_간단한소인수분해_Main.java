package 정광석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1945_간단한소인수분해_Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc=1; tc<=T; tc++) {
			sb.append("#"+tc+" ");
			int n = Integer.parseInt(br.readLine());

			int a,b,c,d,e;
			a=b=c=d=e=0;
			while(true) {

				if(n%2==0) {
					a++;
					n/=2;
				}
				if(n%3==0){
					b++;
					n/=3;
				}
				if(n%5==0){
					c++;
					n/=5;
				}
				if(n%7==0){
					d++;
					n/=7;
				}
				if(n%11==0){
					e++;
					n/=11;
				}
				if(n==1) break;


			}
			sb.append(a+" ").append(b+" ").append(c+" ").append(d+" ").append(e+" ");



			sb.append("\n");

		}
		System.out.println(sb.toString());
	}

}
