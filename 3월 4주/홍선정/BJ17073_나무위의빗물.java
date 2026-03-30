package BJ_3월4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ17073_나무위의빗물 {
	/* 입력 받고 간선이 1개인 트리만 카운해 나눠보기
	 * 
	 */
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb=new StringBuilder();
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int W=Integer.parseInt(st.nextToken()); //물의 양 long?????
		
		List<Integer>[] adj=new ArrayList[N+1]; //크기 선언 필수 
		
		for(int i=1; i<=N; i++) {
			adj[i]=new ArrayList<>();
		}
		int [] p=new int[N+1];
		
		for(int i=0; i<N-1; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			adj[a].add(b);
			adj[b].add(a);
		}
		
		int leafcnt=0;
		for(int i=2; i<=N; i++) {
			if(adj[i].size()==1) {
				leafcnt++;
			}
		}
		
		System.out.println((float)W/ leafcnt);
	}

}
