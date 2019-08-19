import java.util.Scanner;
//6913과 6958문제는 같은 문제입니다.
public class Solution_6913_6958_C {
	static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		//N 명의 사람
		//M 개의 문제
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] problum = new int[N+1][M+1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					problum[i][j]=sc.nextInt();
				}
			}
			int[] numberOne = new int[N+1];
			int max=0;
			int count=0;
			for (int i = 1; i <= N; i++) {
				count = 0;
				for (int j = 1; j <= M; j++) {
					if(problum[i][j]==1) {
						numberOne[i]++;
						count++;
					}
				}
				if(max<count) {
					max=count;
				}
			}
			count = 0;
			for (int i = 1; i < numberOne.length; i++) {
				if(numberOne[i]==max) {
					count ++;
				}
			}
			
			
			System.out.println("#"+testCase+" "+count+" "+max);
		}
		
	}

}
