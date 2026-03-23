package BJ;

import java.util.Scanner;

public class BJ2503_숫자야구 {
	static int[] compareN;
	static int[] strike;
	static int[] ball;

	public static void main(String[] args) {
		/*
		 * 1. 해당 숫자가 0을 포함하고 있지 않은 지 확인하는 메서드 초기 int -> string 변환후 charAt 찍어서 비교하는 방식으로
		 * 접근했으나 추가적인 객체 생성으로 효율성이 보다 떨어짐
		 * 
		 * 2. 중복 유무를 검사하는 메서드 -> 현재는 k가 3에 불과하기 때문에 직접 비교를 사용해도 크게 문제가 없으나, k 값이 커져 확장성이
		 * 필요해지는 경우 불리언 배열 사용 권장
		 * 
		 * 3. 입력값 범위가 100이하라 크게 상관없으나 나중에 만개 이상의 데이터가 입력될 경우의 수를 대비해 bufferedreader 사용
		 * 습관화
		 */

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		compareN = new int[N]; //애초에 자릿수 나누어 n행 3열 2차원 행렬로 입력 받으면 연산 횟수 단축 가능
		strike = new int[N];
		ball = new int[N];

		for (int i = 0; i < N; i++) {
			compareN[i] = sc.nextInt();
			strike[i] = sc.nextInt();
			ball[i] = sc.nextInt();
		}

//		for (int i = 0; i < N; i++) {
//			System.out.println(compareN[i]+" "+strike[i]);
//		}
		int res=0;
		for (int n = 123; n < 989; n++) {
			int cnt = 0;
			if (!hasNotZero(n) || !notRepeated(n)) continue; 
			// 반복문을 모두 돈 이후 입력값들의 조건을 모두 통과한 경우의 수를 cnt해야 하기 때문에 예외 경우를
			//1-1. boolean default false flag 활용하거나
			//1-2. continue outer를 활용해 true일 때 cnt 하던지 
			//2. cnt가 N과 같은 지 비교하는 로직으로 구현 가능
			
			for (int i = 0; i < N; i++) {
				if ((strikeCheck(n, compareN[i]) == strike[i]) && (ballCheck(n, compareN[i]) == ball[i])) {
					cnt++;
				}
			}
			if(cnt==N) {
				res++;
			}
		}
		System.out.println(res);
	}
	
	public static boolean hasNotZero(int n) {
		while (n > 0) {
			if (n % 10 == 0) {
				return false;
			}
			n /= 10;
		}
		return true;
	}

	public static boolean notRepeated(int n) {
		// 100의 자릿수부터 비교
		int F = n / 100;
		n %= 100;
		int S = n / 10;
		n %= 10;
		int T = n;

		if (F == S || S == T || T == F) {
			return false;
		}
		return true;
	}

	// 볼이나 스트라이크값 비교 최적화 방법?
	public static int strikeCheck(int n, int cn) { // 자바 변수명 동시 변경 alt+shift+R
		int s = 0;
		int nF = n / 100;
		n %= 100;
		int nS = n / 10;
		n %= 10;
		int nT = n;

		int cF = cn / 100;
		cn %= 100;
		int cS = cn / 10;
		cn %= 10;
		int cT = cn;

		if (nF == cF) {
			s++;
		}
		if (nS == cS) {
			s++;
		}
		if (nT == cT) {
			s++;
		}
		return s;
	}

	public static int ballCheck(int n, int cn) {
		int b = 0;
		int nF = n / 100;
		n %= 100;
		int nS = n / 10;
		n %= 10;
		int nT = n;

		int cF = cn / 100;
		cn %= 100;
		int cS = cn / 10;
		cn %= 10;
		int cT = cn;

//		if (nF != cF&& (nF==cS||nF==cT)) {
//			b++;
//		}
//		if (nS!= cS&&(nS==cF||nS==cT)) {
//			b++;
//		}
//		if (nT!= cT&&(nT==cS||nT==cF)) {
//			b++;
//		}
		if (nF != cF) {
			if (nF == cS || nF == cT) {
				b++;
			}
		}
		if (nS != cS) {
			if (nS == cF || nS == cT) {
				b++;
			}
		}
		if (nT != cT) {
			if (nT == cS || nT == cF) {
				b++;
			}
		}
		return b;
	}
}
