import java.util.Scanner;

public class Main_14501 {
	static int N;
	static int[] t,p;
	static Scanner sc;
	public static int go(int idx, int sum) {
		if(idx == N) {
			return sum;
		}
		if(idx > N) return 0;
		int t1 = go(idx+t[idx],sum+p[idx]);
		int t2 = go(idx+1, sum);
		return Math.max(t1, t2);
	}
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		N = sc.nextInt();
		t = new int[N];
		p = new int[N];
		for (int i = 0; i < N; i++) {
			t[i] = sc.nextInt();
			p[i]=sc.nextInt();
		}
		System.out.println(go(0,0));
	}
}
