import java.util.Scanner;

public class TestClass {
	static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int testCase = 10;
		for (int i = 1; i <= testCase; i++) {
			sc.nextInt();
			System.out.println("#"+i+" "+doPow2(sc.nextInt(), sc.nextInt()));
		}
	}
	private static int doPow2(int base, int exp) {
		int newBase = 0;
		if (exp == 1)
			return base;
		else if (exp == 0)
			return 1;
		newBase = doPow2(base, exp/2);
		if(exp %2 == 1) {
			return newBase*newBase*base;
		}
		return newBase*newBase;
	}
}
