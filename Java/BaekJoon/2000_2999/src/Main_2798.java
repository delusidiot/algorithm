import java.util.Scanner;

public class Main_2798 {
	public static final int choose = 3;
	public static int[] tr;
	public static int[] cards;
	public static int min = Integer.MAX_VALUE;
	public static int N;
	public static int M;
	public static int answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		cards = new int[N];
		tr = new int[choose];
		for (int i = 0; i < cards.length; i++) {
			cards[i]=sc.nextInt();
		}
		comb(N,choose);
		System.out.println(answer);
	}
	public static void comb(int n, int r) {
		if( r==0 ) {
			int result = 0;
			for (int i = 0; i < tr.length; i++) {
				result+=tr[i];
			}
			int sub = M-result;
			if(M<result) return;
			if(sub<min) {
				min=sub;
				answer=result;
			}
		}
		else if(n<r) return;
		else {
			tr[r-1] = cards[n-1];
			comb(n-1,r-1);
			comb(n-1,r);
		}
	}
}
