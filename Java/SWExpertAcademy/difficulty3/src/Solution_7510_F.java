import java.util.Scanner;

public class Solution_7510_F {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			if(N==1) {
				System.out.println("#"+testCase+" 1");
				continue;
			}
			int result = 0;
			int idx = 0;
			int subnum = 0;
			int count = 1;
			for (int i = 1; i <= N/2+1; i++) {
				subnum =0;
				idx=0;
				result +=i;
				if(result<N) {
					continue;
				}
				while(N<(result-subnum)) {
					idx++;
					subnum += idx;
				}
				if(N==(result-subnum))
					count++;
			}
			
			System.out.println("#"+testCase+" "+count);
		}
	}
}
