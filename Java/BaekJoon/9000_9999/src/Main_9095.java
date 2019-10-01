import java.util.Scanner;

public class Main_9095 {
	public static int[] p = new int[10000];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		p[0]=0;
		p[1]=1;
		p[2]=2;
		p[3]=4;
		p[4]=7;
		for (int i = 5; i < 100; i++) {
			p[i]=(p[i-1]-p[i-2])+(p[i-2]-p[i-3])+(p[i-3]-p[i-4])+p[i-1];
		}
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			System.out.println(p[N]);
		}
	}
}
