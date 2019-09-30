import java.util.Scanner;

public class Main_1149_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] rgb = new int[N+1][3];
		for (int i = 1; i < rgb.length; i++) {
			rgb[i][0]=sc.nextInt();
			rgb[i][1]=sc.nextInt();
			rgb[i][2]=sc.nextInt();
		}
		int[][] dp = new int[N+1][3];
		for (int i = 1; i < rgb.length; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2])+rgb[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2])+rgb[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1])+rgb[i][2];
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			if(min>dp[N][i])
				min=dp[N][i];
		}
		System.out.println(min);
	}
}
