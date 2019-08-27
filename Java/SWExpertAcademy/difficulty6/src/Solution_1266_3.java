import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution_1266_3 {
	static BufferedReader br;
	static BufferedWriter bw;
	static long[] p= new long[19];
//	static double com[] = {1.0, 18.0, 153.0, 816.0, 3060.0, 8568.0, 18564.0, 31824.0, 43758.0, 48620.0,
//							43758.0, 31824.0, 18564.0, 8568.0, 3060.0, 816.0, 153.0, 18.0, 1.0};
	static double[] com = new double[19];
	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 19; i++) {
			fact(i);
		}
		System.out.println(Arrays.toString(p));
		for (int i = 0; i < com.length; i++) {
			com[i]=comb2(18,i);
		}
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] notPrimeNumber = {1,1,0,0,1,0,1,0,1,1,1,0,1,0,1,1,1,0,1};//{0,1,4,6,8,9,10,12,14,15,16,18};
		int[] primeNumber    = {0,0,1,1,0,1,0,1,0,0,0,1,0,1,0,0,0,1,0};
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			String line = br.readLine();
			double A = Double.parseDouble(line.split(" ")[0])/100.0;
			double B = Double.parseDouble(line.split(" ")[1])/100.0;
			double OneMinusA = (double)(100-Integer.parseInt(line.split(" ")[0]))/100.0;
			double OneMinusB = (double)(100-Integer.parseInt(line.split(" ")[1]))/100.0;
			int count = 0;
			double result = 0;
			for (int i = 0; i <= 18; i++) {
				for (int j = 0; j <= 18; j++) {
					if(primeNumber[i]==1||primeNumber[j]==1) {
						count ++;
						result += (com[i] * Math.pow(A,i) * Math.pow(OneMinusA, 18-i)
								  *com[j] * Math.pow(B,j) * Math.pow(OneMinusB, 18-j));
					}
					
				}
			}
			bw.write("#"+testCase+" "+String.format("%.6f", (result))+"\n");
			bw.flush();
		}
		bw.close();
	}
	public static void fact(int n) {
		if(n==0) {
			p[n]=1;
			return;
		}
		if(n==1) {
			p[n]=1;
			return;
		}
		p[n]=p[n-1]*n;
	}
	public static long perm2(int n, int r) {
		return p[n]/p[n-r];
	}
	public static long comb2(int n, int r) { // 0부터 시작해서 r 까지
		return perm2(n,r)/p[r];
	}
}
