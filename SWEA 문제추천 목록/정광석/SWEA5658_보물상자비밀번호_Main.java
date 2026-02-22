package 정광석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
/*
2
12 10
1B3B3B81F75E
16 2
F53586D76286B2D8
 * */
public class SWEA5658_보물상자비밀번호_Main {
	static int n,k;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			Set<Integer> list = new HashSet<>();
			
			char[] nums = new char[2*n];
			String line = br.readLine();
			for(int i=0; i<n; i++) {
				char c = line.charAt(i);
				nums[i] = c;
				nums[i+n] = c;
			}
			for(int rot = 0; rot<3; rot++) {
				
				for(int i=0; i<4; i++) {
					int sum = 0;
					for(int j=0; j<n/4; j++) {
						int now =  nums[i*(n/4) + j + rot];
						
						if('0'<=now && now<='9') now = now - '0';
						else {
							now = now - 'A' + 10;
						}
						//System.out.println(now);
						sum += now << (n/4-j-1)*4;
					}
					//System.out.printf("%x\n", sum );
					list.add(sum);
				}
			}
			//16진수 
			List<Integer> nlist = new ArrayList<>(list);
			nlist.sort(Collections.reverseOrder());
			//System.out.println(list.toString());
			
			sb.append("#").append(tc).append(" ");
			sb.append(nlist.get(k-1));
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
