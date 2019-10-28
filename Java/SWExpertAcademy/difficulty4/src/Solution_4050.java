import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution_4050 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			for (int i = 0; i < N; i++) {
				pq.add(sc.nextInt());
			}
			int result = 0;
			while(pq.size()%3!=0) {
				result += pq.poll();
			}
			while(!pq.isEmpty()) {
				pq.poll();
				result += pq.poll();
				result += pq.poll();
			}
			System.out.println("#"+testCase+" "+result);
		}
	}
}
