import java.util.Scanner;

public class Main_1010 {
	public static int max = 31;
	public static int[][] p = new int[max][max];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		p[0][0]=1;
		for (int i = 1; i < max; i++) {
			for (int j = 0; j < i+1; j++) {
				int a = 0;
				int b = 0;
				if(i-1<0||j-1<0) {
					a=0;
				}
				else {
					a=(p[i-1][j-1]);
				}
				if(i-1<0) {
					b=0;
				}
				else {
					b=(p[i-1][j]);
				}
				p[i][j]=a+b;
			}
		}
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			System.out.println(p[M][N]);
		}
	}
}
