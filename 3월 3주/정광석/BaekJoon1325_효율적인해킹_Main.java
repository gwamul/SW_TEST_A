package saffy_algo.BaekJoon.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
	
public class BaekJoon1325_효율적인해킹_Main {
    static int n, m;
    static List<Integer>[] board;
    static int[] counts;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new ArrayList[n + 1];
        counts = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            board[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a].add(b);
        }

        for (int i = 1; i <= n; i++) {
            sol(i);
        }

        int maxVal = 0;
        for (int i = 1; i <= n; i++) {
            maxVal = Math.max(maxVal, counts[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (counts[i] == maxVal) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    static void sol(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        boolean[] visited = new boolean[n + 1];
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : board[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    counts[next]++;
                    q.offer(next);
                }
            }
        }
    }
}