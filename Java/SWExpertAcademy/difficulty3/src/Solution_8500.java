import java.util.Scanner;

public class Solution_8500 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int max = 0;
			int count = 0;
			int num = 0;
			for (int i = 0; i < N; i++) {
				num=sc.nextInt();
				count+=num+1;
				if(max<num) max = num;
			}
			count+=max;
			System.out.println("#"+testCase+" "+count);
		}
	}
}
