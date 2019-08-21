import java.util.Scanner;

public class Solution_1859 {
	static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int[] buy = new int[N+1];
			for (int i = 0; i < buy.length; i++) {
				buy[i]=sc.nextInt();
			}
			int idx = 0;
			int max = buy[0];
			int result = 0;
			for (int i = 1; i < buy.length; i++) {
				if(max<=buy[i]) {
					max=buy[i];
					
				}else {
					for (int j = idx; j < i-1; j++) {
						result += (max-buy[j]);
					}
					idx = i;
				}
			}
			System.out.println("#"+testCase+" "+result);
		}
		
	}
}
