import java.util.Scanner;
// 제한시간 초과 && int말고 long로 해야됨
class Solution {
	private static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int floor = 0;
		int num = 1; 
		int left = 0;
		int right = 0;
		int T = 0;
		for (int i = 1; i <= testCase; i++) {
			T=sc.nextInt();
			floor = 0;
			num = 1; 
			left = 0;
			right = 0;
			for (int j = 1; j <= T; j++) {
				for (int k = 1; k <= j+floor; k++) {
					if(k == 1) left = num ;
					if(k == (j+floor)) right = num;
					num +=2 ;
				}
				floor++;
			}
			System.out.println("#"+i+" "+left+" "+right);
		}
	}
}