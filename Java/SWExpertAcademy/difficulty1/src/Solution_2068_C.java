import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2068_C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine().trim());
		String[] numbers = null;
		for(int i = 1; i <= testCase; i++) {
			int max = Integer.MIN_VALUE;
			String line = br.readLine();
			numbers = line.split(" ");
			for (String string : numbers) {
				int number = Integer.parseInt(string);
				if(max< number)
					max=number;
			}
			System.out.println("#"+i+" "+max);
		}
	}
}
