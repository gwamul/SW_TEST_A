package 정광석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
N개의 블록
N번의 타격  기회. 타격 마다 하나 깰 수 있음.

블럭  깨지면 좌우 이웃 블록에 적힌 두 수의 곱만큼 점수를 얻는다.
좌 우 한쪽에만 이웃 블록이 있으면 이웃한 블록에 적힌 수만큼만
이웃블록이 없으면 ..해당 블록에 적힌 수 만큼만

 * 
 * 
 */
public class SWEA26071_블록제거게임2_Main {
	static int[] board;
	static boolean[] visited;
	static int n;
	static int max_point;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			n = Integer.parseInt(br.readLine());
			board = new int[n];
			visited = new boolean[n];
			max_point = Integer.MIN_VALUE;
			st= new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				board[i] = Integer.parseInt(st.nextToken());
			}
			
			
			sol(0, 0);
			
			sb.append("#").append(tc).append(" ");
			sb.append(max_point);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	static void sol(int cnt, int sum) {
		if(cnt == n) {
			max_point = Math.max(max_point, sum);
			return;
		}
		for(int i=0; i<n; i++) {
			if(visited[i]) continue;
			int left = findBlock(i, -1);
			int right = findBlock(i, 1);
			//System.out.println(left + " " + right);
			visited[i] = true;
			if(left == -1 && right == -1) {
				//왼쪽 오른쪽이 없으면
				sol(cnt+1, sum + board[i]);				
			}else if(left == -1) {
				//왼쪽만 없으면
				sol(cnt+1, sum + board[right]);
			}
			else if(right == -1) {
				//오른쪽만 없으면
				sol(cnt+1, sum+board[left]);
			}else {
				// 다 있으면
				sol(cnt+1, sum + board[left]*board[right]);
			}
			visited[i] = false;
		}
		
	}
	static int findBlock(int idx, int dir) {
		
		if(dir == 1) {
			for(int i = idx+1; i<n; i++) {
				if(visited[i]) continue;
				return i;
			}			
		}
		else {
			for(int i = idx-1; i>=0; i--) {
				if(visited[i]) continue;
				return i;
			}			
			
		}
		return -1;
		
	}
}
