import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2029_C {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String T = br.readLine();
		for (int testCase = 1; testCase <= Integer.parseInt(T.trim()); testCase++) {
			String line = br.readLine();
			System.out.println("#"+testCase+" "+String.valueOf(Integer.parseInt(line.split(" ")[0])/Integer.parseInt(line.split(" ")[1]))+" "+String.valueOf(Integer.parseInt(line.split(" ")[0])%Integer.parseInt(line.split(" ")[1])));
		}
	}
}
