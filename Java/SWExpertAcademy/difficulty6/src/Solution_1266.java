import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_1266 {
	static BufferedReader br;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] primeNumber = {2,3,5,7,11,13,17};
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			String line = br.readLine();
			double A = Double.parseDouble(line.split(" ")[0]);
			double B = Double.parseDouble(line.split(" ")[1]);
			double result = 1;
			for (int i = 0; i < primeNumber.length; i++) {
				for (int j = 0; j < primeNumber[i]; j++) {
					result *= A;
				}
				for (int j = 0; j < 18-primeNumber[i]; j++) {
					result *= (1-A);
				}
			}
			bw.write("#"+testCase+" "+result+"\n");
			bw.flush();
		}
	}
	//
	public static void comb() {
		
	}
}
