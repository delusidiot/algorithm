import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2046_C {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		for (int i = 0; i < Integer.parseInt(line); i++) {
			System.out.print("#");
		}
	}

}
