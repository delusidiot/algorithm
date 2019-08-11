import java.util.Scanner;

public class Solution_2058_C {
	static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		String number = String.valueOf(N);
		int result = 0;
		for (int i = 0; i < number.length(); i++) {
			result+=(number.toCharArray()[i]-'0');
		}
		System.out.println(result);
	}
}
