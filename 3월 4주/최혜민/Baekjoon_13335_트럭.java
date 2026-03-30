import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_13335_트럭 {
	static int N; //트럭수
	static int W; //다리 위 트럭 수
	static int L; //최대 하중
	static int time;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		W = sc.nextInt();
		L = sc.nextInt();
		time = 0;
		
		Queue<Integer> truck = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			truck.add(sc.nextInt());
		}
		
		Queue<Integer> on = new LinkedList<>();
		for(int i = 0; i < W; i++) {
			on.offer(0);
		}
		
		
		int now = 0;
		
		while(!on.isEmpty()) {
			time++;
			now -= on.poll();
			
			if(!truck.isEmpty()) {
				if(now + truck.peek() <= L) {
					int add = truck.poll();
					now += add;
					on.offer(add);
				} else {
					on.offer(0);
				}
			}
			
			if(truck.isEmpty() && now == 0) break;
		}
		
		System.out.println(time);
	}
}
