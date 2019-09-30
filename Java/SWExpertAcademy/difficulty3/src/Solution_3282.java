import java.util.Arrays;
import java.util.Scanner;

public class Solution_3282 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt(); //물건 갯수
			int K = sc.nextInt(); //가방 부피
			
			int[][] VC = new int[N+1][2];
			for (int i = 1; i < VC.length; i++) {
				VC[i][0]=sc.nextInt();//부피
				VC[i][1]=sc.nextInt();//가치
			}
			for (int i = 0; i < VC.length; i++) {
				System.out.println(Arrays.toString(VC[i]));
			}
			int[][] back = new int[N+1][K+1];
			for (int i = 1; i <= N; i++) {
				for (int w = 1; w <= K; w++) {
					if(VC[i][0]>w) {
						back[i][w] = back[i-1][w];
					}else {
						back[i][w] = Math.max(back[i-1][w], back[i-1][w-VC[i][0]]+VC[i][1]);
					}
				}
			}
			for (int i = 0; i < VC.length; i++) {
				System.out.println(Arrays.toString(back[i]));
			}
			System.out.println("#"+testCase+" "+back[N][K]);
		}
	}
}
