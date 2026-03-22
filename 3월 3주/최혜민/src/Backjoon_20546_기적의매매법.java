import java.util.Scanner;

public class Backjoon_20546_기적의매매법 {
	static int seed;
	static int[] days;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		days = new int[14];
		
		seed = sc.nextInt();
		
		for(int i = 0; i < 14; i++) {
			days[i] = sc.nextInt();
		}
		
		int BNP = jun(seed);
		int TIMING = sung(seed);
		
		if(BNP > TIMING) {
			System.out.println("BNP");
		} else if(TIMING > BNP) {
			System.out.println("TIMING");
		} else {
			System.out.println("SAMESAME");
		}
	}
	
	static int jun(int seed) {
		int total = 0;
		int stock = 0;
		
		for(int i = 0; i < 14; i++) {
			if(days[i] <= seed) {
				stock += seed / days[i];
				seed %= days[i];
			}
		}
		
		total = seed + (days[13] * stock);
		
		return total;
	}
	
	static int sung(int seed) {
		int total = 0;
		int stock = 0;
		int upCount = 0;
		int downCount = 0;
		
		for(int i = 1; i < 14; i++) {
			if(days[i - 1] < days[i]) {
				upCount++;
				downCount = 0;
			}
			else if(days[i - 1] > days[i]) {
				downCount++;
				upCount = 0;
			} else {
				upCount = 0;
				downCount = 0;
			}
			
			if(upCount >= 3) {
				seed += days[i] * stock;
				stock = 0;
			}
			else if(downCount >= 3) {
				stock += seed / days[i];
				seed %= days[i];
			}
		}
		
		total = seed + (stock * days[13]);
		
		return total;
	}
}
