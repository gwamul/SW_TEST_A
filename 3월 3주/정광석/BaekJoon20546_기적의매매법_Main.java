package saffy_algo.BaekJoon.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon20546_기적의매매법_Main {
	static int[] board;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		
		int cash = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		board = new int[14];
		for(int i=0; i<14; i++) board[i] = Integer.parseInt(st.nextToken());
		
//		System.out.println(junhyun(cash));
//		System.out.println(sungmin(cash));
		int a = junhyun(cash);
		int b = sungmin(cash);
		
		if(a>b) System.out.println("BNP");
		else if(a<b) System.out.println("TIMING");
		else System.out.println("SAMESAME");
	}
	
	
	
	static int junhyun(int cash) {
		//살 수 있으면 즉시 사고 팔지 않는다.
		int balance = cash;
		int cnt = 0;
		for(int i=0; i<14; i++) {
			int canbuy = balance / board[i];
			if(canbuy >= 1) {
				balance -= canbuy*board[i];
				cnt += canbuy;
			}
		}
		return balance + cnt*board[13];
		
	}
	
	static int sungmin(int cash) {
	    int balance = cash;
	    int cnt = 0;
	    int day = 0; // 연속 상승/하락 횟수

	    for (int i = 1; i < 14; i++) {
	        //전일 대비 주가 
	        if (board[i] > board[i - 1]) {
	            day = (day > 0) ? day + 1 : 1;
	        } else if (board[i] < board[i - 1]) {
	            day = (day < 0) ? day - 1 : -1;
	        } else {
	            day = 0;
	        }

	        if (day >= 3) {
	            balance += cnt * board[i];
	            cnt = 0;
	        } else if (day <= -3) {
	            int canBuy = balance / board[i];
	            cnt += canBuy;
	            balance -= canBuy * board[i];
	        }
	    }

	    return balance + cnt * board[13];
	}
}	
