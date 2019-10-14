import java.util.Scanner;

public class TestClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int ten = 10;
		for (int i = 10; i >= 0; i--) {
			if((T & (int)Math.pow(2,i))>0)
				System.out.print("1");
			else {
				System.out.print("0");
			}
			
		}
	}
}
