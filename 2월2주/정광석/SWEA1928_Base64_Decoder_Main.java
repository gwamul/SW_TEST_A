package 정광석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1928_Base64_Decoder_Main {
	
	
	
	static String BASE64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		
		for(int tc=1; tc<=T; tc++) {
			sb.append("#"+tc+" ");
			String input = br.readLine();
			
			int Buffer = 0; //24비트
			int cnt = 0;
			for(int i=0; i<input.length(); i++) {
				Buffer <<= 6;
				Buffer |= BASE64.indexOf(input.charAt(i));
				cnt ++;
				if(cnt == 4 || i>=input.length()-1) {
					sb.append(decode(Buffer));
					Buffer = 0;
					cnt=0;
				}
				
			}
			
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static String decode(int in) {
		StringBuilder sb = new StringBuilder();
		for(int i=2; i>=0; i--) {
			int index = (in >> (8*i)) & ((1<<8) -1);
			System.out.println(index);
			char temp = (char)index;
			//System.out.println("temp : " + temp);
			sb.append(temp);
			
					
		}
		
		return sb.toString();
	}
}
