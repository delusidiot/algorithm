import java.util.Scanner;

public class Solution_4301_2 {
	public static boolean[][] check;
	public static int N;
	public static int M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			N = sc.nextInt();
			M = sc.nextInt();
			int count = 0;
			//0 1 2 3 4 5 6 7
			//1 2 2 2 3 4 4 4
			
			//0 1 2 3 4 5 6 7
			//0 0 1 2 2 2 3 4
			for (int i = 0; i < M; i++) {
				int sub = 0;
				if(i%4==0||i%4==1) {
					sub = ((N-1)/4)*2;
					if(N%4==0) {
						count +=(1+sub);
					}else {
						count +=(2+sub);
					}
					System.out.println(sub);
				}else if(i%4==2||i%4==3) {
					sub = ((N-1)/4)*2;
					if(N%4==1||N%4==0) {
						count +=(0+sub);
					}else if(N%4==2){
						count +=(1+sub);
					}else {
						count +=(2+sub);
					}
				}
			}
			System.out.println("#"+testCase+" "+count);
		}
	}
}
