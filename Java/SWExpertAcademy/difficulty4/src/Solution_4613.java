import java.util.Scanner;

public class Solution_4613 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			sc.nextLine();
			char[][] flag = new char[N][M];
			String line = null;
			for (int i = 0; i < N; i++) {
				line = sc.nextLine();
				flag[i]=line.toCharArray();
			}
			int idx = 0;
			int WR = 0;
			int BR = 0;
			int RR = 0;
			int min = Integer.MAX_VALUE;
			
			for (int i = 0; i < N-2; i++) { //W
				WR = 0;
				idx = 0;
				for (int i2 = idx; i2 <= i; i2++) {
					for (int m = 0; m < M; m++) {
						if(flag[i2][m]!='W')WR++;
					}
				}
				
				for (int j = i+1; j < N-1; j++) { //B
					BR=WR;
					idx = i+1;
					for (int j2 = idx; j2 <= j; j2++) {
						for (int m = 0; m < M; m++) {
							if(flag[j2][m]!='B')BR++;
						}
					}
					
					RR=BR;
					idx = j+1;
					for (int k2 = idx; k2 < N; k2++) {
						for (int m = 0; m < M; m++) {
							if(flag[k2][m]!='R')RR++;
						}
					}
					if(min>RR) min=RR;
				}
				
			}
			System.out.println("#"+testCase+" "+min);
		}
	}
}

