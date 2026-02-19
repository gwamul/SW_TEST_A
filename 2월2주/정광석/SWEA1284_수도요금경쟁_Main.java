package 정광석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1284_수도요금경쟁_Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        
        int T = Integer.parseInt(br.readLine());
        for(int tc= 1; tc<=T; tc++) {
        	
        	int p,q,r,s,w;
        	st = new StringTokenizer(br.readLine());
        	
        	p = Integer.parseInt(st.nextToken()); // A사 리터당 p
        	q = Integer.parseInt(st.nextToken()); // B사 기본요금
        	r = Integer.parseInt(st.nextToken()); // B사 R리터 이하로 사용했으면 기본요금만
        	s = Integer.parseInt(st.nextToken()); // B사 초과 리터당 리터당 s
        	w = Integer.parseInt(st.nextToken()); // 한달 사용한 요금
        	
        	
        	int aPrice = p*w;
        	int bPrice = q;
        	if(w>r) {
        		//사용량 초과
        		bPrice += (w-r)*s;
        	}
        	
        	
        	
        	sb.append("#"+tc+" ").append(Math.min(aPrice, bPrice)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
