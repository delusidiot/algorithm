import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2070_Complete {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		String[] numbers = null;
		for(int i = 1; i <= testCase; i++) {
			String line = br.readLine();
			numbers = line.split(" ");
			int first = Integer.parseInt(numbers[0]);
			int second = Integer.parseInt(numbers[1]);
			if(first<second) {
				line = "<";
			}else if(first==second) {
				line = "=";
			}else {
				line = ">";
			}
			System.out.println("#"+i+" "+line);
		}
	}
}
