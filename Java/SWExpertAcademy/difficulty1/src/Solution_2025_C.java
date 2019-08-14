import java.util.Scanner;

public class Solution_2025_C {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int result = 0;
		for (int i = 1; i <= T ; i++) {
			result+=i;
		}
		System.out.println(result);
	}
}
