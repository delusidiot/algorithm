import java.util.Scanner;

public class Main_1463_C {
	static int[] p = null;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		p = new int[10000000];
		p[2]=1;
		p[3]=1;
		int N = sc.nextInt();
		for (int i = 4; i <= N; i++) {
			DP(i);
		}
		System.out.println(p[N]);
	}
	public static void DP(int N) {
		if(N%3==0&&N%2==0) {
			int min = Math.min(p[N/2], p[N/3]);
			p[N]=Math.min(min, p[N-1])+1;
		}else if(N%3==0){
			p[N]=Math.min(p[N/3], p[N-1])+1;
		}else if(N%2==0){
			p[N]=Math.min(p[N/2], p[N-1])+1;
		}else {
			p[N]=p[N-1]+1;
		}
	}
}
