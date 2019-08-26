import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_4406_C {
	static BufferedReader br ;
	static BufferedWriter bw ;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			String line = br.readLine();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < line.length(); i++) {
				if(line.charAt(i)=='a'||line.charAt(i)=='e'||line.charAt(i)=='i'||line.charAt(i)=='o'||line.charAt(i)=='u')continue;
				sb.append(line.charAt(i));
			}
			System.out.println("#"+testCase+" "+sb.toString());
		}
	}
}
