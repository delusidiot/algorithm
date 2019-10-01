import java.util.Scanner;

public class Solution_3074_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt(); // 게이트 수
			int M = sc.nextInt(); // 사람수
			int[] people = new int[N];
			long max = 0;
			for (int i = 0; i < N; i++) {
				people[i]=sc.nextInt();
				if(max<people[i]) max = people[i];
			}
			long left = 1;
			long right = max*M;
			long mid = 0;
			while(left<=right) {
				mid = (left+right)/2;
				long total = 0;
				for (int i = 0; i < people.length; i++) {
					total+=mid/people[i];
				}
				if(total<M) {
					left = mid+1;
				}
				else {
					right = mid-1;
				}
			}
			
			System.out.println("#"+testCase+" "+ left);
		}
	}
}
