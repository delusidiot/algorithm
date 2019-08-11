import java.util.Scanner;

public class Solution_1204_C {
	static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			sc.nextInt();
			int[] scoreConter = new int[101];
			for (int i = 0; i < 1000; i++) {
				scoreConter[sc.nextInt()]++;
			}
			int max = 0;
			for (int i = 0; i < 101; i++) {
				if(scoreConter[max]<=scoreConter[i])
					max=i;
			}
			System.out.println("#"+testCase+" "+max);
		}
	}

}
