import java.util.Scanner;

public class Solution_8278 {
	static long[] numbers = new long[1000000];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			
			
			System.out.println("#"+testCase+" ");
		}
	}
	public static long fibonacci(int n) {
		if(n<=1) {
			return n;
		}else if (numbers[n] != 0) {
			return numbers[n];
		}else {
			long a = fibonacci(n-1);
			long b = fibonacci(n+1);
			return numbers[n] = (a*a*a) + (b*b*b);
		}
	}
}
