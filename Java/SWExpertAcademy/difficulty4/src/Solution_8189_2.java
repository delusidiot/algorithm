import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_8189_2 {
	static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt(); //오늘 오는 편지의 개수
			int A = sc.nextInt(); //A 개 이상
			int B = sc.nextInt(); //B 시간
			int[] time = new int[N];
			
			for (int i = 0; i < N; i++) {
				time[i]=sc.nextInt(); // 도착 시간 저장 같은시간에 도착하는 편지는 없음
			}
			time = readSun(time, A, B);
			System.out.print("#"+testCase+" ");
			for (int i = 0; i < time.length; i++) {
				System.out.print(time[i]+" ");
			}
			System.out.println();
		}
	}
	public static int[] readSun(int[] time,int A, int B) {
		int[] result = new int[time.length];
		Queue<Integer> q = new LinkedList<>();
		int resultIdx = 0;
		int nextTime = 1;
		int peek = 0;
		for (int idx = 0; idx < time.length; idx++) {
			q.offer(time[idx]);
			int raise =(q.size()%2==0? q.size()/2:(q.size()+1)/2);
			peek = q.peek();
			if(q.size() >= A) {
				for (int j = 0; j < raise; j++) {
					result[resultIdx++]=time[idx];
					q.poll();
				}
			}else if(time[idx]>=(B*nextTime)){
				for (int j = 0; j < raise; j++) {
					result[resultIdx++]=peek+B;
					q.poll();
				}
				nextTime++;
			}
		}
		while(!q.isEmpty()) {
			int raise =(q.size()%2==0? q.size()/2:(q.size()+1)/2);
			peek = q.peek();
			for (int j = 0; j < raise; j++) {
				result[resultIdx++]=peek+B;
				q.poll();
			}
		}
		return result;
	}
}
