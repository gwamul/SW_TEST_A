package saffy_algo.SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 서로 다른 정점 쌍이 정확히 하나의 간선으로 이어져 있다.
 * 
 * 각 간선에는 양의 정수 가중치
 * 
 * MST 를 계산해야 한다.
 * 
 * 가중치의 리스트만 가지고 있음
 * 
 * 각 리스트에 있는 정수를 각 간선에 적으려 한다.
 * 
 * 리스트의 한 정수는 정확히 하나의 간선에. 모든 간선에 정수를 적어야 한다.
 * 
 * 최소 스패닝 트리의 최소 비용과 최대 비용을 출력하라.
 * 
 * 최소 스패닝 트리니까 간선 n-1 개를 선택.
 * 
 * 
 * 100 
 * 
 * 3 5 5 8 8 9
 * 
 * 13 
 * 
2
2
100
4
5 3 8 8 5 9
 */
public class SWEA26504_MST만들기_Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			
			int n = Integer.parseInt(br.readLine());
			int m = n * (n-1) / 2;
			int[] c = new int[m];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<m; i++) {
				c[i] = Integer.parseInt(st.nextToken());
				
			}
			
			//최소
			Arrays.sort(c);
			System.out.println(Arrays.toString(c));
			long min_sum = 0;
			for(int i=0; i<n-1; i++) min_sum += c[i];
			
			
			//최대
			long max_sum = 0;
			int idx = 0;
			for(int i=0; i<n-1; i++) {
				max_sum += c[idx];
				idx+=(i+1);
			}
			
			sb.append(min_sum).append(" ").append(max_sum).append("\n");
			
		}
		System.out.println(sb.toString());
	}
}
