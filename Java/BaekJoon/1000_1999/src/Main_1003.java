import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main_1003 {
	static int[] p0;
	static int[] p1;
	static final int max =41;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		p0=new int[max];
		p1=new int[max];
		for (int i = 0; i < max; i++) {
			fibo2(i);
		}
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			bw.write(String.valueOf(p0[N])+" "+String.valueOf(p1[N])+"\n");
			bw.flush();
		}
		br.close();
		bw.close();
	}
	public static void fibo2(int n){
		if(n==0) {
			p0[0]=1;
			p1[0]=0;
		}else if(n ==1) {
			p0[1]=0;
			p1[1]=1;
		}else {
			p0[n]=p0[n-2]+p0[n-1];
			p1[n]=p1[n-2]+p1[n-1];
		}
	}
}
