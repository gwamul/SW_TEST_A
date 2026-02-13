package 정광석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 홏수 : 물 준 나무가 1 자란다.
 * 짝수 : 물 준 나무가 2 자란다.
 * 물을 안 줄수도 있음
 * 
 * 
 * 모든 나무의 키가 처음에 가장 키가컸던 나무와 갔도록 할 수 있는 최소 날짜 수
 * 
 * 
 * 4 2 -> 
 * 
 * N : 나무가 100그루 있을 수도 있음
 * 
 * 나무 높이는 최대 120까지
 * 
 * 모든 나무의 키가 처음에 가장 키가 컸던 나무와 같도록 할 수 있는 최소 날 짜 수
 * 
 * 가능한 one, two의 개수가 일치해야 한다.
 */
public class SWEA14510_나무높이_Main2{

	static int[] trees;
	static int max_height;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
        	
        	int n = Integer.parseInt(br.readLine());
        	trees = new int[n];
        	max_height = Integer.MIN_VALUE;
        	st = new StringTokenizer(br.readLine());
        	for(int i=0; i<n; i++) {
        		trees[i] = Integer.parseInt(st.nextToken());
        		max_height = Math.max(trees[i], max_height);
        	}
        	
        	int one = 0;
        	int two = 0;
        	int days = 0;
        	for(int i=0; i<n; i++) {
        		int diff = max_height - trees[i];
        		one += diff/3;
        		two += diff/3;
        		if(diff%3 == 2) two+=1;
        		else if(diff%3 == 1) one+=1;
        	}
        	System.out.println("#"+tc+" 필요한 one, two 개수 >> one: "+ one + " two: " + two);
        	
        	if (two > one) {
        	    while (two > one + 1) {  
        	        two--;
        	        one += 2;
        	    }
        	    
        	    if (one > two) {  
        	        days = one * 2 - 1;
        	    } else if (two > one) {
        	        days = two * 2;
        	    } else {  
        	        days = one * 2;
        	    }
        	} else if (one > two) {
        	    days = one * 2 - 1;
        	} else {
        	    days = one * 2;
        	}
        	
        	
        	
        	
        	
        	sb.append("#"+tc+" ").append(days).append("\n");
        }
        System.out.println(sb.toString());
        
    }
}
