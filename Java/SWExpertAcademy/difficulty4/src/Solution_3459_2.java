import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_3459_2 {
	public static BufferedReader br;
	public static BufferedWriter bw;
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String result = "";
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			long N = Long.parseLong(br.readLine());
			long inc = 4;
			long tmp =1;
			if(N==1)
				result = "Bob";
			else {
				while(tmp<N) {
					tmp += inc;
					if(N<= tmp) {
						result = "Alice";
						break;
					}
					tmp += inc;
					if(N<=tmp) {
						result = "Bob";
						break;
					}
					inc*=4;
				}
			}
			bw.write("#"+testCase+" "+result+ "\n");
			bw.flush();
		}
		br.close();
		bw.close();
	}
}
