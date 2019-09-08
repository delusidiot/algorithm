import java.util.Scanner;

public class Main_1592 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		int[] Ncatch = new int[N];
		int i = 0;
		int count = 0;
		while(true) {
			Ncatch[i]++;
			if(Ncatch[i]==M)break;
			count++;
			if(Ncatch[i]%2==1) {
				i=(i+N-L)%N;
			}else {
				i=(i+L)%N;
			}
		}
		System.out.println(count);
	}
}
