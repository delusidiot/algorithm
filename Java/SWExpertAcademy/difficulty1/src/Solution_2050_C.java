import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2050_C {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String charactors = br.readLine();
		char[] charactor = charactors.toCharArray();
		for (int i = 0; i < charactor.length; i++) {
			System.out.print((charactor[i]-'A'+1)+" ");
		}
	}

}
