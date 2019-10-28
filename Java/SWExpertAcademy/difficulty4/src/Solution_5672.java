import java.util.Scanner;

public class Solution_5672 {
	static char[] bird;
	static char[] result ;
	static int Estart = 0;
	static int Eend = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			bird = new char[N];
			sc.nextLine();
			for (int i = 0; i < N; i++) {
				bird[i]=sc.nextLine().charAt(0);
			}
			result = new char[N];
			Estart = 0;
			Eend = bird.length-1;
			for (int i = 0; i < bird.length; i++) {
				result[i]=bird[checkInner(Estart, Eend, Estart, Eend, i)];
			}
			System.out.print("#"+testCase+" ");
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i]);
			}
			System.out.println();
		}
	}
	public static int checkInner(int firstS, int firstE, int start, int end,int i) {
		if(start>=end) {
			Estart++;
			return firstS;
		}
		if(bird[start]>bird[end]) {
			Eend--;
			return firstE;
		}else if(bird[start]<bird[end]) {
			Estart++;
			return firstS;
		}else {
			checkInner(firstS, firstE, start+1, end-1, i);
		}
		return firstS;
	}
}
