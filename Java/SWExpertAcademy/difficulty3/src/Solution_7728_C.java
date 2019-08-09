import java.util.Scanner;

public class Solution_7728_C {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int i = 1; i <= T; i++) {
			String s = sc.nextLine();
			int result = diversity(s);
			System.out.println("#"+i+" "+result);
		}
	}
	public static int diversity(String s) {
		char[] c = s.toCharArray();
		int[] numbers = new int[10];
		int count = 0;
		for (int i = 0; i < c.length; i++) {
			numbers[(c[i]-'0')]++;
		}
		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i]>0)
				count ++;
		}
		return count;
	}
}
