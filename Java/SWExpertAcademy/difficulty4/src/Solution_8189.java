

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_8189 {
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
		int idx = 1;
		int resultIdx = 0;
		int nextTime = 1;
		int lastTime = 1;
		int letter = time[0];
		int size = 0;
		q.offer(time[0]);
		while(!q.isEmpty()) {
			size =q.size();
			if(size%2==1) {//올림
				size++;
			}
			if(letter>=(B*(nextTime))) {//시간 경과
				int peek = q.peek()%(lastTime*B);
				for (int i = 0; i < size/2; i++) {
					result[resultIdx++]=peek+(B*nextTime);
					q.poll();
				}
				if(idx>=time.length) {// 마지막..
					while(!q.isEmpty()) {
						result[resultIdx++]=q.poll()+(B*lastTime);
					}
					break;
				}
				nextTime++;
				lastTime = nextTime-1;
			}
			
			if(A <= q.size()) { //사이즈 경과
				for (int i = 0; i < size/2; i++) {
					result[resultIdx++]=letter;
					q.poll();
				}
			}
			if(idx>=time.length) {// 마지막..
				while(!q.isEmpty()) {
					result[resultIdx++]=q.poll()+(B*lastTime);
				}
				break;
			}
			letter = time[idx++];
			q.offer(letter);
		}
		
		return result;
	}
}
