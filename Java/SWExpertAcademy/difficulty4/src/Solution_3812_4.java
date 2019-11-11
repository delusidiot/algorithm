import java.util.Scanner;

public class Solution_3812_4 {
	static int X;
	static int Y;
	static int Z;
	static int A;
	static int B;
	static int C;
	static int N;
	static long[] color;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			X = sc.nextInt();
			Y = sc.nextInt();
			Z = sc.nextInt();
			A = sc.nextInt();
			B = sc.nextInt();
			C = sc.nextInt();
			N = sc.nextInt();
			long[] Adist= new long[N];
			long[] Bdist= new long[N];
			long[] Cdist= new long[N];
			long[] squareDist= new long[N];
			long[] hexahedronDist= new long[N];
			
			for (int i = 0; i < X; i++) {
				Adist[Math.abs(i-A)%N]++;
			}
			for (int i = 0; i < Y; i++) {
				Bdist[Math.abs(i-B)%N]++;
			}
			for (int i = 0; i < Z; i++) {
				Cdist[Math.abs(i-C)%N]++;
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					squareDist[(i+j)%N]+=Adist[i]*Bdist[j];
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					hexahedronDist[(i+j)%N]+=squareDist[i]*Cdist[j];
				}
			}
			System.out.print("#"+testCase+" ");
			for (int i = 0; i < hexahedronDist.length; i++) {
				System.out.print(hexahedronDist[i]+" ");
			}
			System.out.println();
		}
	}
}

