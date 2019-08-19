import java.util.Scanner;

public class Solution_7087_C {
	static Scanner sc;
	public static void main(String[] args) {
		int[] alpha = null; //A 65
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			alpha = new int[26];
			sc.nextLine();
			for (int i = 0; i < N; i++) {
				char s =sc.nextLine().charAt(0);
				alpha[s-'A']++;
			}
			int count = 0;
			for (int i = 0; i < alpha.length; i++) {
				if(alpha[i]>0) {
					count ++;
				}else {
					break;
				}
			}
			System.out.println("#"+testCase+" "+count);
		}
	}
}
