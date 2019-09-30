import java.util.Arrays;
import java.util.Scanner;

public class Main_2133 {
	static int[] p = new int[30];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] p = new int[17];
		int N = sc.nextInt();
		int result = 0;
		p[2]=3;
		p[4]=11;
		p[6]=39;
		int[] fibo = {0,1,1,2,3,5,8,13,21,34,55};
		for (int i = 6; i < p.length; i+=2) {
			p[i]=p[i-2]*3;
			p[i]+=p[i-2]-p[i-4]-fibo[i/2];
		}
		System.out.println(Arrays.toString(p));
		System.out.println(result);
	}
}
