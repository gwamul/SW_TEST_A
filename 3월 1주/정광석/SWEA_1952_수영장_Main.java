package 정광석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 
 * 
2
10 40 100 300   
0 0 2 9 1 5 0 0 0 0 0 0
10 100 50 300   
0 0 0 0 0 0 0 0 6 2 7 8
 */
public class SWEA_1952_수영장_Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            int[] price = new int[4]; // 1일, 1달, 3달, 1년
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }

            int[] plan = new int[13]; // 1월~12월
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 12; i++) {
                plan[i] = Integer.parseInt(st.nextToken());
            }

            // dp[i] : i월까지의 최소 이용 요금
            int[] dp = new int[13];

            for (int i = 1; i <= 12; i++) {
                // 1. 1일권으로 이번 달을 보내는 경우와 1달권을 끊는 경우 중 최선 선택
                dp[i] = dp[i - 1] + Math.min(plan[i] * price[0], price[1]);

                // 2. 3달권을 사용하는 경우와 비교 (3월 이후부터 가능)
                if (i >= 3) {
                    dp[i] = Math.min(dp[i], dp[i - 3] + price[2]);
                } else {
                    // 1월, 2월에도 3달권을 미리 끊는 것이 이득일 수 있음
                    dp[i] = Math.min(dp[i], price[2]);
                }
            }

            // 3. 마지막으로 1년권과 최종 비교
            int min_price = Math.min(dp[12], price[3]);
            sb.append("#").append(tc).append(" ").append(min_price).append("\n");
        }
        System.out.println(sb.toString());
    }
}
