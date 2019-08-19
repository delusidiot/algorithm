import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_2007_Group_4 {
	static BufferedReader br;
	static BufferedWriter bw;
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			String line = br.readLine();
			int i = 0;
			for (int j = 1; j < line.length(); j++) {
				if(line.charAt(i)==line.charAt(j)) i++;
				else i = 0;
			}
			bw.write("#"+testCase+" "+(line.length()-i)+"\n");
			bw.flush();
		}
		bw.close();
	}
}
