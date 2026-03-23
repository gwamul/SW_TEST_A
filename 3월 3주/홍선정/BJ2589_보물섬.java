package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2589_보물섬 {
	
	//그냥 bfs 인것만 알겠고, 입력까지만 받을 수 있습니다.
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	
	static int R,C;
	static char[][] map;
	static int maxDis=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		map=new char[R][C];
		
		for(int i=0; i<R;i++) {
			String line=br.readLine();
			for(int j=0; j<C;j++) {
				map[i][j]=line.charAt(j);
			}
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C;j++) {
				if(map[i][j]=='L') {
					bfs(i,j);
				}
			}
		}
		
		System.out.println(maxDis);
		
	}
	static void bfs(int stX, int stY) {
		Queue<int[]> q=new LinkedList<>();
		
		boolean[][] visited=new boolean[R][C];
		
		q.offer(new int[] {stX,stY,0});
		visited[stX][stY]=true;
		
		int curMax=0;
		
		while(!q.isEmpty()) {
			int[] cur=q.poll();
			int cx=cur[0];
			int cy=cur[1];
			int dis=cur[2];
			
			curMax=Math.max(curMax, dis);
			
			for(int i=0; i<4; i++) {
				int nx=cx+dx[i];
				int ny=cy+dy[i];
				
				
				if(nx>=0&&nx<R&&ny>=0&&ny<C) {
					if(map[nx][ny]=='L'&&!visited[nx][ny]) {
						visited[nx][ny]=true;
						q.offer(new int[] {nx, ny, dis+1});
					}
				}
			}
			
		}
		
		maxDis=Math.max(maxDis, curMax);
	}
	

}
