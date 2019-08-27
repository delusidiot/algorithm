import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_7965 {
	static long[] answer = new long[1000001];
	static final long MOD = 1000000007;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int i = 1 ; i <=1000000; i++) {
			answer[i] = (answer[i-1] + divide(i,i)) % MOD;
		}
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			bw.write("#"+testCase+" "+answer[N]%MOD+"\n");
			bw.flush();
		}
		bw.close();
	}
	public static long divide(int a, int n) {
		if(n == 0) {
			return 1;
		}
		if(n == 1) {
			return a;
		}
		long temp = divide(a, n/2);
		if(n%2 == 0) {
			return (temp * temp) % MOD;
		}else {
			return ((temp * temp) % MOD * a) % MOD;
		}

	}
}
