import java.util.Scanner;
//int를 사용하면 left right 의 범위가 넘어가 버린다.
public class Solution_8016_C {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int i = 1; i <= testCase; i++) {
			int chooseCase = sc.nextInt();
			long level = 1;
			long numbers = 0;
			long right = 1;
			long left = 1;
			for (int j = 1; j < chooseCase; j++) {
				level++;
				numbers++;
				left=right + 2;
				right=right+(((level)+(numbers))*2);
			}
			System.out.println("#"+i+" "+left+" "+right);
		}
	}
}
