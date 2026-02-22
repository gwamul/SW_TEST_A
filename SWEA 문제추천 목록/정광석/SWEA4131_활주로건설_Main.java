package 정광석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
2
6 2
3 3 3 2 1 1
3 3 3 2 2 1
3 3 3 3 3 2
2 2 3 2 2 2
2 2 3 2 2 2
2 2 2 2 2 2
6 4
3 2 2 2 1 2
3 2 2 2 1 2
3 3 3 3 2 2
3 3 3 3 2 2
3 2 2 2 2 2
3 2 2 2 2 2
 */
public class SWEA4131_활주로건설_Main {
	static int n,x;
	static int[][] board;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken()); //활주로 길이
			
			board = new int[n][n];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int answer = 0;
			for (int i = 0; i < n; i++) {
                if (checkPath(board[i])) answer++;
                
                
                int[] col = new int[n];
                for (int j = 0; j < n; j++) {
                    col[j] = board[j][i];
                }
                if (checkPath(col)) answer++;
            }
				
			
			
			
			
			sb.append("#").append(tc).append(" ");
			sb.append(answer);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	static boolean checkPath(int[] line) {
        boolean[] visited = new boolean[n]; 

        for (int i = 0; i < n - 1; i++) {
            if (line[i] == line[i + 1]) continue;
            if (Math.abs(line[i] - line[i + 1]) > 1) return false;

          
            if (line[i] < line[i + 1]) {
                for (int j = i; j > i - x; j--) {
                    if (j < 0 || line[j] != line[i] || visited[j]) return false;
                    visited[j] = true;
                }
            }
         
            else {
                for (int j = i + 1; j <= i + x; j++) {
                    if (j >= n || line[j] != line[i + 1] || visited[j]) return false;
                    visited[j] = true;
                }
            }
        }
        return true;
    }
}
