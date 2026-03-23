package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11403_경로찾기 {
	//인접행렬? 인접 리스트? 
	//가중치 없는 방향 그래프
	//제약조건에서 N의 최대값 100 -> 인접 행렬의 공간 복잡도 O(N^2)으로 최대 10,000메모리 사용량
	// N 1000이하일 경우 인접 행렬 사용해도 무방
	// N 100으로 DFS로도 가능하나 플로이드-워셜 알고리즘(DP) 권장
	static int [][] res;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N=Integer.parseInt(br.readLine());
		int [][] map=new int[N][N];
		
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
//		System.out.println(Arrays.deepToString(map));
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][k]==1&&map[k][j]==1) {
						map[i][j]=1;
					}
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

}
