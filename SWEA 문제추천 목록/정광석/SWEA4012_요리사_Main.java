package saffy_algo.SWEA.D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
10
4
0 5 3 8
4 0 4 1
2 5 0 3
7 2 3 0
 */
public class SWEA4012_요리사_Main2 {

    static int[][] board;
    static boolean[] visited;
    static int n;
    static int mindiff;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            n = Integer.parseInt(br.readLine());
            board = new int[n][n];
            mindiff = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

           
            visited = new boolean[n];
            combination(0,0);

            sb.append("#").append(tc).append(" ").append(mindiff).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void combination(int start, int count) {
        // N/2개를 다 뽑았을 때 점수 계산
        if (count == n / 2) {
            calculate();
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(i + 1, count + 1);
            visited[i] = false;
        }
    }
    
    public static void calculate() {
        int sumA = 0;
        int sumB = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i] && visited[j]) sumA += board[i][j];
                else if (!visited[i] && !visited[j]) sumB += board[i][j];
            }
        }
        mindiff = Math.min(mindiff, Math.abs(sumA - sumB));
    }
}