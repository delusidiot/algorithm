package recursion;

public class GCD {
	public static void main(String[] args) {
		System.out.println(gcd(10,5));
		System.out.println(gcd2(5,10));
	}
	public static double gcd(int m, int n) {
		if(m<n){
			int tmp=m; m=n; n=tmp;
		}
		if(m%n==0) {
			return n;
		}else {
			return gcd(n, m%n);
		}
	}
	public static double gcd2(int p, int q) {
		if(q==0)
			return p;
		else
			return gcd2(q, p%q);
	}
}
