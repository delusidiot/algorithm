import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1629 {
	static BufferedReader br;
	static BufferedWriter bw;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		long C = Integer.parseInt(st.nextToken());
		long result = pow(A,B,C);
		bw.write(String.valueOf(result%C));
		bw.flush();
		br.close();
		bw.close();
	}
	public static long pow(long A, long B,long C) {
		if(B==0) return 1;
		long n = pow(A, B/2, C);
		long temp = n*n%C;
		if(B%2==0) {
			return temp;
		}else {
			return A*temp%C;
		}
	}
}
