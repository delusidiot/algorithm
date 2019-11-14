import java.util.Arrays;
import java.util.Scanner;

public class Solution_3234 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			
			int[] weight = new int[N];
			int total = 0;
			for (int i = 0; i < weight.length; i++) {
				weight[i]=sc.nextInt();
				total+=weight[i];
			}
			total/=2;
			
			System.out.println(Arrays.toString(weight));
			System.out.println("#"+testCase+" ");
		}
	}
}
