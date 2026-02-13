package 정광석;

import java.util.Scanner;

/*
 * 아이디어 생각 10:19
 * Pass 성공 시간 : 10:38
 * 1295 -> 2590
 * 1,2,5,9 -> 0,1,2,5,9
 *
 * N, 2N ... kN 까지 받으면서
 * 특별한 알고리즘이 있는건  아니야.
 *
 * 숫자를 분해해서, 한자리 숫자들을 확인, 0~9까지를 다 봤나? 체크 필요
 *
 * 만약, 0~9까지를 다 본게 아니라면, 2N 으로 넘어가기.
 *
 * 이것이 첫번째 풀이 방향이다.
 *
 *
 *
 */
public class SWEA1288_새로운불면증치료법_Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for(int tc = 0; tc <t; tc++) {
			int a = sc.nextInt();
			int cnt = 1;
			int bit = 0;
			while(true) {
				//System.out.println(bit);
				if(bit == (1<<10) -1) {

					System.out.println("#" + (tc+1)+" " + (cnt-1) * a);
					break;
				}
				int na = a * cnt;
				while(true) {
					//System.out.println(na);
					int ta = na%10;
					bit |= 1<<ta;
					na/=10;
					if(na==0) {
						break;
					}
				}
				cnt++;
			}

		}
	}

}
