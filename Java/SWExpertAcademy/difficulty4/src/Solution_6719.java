import java.util.Arrays;
import java.util.Scanner;

public class Solution_6719 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();//강좌갯수
			int K = sc.nextInt();// 볼수있는 갯수.
			int[] study = new int[N];
			
			for (int i = 0; i < N; i++) {
				study[i]=sc.nextInt();
			}
			Arrays.sort(study);
			double result = 0;
			int count = K;
			for (int i = 0; i < K; i++) {
				result = (result+study[study.length-count])/2;
				count--;
			}
			System.out.printf("#%d %.6f\n",testCase, result);
		}
	}
}
