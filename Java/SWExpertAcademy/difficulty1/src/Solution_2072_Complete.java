import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//홀수 숫자만 출력
public class Solution_2072_Complete {
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
				int number = Integer.parseInt(c);
				if(number%2==1) {
					result += number;
				}
			}
			System.out.println("#"+i+" "+result);
		}
	}
}
