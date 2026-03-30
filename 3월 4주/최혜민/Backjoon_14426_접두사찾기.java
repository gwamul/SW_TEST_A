import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon_14426_접두사찾기 {
	static int N;
	static int M;
	static String[] word;
	static String check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		word = new String[N];
		
		for(int i = 0; i < N; i++) {
			word[i] = br.readLine();
		}
		Arrays.sort(word);
		
		int count = 0;
		
		for(int i = 0; i < M; i++) {
			check = br.readLine();
		
			int low = 0;
			int high = N - 1;
			
			while(low <= high) {
				int mid = (low + high) / 2;
				
				if(word[mid].compareTo(check) < 0) {
					low = mid + 1;
				} else {
					if(word[mid].startsWith(check)) {
						count++;
						break;
					}
					high = mid - 1;
				}
			}
		}
		
		System.out.println(count);
	}
}
