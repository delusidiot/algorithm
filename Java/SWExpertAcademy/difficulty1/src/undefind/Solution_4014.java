package undefind;

import java.util.Scanner;

public class Solution_4014 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			
			int N = sc.nextInt(); //공항 크기
			int X = sc.nextInt(); //경사로의 길이
			int[][] airstrip = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					airstrip[i][j]=sc.nextInt();
				}
			}
			int build = 0;
			for (int x = 0; x < N; x++) {//활주로 길이
				int count = 0;
				int height = 0;
				boolean ramp=true;
				line:for (int y = 0; y < N; y++) {
					if(y==0) {
						count ++;
						height = airstrip[x][y];
					}else if(airstrip[x][y]!=height) {
						if(Math.abs(airstrip[x][y]-height)!=1) {
							ramp=false;
							break;
						}
						if(airstrip[x][y]>height) {
							if(count<X) {
								ramp=false;
								break;
							}
							count = 1;
							height = airstrip[x][y];
						}else {
							int downhill = airstrip[x][y];
							for (int i = y; i < y+X; i++) {
								if(i>=N) {
									ramp=false;
									break line;
								}else {
									if(airstrip[x][i]!=downhill) {
										ramp=false;
										break line;
									}
								}
							}
							y+=(X-1);
							count = 0;
							height=airstrip[x][y];
						}
					}else {
						count++;
					}
				}
				if(ramp) {
					build++;
				}
			}
			for (int y = 0; y < N; y++) {
				int count = 0;
				int height = 0;
				boolean ramp=true;
				line:for (int x = 0; x < N; x++) {
					if(x==0) {
						count ++;
						height = airstrip[x][y];
					}else if(airstrip[x][y]!=height) {
						if(Math.abs(airstrip[x][y]-height)!=1) {
							ramp=false;
							break;
						}
						if(airstrip[x][y]>height) {
							if(count<X) {
								ramp=false;
								break;
							}
							count = 1;
							height = airstrip[x][y];
						}else {
							int downhill = airstrip[x][y];
							for (int i = x; i < x+X; i++) {
								if(i>=N) {
									ramp=false;
									break line;
								}else {
									if(airstrip[i][y]!=downhill) {
										ramp=false;
										break line;
									}
								}
							}
							x+=(X-1);
							count = 0;
							height=airstrip[x][y];
						}
					}else {
						count++;
					}
				}
				if(ramp) {
					build++;
				}
			}
			System.out.println("#"+testCase+" "+build);
		}

	}

}
