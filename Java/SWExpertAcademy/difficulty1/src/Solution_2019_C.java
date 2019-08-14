import java.util.Scanner;

public class Solution_2019_C {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i <= T; i++) {
			System.out.print((1<<i)+" ");
		}
	}
}
