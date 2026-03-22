package saffy_algo.BaekJoon.골드.골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon2589_보물섬_Main {
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static char[][] board;
	static boolean[][] visited;
	static int team = 1;
	static int n,m;
	static int sx = -1, sy = -1;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int maxDistance = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'L') {
                    maxDistance = Math.max(maxDistance, bfs(i, j));
                }
            }
        }

        System.out.println(maxDistance);
    }

    private static int bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        
        visited[x][y] = true;
        q.offer(new int[]{x, y, 0});
        
        int localMax = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int tx = curr[0];
            int ty = curr[1];
            int dist = curr[2];

            localMax = Math.max(localMax, dist);

            for (int i = 0; i < 4; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (board[nx][ny] == 'L' && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny, dist + 1});
                    }
                }
            }
        }
        return localMax;
    }
}
