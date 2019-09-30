import java.util.Scanner;

public class Solution_3074 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt(); // 게이트 수
			int M = sc.nextInt(); // 사람수
			int[] people = new int[N];
			for (int i = 0; i < N; i++) {
				people[i]=sc.nextInt();
			}
			int count = 0;
			while(M>0) {
				count ++;
				for (int i = 0; i < people.length;i++) {
					if(count%people[i]==0) {
						M--;
					}
				}
			}
			System.out.println("#"+testCase+" "+count);
		}
	}
}
