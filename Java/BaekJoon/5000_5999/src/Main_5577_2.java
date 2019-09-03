import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main_5577_2 {
	public static BufferedReader br;
	public static BufferedWriter bw;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] ball = new int[N+1];
		int[] ballCopy = new int[N+1];
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			ball[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < N; i++) {
			for (int j = 1; j <= 3; j++) {
				if(ball[i]==j)continue;
				System.arraycopy(ball, 0, ballCopy, 0, N+1);
				ballCopy[i]=j;
				int result = minBall(ballCopy);
				if(min>result) {
					min=result;
				}
			}
		}
		System.out.println(min);
	}
	public static int minBall(int[] ball) {
		int count = 0;
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < ball.length; i++) {
			list.add(ball[i]);
		}
		for (int idx = 0; idx < list.size()-1; idx++) {
			count = 0;
			while(list.get(idx)==list.get(idx+1)) {
				count++;
				idx++;
			}
			if(count>=3) {
				for(int i = 0; i <= count; i++) {
					 list.remove(idx-count);
				}
				idx=0;
			}
		}
		return list.size()-1;
	}
}
