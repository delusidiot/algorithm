import java.util.Scanner;

public class Solution_7193 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int X = sc.nextInt();
			int next = 1;
			int result = 0;
			int mid = 1;
			while(mid!=0) {
				result=result + (X%10)*next;
				next*=N;
				mid = X;
				X/=10;
			}
			System.out.println("#"+testCase+" "+(result%(N-1)));
		}
		
	}
}
