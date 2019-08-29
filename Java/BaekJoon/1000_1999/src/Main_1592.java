import java.util.Scanner;

public class Main_1592 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		int[] Ncatch = new int[N+1];
		int i = 1;
		int count = 0;
		while(true) {
			Ncatch[i]++;
			count++;
			if(Ncatch[i]==M)break;
			if(Ncatch[i]%2==1) {
				i+=L;
				if(i>N) {
					i=2*N-i-1;
				}
			}else {
				i-=L;
				if(i<=0) {
					i=N+i;
				}
			}
		}
		System.out.println(count);
	}
}
