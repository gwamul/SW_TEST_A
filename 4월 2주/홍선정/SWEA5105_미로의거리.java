package SWEA_D2;

	import java.io.*;
	import java.util.*;

	public class SWEA5105_미로의거리 {

	    static int N;
	    static char[][] maze;
	    static boolean[][] visited;
	    static int[][] dist;

	    static final int[] dr = {-1, 1, 0, 0};
	    static final int[] dc = {0, 0, -1, 1};

	    static class Node {
	        int r, c;

	        Node(int r, int c) {
	            this.r = r;
	            this.c = c;
	        }
	    }

	    static int bfs(int sr, int sc) {
	        ArrayDeque<Node> q = new ArrayDeque<>();
	        q.offer(new Node(sr, sc));
	        visited[sr][sc] = true;
	        dist[sr][sc] = 0;

	        while (!q.isEmpty()) {
	            Node cur = q.poll();

	            for (int d = 0; d < 4; d++) {
	                int nr = cur.r + dr[d];
	                int nc = cur.c + dc[d];

	                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
	                if (visited[nr][nc]) continue;
	                if (maze[nr][nc] == '1') continue;

	                if (maze[nr][nc] == '3') {
	                    return dist[cur.r][cur.c];
	                }

	                if (maze[nr][nc] == '0') {
	                    visited[nr][nc] = true;
	                    dist[nr][nc] = dist[cur.r][cur.c] + 1;
	                    q.offer(new Node(nr, nc));
	                }
	            }
	        }

	        return 0;
	    }

	    public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringBuilder sb = new StringBuilder();

	        int T = Integer.parseInt(br.readLine().trim());

	        for (int tc = 1; tc <= T; tc++) {
	            N = Integer.parseInt(br.readLine().trim());

	            maze = new char[N][N];
	            visited = new boolean[N][N];
	            dist = new int[N][N];

	            int sr = -1, sc = -1;

	            for (int i = 0; i < N; i++) {
	                String line = br.readLine().trim();
	                for (int j = 0; j < N; j++) {
	                    maze[i][j] = line.charAt(j);
	                    if (maze[i][j] == '2') {
	                        sr = i;
	                        sc = j;
	                    }
	                }
	            }
	            int answer = bfs(sr, sc);
	            sb.append("#").append(tc).append(" ").append(answer).append("\n");
	        }

	        System.out.print(sb);
	    }
	}

