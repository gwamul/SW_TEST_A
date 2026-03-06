package 정광석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
1
5
2 1 0 1
3 5 3 7 9
6
 */
public class SWEA4123_숫자만들기_Main {
	static int[] ops = new int[4];
	static int[] nums;
	static int max_result;
	static int min_result;
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			
			n = Integer.parseInt(br.readLine());
			nums = new int[n];
			min_result = Integer.MAX_VALUE;
			max_result = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<4; i++) ops[i] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) nums[i] = Integer.parseInt(st.nextToken());
			
			
			sol(0,nums[0]);
			
			
			sb.append("#").append(tc).append(" ");
			sb.append(max_result - min_result);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void sol(int cnt, int result) {
		if(cnt == n-1) {
			//연산자를 모두 사용한 상황
			min_result = Math.min(min_result, result);
			max_result = Math.max(max_result, result);
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(ops[i] == 0) continue;
			
			ops[i]--;
			sol(cnt+1, cal(result, i, cnt));
			ops[i]++;
		}
	}

	private static int cal(int result, int i, int cnt) {
		// TODO + - * /
		if(i==0) {
			return result + nums[cnt+1];			
		}else if(i==1) {
			return result - nums[cnt+1];
		}else if(i==2) {
			return result * nums[cnt+1];
		}else {
			return result / nums[cnt+1];
		}
	}
	
	
}
