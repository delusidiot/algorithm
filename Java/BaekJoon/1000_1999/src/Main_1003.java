import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_1003 {
	static int count0 =0;
	static int count1 =0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			count0=0;
			count1=0;
			int N = Integer.parseInt(br.readLine());
			fibo(N);
			bw.write(String.valueOf(count0)+" "+String.valueOf(count1));
			bw.flush();
		}
		br.close();
		bw.close();
	}
	public static int fibo(int n) {
		if(n==0) {
			count0++;
			return 0;
		}else if(n==1) {
			count1++;
			return 1;
		}else {
			return fibo(n-1)+fibo(n-2);
		}
	}
}
