import java.util.Scanner;

public class Main_2133 {
	static int[] p = new int[30];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] p = new int[17];
		int N = sc.nextInt();
		int[] dp = new int[31];
		dp[0] = 1;
		dp[2] = 3;

		if(N%2 == 0) {
			for (int i = 4; i <= N; i+=2) {
				dp[i]=dp[i-2]*3;

				for (int j = 4; i-j >=0; j+=2) {
					dp[i]+=dp[i-j]*2;
				}
			}
		}
		System.out.println(dp[N]);
	}
}
