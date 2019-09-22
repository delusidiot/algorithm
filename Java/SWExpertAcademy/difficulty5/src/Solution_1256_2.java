import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;


public class Solution_1256_2 {
	static BufferedReader br;
	static BufferedWriter bw;
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			int K = Integer.parseInt(br.readLine());
			String line = br.readLine();
			String[] suffix = new String[line.length()];
			for (int i = 0; i < line.length(); i++) {
				suffix[i]=line.substring(i);
			}
			Arrays.sort(suffix);
			bw.write("#"+testCase+" "+suffix[K-1]+"\n");
			bw.flush();
		}
		br.close();
		bw.close();
	}
}
