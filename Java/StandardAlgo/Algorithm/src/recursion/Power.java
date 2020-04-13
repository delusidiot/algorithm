package recursion;

public class Power {
	public static void main(String[] args) {
		System.out.println(power(2,2));
	}
	public static double power(int x, int n) {
		if(n == 0)
			return 1;
		else {
			return x*power(x,n-1);
		}
	}
}
