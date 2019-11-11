import java.util.Scanner;
public class Solution_4301 {
	static int N;
	static int M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			N = sc.nextInt();
			M = sc.nextInt();
			boolean[][] check = new boolean[N+2][M+2];
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(!check[i][j]) {
						check[i+2][j]=true;
						check[i][j+2]=true;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(!check[i][j]) {
						count ++;
					}
				}
			}
			System.out.println("#"+testCase+" "+count);
		}
	}
}
