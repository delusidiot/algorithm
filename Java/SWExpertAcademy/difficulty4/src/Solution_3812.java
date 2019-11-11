import java.util.Arrays;
import java.util.Scanner;

public class Solution_3812 {
	static int X;
	static int Y;
	static int Z;
	static int A;
	static int B;
	static int C;
	static int N;
	static long[][] color;
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
			color = new long[3][N];
            for(int i = A; i < X; i++)
                color[0][(i - A) % N]++;
            for(int i = A - 1; i >= 0; i--)
            	color[0][(A - i) % N]++;
            
            for (int i = 0; i < 3; i++) {
            	System.out.println(Arrays.toString(color[i]));
			}
            System.out.println();
            coloringCube(1, Y, B);
            coloringCube(2, Z, C);
            for (int i = 0; i < 3; i++) {
            	System.out.println(Arrays.toString(color[i]));
			}
			System.out.print("#"+testCase+" ");
			for(int i = 0; i < N; i++)
            	System.out.print(color[2][i] + " ");
			System.out.println();
		}
	}
	static void coloringCube(int idx, int offset, int criteria) {
		
		long sum = 0;
		long quotient = (offset - 1 - criteria) / N;
		long remain = (offset - 1 - criteria) % N;
		
		for(int i = 0; i < N; i++)
			sum += color[idx - 1][i];
		
		for(int i = 0; i < N; i++)
			color[idx][i] = (sum * quotient) + color[idx - 1][i];
		
		for(int i = 1; i <= remain; i++) {
			for(int j = 0; j < N; j++)
				color[idx][(i + j) % N] += color[idx - 1][j];
		}
		quotient = criteria / N;
		remain = criteria % N;
		
		for(int i = 0; i < N; i++)
			color[idx][i] += (sum * quotient);
		
		for(int i = 1; i <= remain; i++) {
			for(int j = 0; j < N; j++)
				color[idx][(i + j) % N] += color[idx - 1][j];
		}
	}
}

