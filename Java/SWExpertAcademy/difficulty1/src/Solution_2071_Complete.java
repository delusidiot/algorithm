import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Solution_2071_Complete {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		String[] numbers = null;
		int result = 0;
		for (int i = 1; i <= testCase; i++) {
			result = 0;
			String line = br.readLine();
			numbers = line.split(" ");
			for (String c : numbers) {
				result += Integer.parseInt(c);
			}
			if(result%10>=5)
				result=result/numbers.length+1;
			else
				result/=numbers.length;
			System.out.println("#"+i+" "+result);
		}
	}
}
