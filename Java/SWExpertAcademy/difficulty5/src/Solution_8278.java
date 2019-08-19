import java.util.Scanner;

public class Solution_8278 {
	static int[] numbers = new int[451];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt()%451;
			int M = sc.nextInt();
			fib2(N,M);
			System.out.println("#"+testCase+" "+numbers[N]%M);		
		}
	}
	public static int fib2(int n, int m) {
		numbers[1]=1;
		numbers[2]=1;
		for(int i = 2; i<=n; i++) {
			numbers[i] = ((numbers[i-1]*numbers[i-1]*numbers[i-1])%m+(numbers[i-2]*numbers[i-2]*numbers[i-2])%m);
		}
		return numbers[n];
	}
}
