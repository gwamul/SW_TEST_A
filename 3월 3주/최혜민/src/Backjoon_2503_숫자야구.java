import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Backjoon_2503_숫자야구 {
	static int N;
	static class Hint {
		String number;
		int strike;
		int ball;
		
		public Hint(String number, int strike, int ball) {
			this.number = number;
			this.strike = strike;
			this.ball = ball;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		List<Hint> hint = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			hint.add(new Hint(sc.next(), sc.nextInt(), sc.nextInt()));
		}
		
		int answerCount = 0;
		
		for(int i = 1; i <= 9; i++) {
			for(int j = 1; j <= 9; j++) {
				if(i == j) continue;
				for(int k = 1; k <= 9; k++) {
					if(i == k || j == k) continue;
					String candidate = "" + i + j + k;
					
					if(check(candidate, hint)) {
						answerCount++;
					}
				}
			}
		}
		
		System.out.println(answerCount);
	}
	
	static boolean check(String candidate, List<Hint> hint) {
		for(Hint h : hint) {
			int strike = 0;
			int ball = 0;
			
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					if(candidate.charAt(i) == h.number.charAt(j)) {
						if(i == j) strike++;
						else ball++;
					}
				}
			}
			if(strike != h.strike || ball != h.ball) {
				return false;
			}
		}
		return true;
	}
}
