package saffy_algo.BaekJoon.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2503_숫자야구_Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        boolean[] able = new boolean[1000];
        for(int i = 123; i <= 999; i++) {
            int a = i / 100;
            int b = (i % 100) / 10;
            int c = i % 10;
            
            if(a == 0 || b == 0 || c == 0) continue;
            if(a == b || b == c || c == a) continue;
            able[i] = true;
        }

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            
            int first = num / 100;
            int second = (num % 100) / 10;
            int third = num % 10;
            
            for(int i = 123; i <= 999; i++) {
                if(!able[i]) continue; // 이미 제외된 후보는 패스

                int a = i / 100;
                int b = (i % 100) / 10;
                int c = i % 10;

                int istrike = 0, iball = 0;

                if(first == a) istrike++;
                if(second == b) istrike++;
                if(third == c) istrike++;
                
                if(first == b || first == c) iball++;
                if(second == a || second == c) iball++;
                if(third == a || third == b) iball++;

                if(istrike != strike || iball != ball) {
                    able[i] = false;
                }
            }
        }

        int cnt = 0;
        for(int i = 123; i <= 999; i++) {
            if(able[i]) cnt++;
        }
        System.out.println(cnt);
    }
}
