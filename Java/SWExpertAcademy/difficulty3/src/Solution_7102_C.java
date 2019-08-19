import java.util.Scanner;

public class Solution_7102_C {
	static int[] result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			result = new int[N+M+2];
			for (int n = 1; n <= N; n++) {
				for (int m = 1; m <= M; m++) {
					result[n+m]++;
				}
			}
			int max = 0;
			for (int i = 0; i < result.length; i++) {
				if(max<result[i]) {
					max=result[i];
				}
			}
			System.out.print("#"+testCase+" ");
			for (int i = 0; i < result.length; i++) {
				if(result[i]==max)
					System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}
