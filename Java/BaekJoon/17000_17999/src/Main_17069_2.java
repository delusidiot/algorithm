import java.util.Arrays;
import java.util.Scanner;


public class Main_17069_2 {
	static int N;
	static int[][] home;
	static long[][][] dp;
	static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		N = sc.nextInt();
		home = new int[N+2][N+2];
		dp = new long[3][N+2][N+2];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				home[i][j] = sc.nextInt();
			}
		}
		dp[0][1][2] = 1;
	    for (int i=1; i<=N; i++) {
	        for (int j=1; j<=N; j++) {
	            if (home[i][j+1]!=1) dp[0][i][j+1] += dp[0][i][j] + dp[2][i][j];
	            if (home[i+1][j]!=1) dp[1][i+1][j] += dp[1][i][j] + dp[2][i][j];
	            if (home[i+1][j+1]!=1 && home[i+1][j]!=1 && home[i][j+1]!=1) {
	                dp[2][i+1][j+1] += dp[0][i][j] + dp[1][i][j] + dp[2][i][j];
	            }
	        }
	    }
//		DFS2(1,2,1);
//	    System.out.println("0");
//	    for (int i = 1; i <= N; i++) {
//			System.out.println(Arrays.toString(dp[0][i]));
//		}
//	    System.out.println("1");
//	    for (int i = 1; i <= N; i++) {
//			System.out.println(Arrays.toString(dp[1][i]));
//		}
//	    System.out.println("2");
//	    for (int i = 1; i <= N; i++) {
//			System.out.println(Arrays.toString(dp[2][i]));
//		}
		System.out.println(dp[0][N][N]+dp[1][N][N]+dp[2][N][N]);
	}
	static long count = 0;
	public static void DFS2(int x, int y, int status) {
		if(x>N||y>N) return;
		if(x==N && y ==N) {
			count ++;
			return;
		}
		switch(status) {
		case 1:
			if(home[x][y]==1) return;
			DFS2(x,y+1,1);
			DFS2(x+1,y+1,3);
			break;
		case 2:
			if(home[x][y]==1) return;
			DFS2(x+1,y,2);
			DFS2(x+1,y+1,3);
			break;
		case 3:
			if(home[x-1][y]==1||home[x][y-1]==1||home[x][y]==1) return;
			DFS2(x,y+1,1);
			DFS2(x+1,y,2);
			DFS2(x+1,y+1,3);
			break;
		}
	}
}

