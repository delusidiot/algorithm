import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2043_C {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int P = Integer.parseInt(line.split(" ")[0]);
		int K = Integer.parseInt(line.split(" ")[1]);
		int count = 1;
		while(P!=K) {
			K++;
			count++;
		}
		System.out.println(count);
	}
}
