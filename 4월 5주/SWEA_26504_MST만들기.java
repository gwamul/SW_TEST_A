import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SWEA_26504_MST만들기 {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			int M = (N * (N - 1)) / 2;
			
			long[] c = new long[M];
			for(int i = 0; i < M; i++) {
				c[i] = sc.nextLong();
			}
			
			Arrays.sort(c);
			
			long min = 0;
			for(int i = 0; i < N - 1; i++) {
				min += c[i];
			}
			
			long max = 0;
			for(int i = 0; i < N - 2; i++) {
				int idx = (i * (i + 1)) / 2;
				max += c[idx];
			}
			max += c[M - (N - 1)];
			
			System.out.println(min + " " + max);
			
		}
	}
}
