import java.util.Scanner;

public class Solution_3812_2 {
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
			color = new long[N];
			for (int x = 0; x < X; x++) {
				for (int y = 0; y < Y; y++) {
					color[(Math.abs(x-A)+Math.abs(y-B))%N]++;
				}
			}
			long[] result = new long[N];
			for (int z = 0; z < Z; z++) {
				int dist = Math.abs(C-z);
				for (int i = 0; i < result.length; i++) {
					result[(i+dist)%N]+=color[i];
				}
			}
			
			System.out.print("#"+testCase+" ");
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
		}
	}
}

