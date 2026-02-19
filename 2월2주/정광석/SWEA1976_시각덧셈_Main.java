package 정광석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
3 
3 17 1 39
8 22 5 10
6 53 2 12  
 */
public class SWEA1976_시각덧셈_Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        
        int T = Integer.parseInt(br.readLine().trim());
        for(int tc = 1; tc <= T; tc++) {
        	
        	int h1, m1, h2, m2;
        	st = new StringTokenizer(br.readLine());
        	h1 = Integer.parseInt(st.nextToken());
        	m1 = Integer.parseInt(st.nextToken());
        	h2 = Integer.parseInt(st.nextToken());
        	m2 = Integer.parseInt(st.nextToken());
        	
        	
        	int minuteSum = m1 + m2;
        	
        	int newHour = minuteSum / 60;
        	int newMinute = minuteSum % 60;
        	
        	newHour += h1 + h2;
        	int dehour = (newHour-1)/12;
        	newHour -= dehour*12;
        	
        	
        	
        	
        	
        	sb.append("#"+tc+ " ").append(newHour).append(" ").append(newMinute).append("\n");
        }
        System.out.println(sb.toString());
    }
    
}
