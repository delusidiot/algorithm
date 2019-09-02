import java.util.Scanner;

public class Solution_7510_2_C {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			if(N==1) {
				System.out.println("#"+testCase+" 1");
				continue;
			}
			int count = 0;
			int result = 0;
			int number = 1;
			while (number<N){
				int num = number;
				result = 0;
				while (result<N){
					result+=num;
					num++;
				}
				if(result==N) count++;
				number++;
			}
			System.out.println("#"+testCase+" "+(count+1));
		}
	}
}
