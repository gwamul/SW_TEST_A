package 정광석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA26070_보석수집로봇_Main {
    static int[][] apples;
    static int n, appleCnt;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine().trim());
            
            // 사과 번호를 인덱스로 사용 (1번~K번)
            apples = new int[n * n + 1][2];
            appleCnt = 0;

            // 시작점 (1, 1)
            apples[0][0] = 1;
            apples[0][1] = 1;

            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
               
                for (int j = 1; j <= n; j++) {
                    int val = Integer.parseInt(st.nextToken());
                    if (val != 0) {
                        apples[val][0] = i; // 행(x)
                        apples[val][1] = j; // 열(y)
                        if (val > appleCnt) appleCnt = val;
                    }
                }
            }

            int dir = 1; // 시작 방향: 동쪽(1)
            int sum = 0;

            // 0번(시작점)부터 사과 개수만큼 순차 이동
            for (int i = 0; i < appleCnt; i++) {
                int x = apples[i][0];
                int y = apples[i][1];
                int tx = apples[i + 1][0];
                int ty = apples[i + 1][1];

                int temp = gencnt(x, y, tx, ty, dir);
                sum += temp;
                dir = (dir + temp) % 4;
            }

            sb.append("#").append(tc).append(" ").append(sum).append("\n");
        }
        System.out.print(sb.toString());
    }

    public static int gencnt(int x, int y, int tx, int ty, int d) {
    	if (d == 0) {
            if (tx < x && ty == y) return 0; 
            if (ty > y) { 
                if (tx <= x) return 1;        
                return 2;                    
            }
            //if (tx > x && ty == y) return 2; 
            return 3;                       
        }
        
        if (d == 1) { // 동
            if (tx == x && ty > y) return 0; 
            if (tx > x) {
                if (ty >= y) return 1;       
                return 2;                   
            }
           // if (tx == x && ty < y) return 2;
            return 3;                               }
        
        if (d == 2) { // 남
            if (tx > x && ty == y) return 0; 
            if (ty < y) {
                if (tx >= x) return 1;       
                return 2;                    
            }
            //if (tx < x && ty == y) return 2; 
            return 3;                       
        }
        
        if (d == 3) { // 서
            if (tx == x && ty < y) return 0; 
            if (tx < x) {
                if (ty <= y) return 1;       
                return 2;                    
            }
           // if (tx == x && ty > y) return 2; 
            return 3;                      
        }
        
        return 0;
    }
}
