import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    
    static int N, M, K, X;
    static ArrayList<Integer>[] graph;
    static int[] distance;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        N = sc.nextInt(); 
        M = sc.nextInt(); 
        K = sc.nextInt(); 
        X = sc.nextInt(); 

        ArrayList<Integer>[] tempGraph = new ArrayList[N + 1];
        graph = tempGraph;
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v); 
        }

        distance = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            distance[i] = -1; 
        }

        bfs(X);

        boolean found = false;
        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) {
                System.out.println(i);
                found = true;
            }
        }

        if (!found) {
            System.out.println("-1");
        }

        sc.close();
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        distance[start] = 0; // 출발점 거리 0

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph[current]) {
                if (distance[next] == -1) {
                    distance[next] = distance[current] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}