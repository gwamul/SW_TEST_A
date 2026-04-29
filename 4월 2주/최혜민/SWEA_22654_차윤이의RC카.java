import java.util.Scanner;

public class SWEA_22654_차윤이의RC카 {
	static int N;
	static char[][] field;
	static int Q;
	static int d;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int startr, startc;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();

			field = new char[N][N];

			for (int i = 0; i < N; i++) {
				String line = sc.next();
				for (int j = 0; j < N; j++) {
					field[i][j] = line.charAt(j);
					if (field[i][j] == 'X') {
						startr = i;
						startc = j;
					}
				}
			}

			Q = sc.nextInt();
			System.out.print("#" + tc + " ");
			for (int i = 0; i < Q; i++) {
				d = 0;
				int M = sc.nextInt();
				String line = sc.next();

				int r = startr;
				int c = startc;
				for (int j = 0; j < M; j++) {
					char cn = line.charAt(j);

					if (cn == 'A') {
						r = r + dr[d];
						c = c + dc[d];

						if (r < 0 || r >= N || c < 0 || c >= N || field[r][c] == 'T') {
							r = r - dr[d];
							c = c - dc[d];
						}
					}

					else if (cn == 'R') {
						d = (d + 1) % 4;
					}

					else if (cn == 'L') {
						d = (d + 3) % 4;
					}
				}
				if (field[r][c] == 'Y') {
					System.out.print("1 ");
				}
				else {
					System.out.print("0 ");
				}
			}

			System.out.println();
		}
	}
}
