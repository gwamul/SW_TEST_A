package BJ;

import java.util.Scanner;

public class BJ20546_기적의매매법 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt();

		int[] stockP = new int[14];
		for (int i = 0; i < 14; i++) {
			stockP[i] = sc.nextInt();
		}

		if (BNP(M, stockP) > TIMING(M, stockP)) {
			System.out.println("BNP");
		} else if (BNP(M, stockP) < TIMING(M, stockP)) {
			System.out.println("TIMING");
		} else if (BNP(M, stockP) == TIMING(M, stockP)) {
			System.out.println("SAMESAME");
		}

	}

	public static int BNP(int M, int[] stockP) {
		int sSum = 0;
		for (int i = 0; i < 14; i++) {
			int purchase = M / stockP[i];
			M -= (purchase * stockP[i]);
			sSum += purchase;
		}
		return M + (stockP[13] * sSum);

	}

	public static int TIMING(int M, int[] stockP) {
		int sSum = 0;
		for (int i = 3; i < 14; i++) {
			if (stockP[i] < stockP[i - 1] && stockP[i - 1] < stockP[i - 2] && stockP[i - 2] < stockP[i - 3]) {
				int purchase = M / stockP[i];
				M -= (purchase * stockP[i]);
				sSum += purchase;
			}
			if (stockP[i] > stockP[i - 1] && stockP[i - 1] > stockP[i - 2] && stockP[i - 2] > stockP[i - 3]) {
				int sales = sSum * stockP[i];
				M += sales;
			}
		}
		return M + (stockP[13] * sSum);

	}
}