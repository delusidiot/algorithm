import java.util.Scanner;

public class Solution_7193_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			long X = sc.nextInt();
			long result = 0;
			long next = 0;
			while(X!=0) {
				result += ((long)((X%10)*Math.pow(N, next)));
				X/=10;
				next++;
			}
			System.out.println("#"+testCase+" "+(result%(N-1)));
		}
	}
}
