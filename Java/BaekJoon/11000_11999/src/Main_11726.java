import java.util.Scanner;

public class Main_11726 {
	static Scanner sc;
	static int max = 10007;
	static int[] p = new int[1001];
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			tiling(i);
		}
		System.out.println(p[T]);
	}
	public static void tiling(int num) {
		if(num==1) p[1]=1;
		else if(num==2) p[2]=2;
		else {
			p[num]=(p[num-1]+p[num-2])%max;
		}
	}
}
