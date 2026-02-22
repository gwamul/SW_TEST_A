package 정광석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA4130_특이한자석_Main {

	/*
	 * 
	 * 
	 * 
1
2
0 0 1 0 0 1 0 0
1 0 0 1 1 1 0 1
0 0 1 0 1 1 0 0
0 0 1 0 1 1 0 1
1 1
3 -1
	 */

	static int T;
	static int[][] board;
	static int[] top;
	static int[] d;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<= T; tc++) {
			sb.append("#").append(tc).append(" " );
			top = new int[4];
			board = new int[4][8];
			
			int answer= 0 ;

			int k = Integer.parseInt(br.readLine());

			for(int i=0; i<4; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<8; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine());
				int selected = Integer.parseInt(st.nextToken()) - 1;
				int dir = Integer.parseInt(st.nextToken());

				sol(selected, dir);
			}
			//input done
			for(int i=0; i<4; i++) {
				if(board[i][top[i]] == 1) {
					answer += Math.pow(2, i);
				}
			}


			sb.append(answer).append("\n");
		}



		System.out.println(sb.toString());
	}

	static void debug() {
		System.out.println("d");
		System.out.println(Arrays.toString(d));
		System.out.println();
		System.out.println("top");
		System.out.println(Arrays.toString(top));
	}
	static void sol(int selected, int dir) {
		//입력 받은 바퀴를 dir 방향으로 돌린다
		d = new int[4];
		d[selected] = dir;
		//debug();
		rotRight(selected, dir);
		//debug();
		rotLeft(selected, dir);
		//debug();
		for(int i=0; i<4; i++) {
			top[i] = (top[i] - d[i] + 8)%8;
		}

	}
	static void rotRight(int selected, int dir) {
		if(selected == 3) return;
		int now = selected + 1;
		if(board[selected][(top[selected]+2)%8] == board[now][(top[now]+6)%8]) {
			//극이 같다면 회전 안됨
			return;
		}else {
			d[now] = -dir;
			rotRight(now, -dir);
			
		}


	}

	static void rotLeft(int selected, int dir) {
		if(selected == 0) return;
		int now = selected - 1;
		if(board[selected][(top[selected]+6)%8] == board[now][(top[now]+2)%8]) {
			//극이 같다면 회전 안됨
			return;
		}else {
			d[now] = -dir;
			rotLeft(now, -dir);
		}


	}

}
