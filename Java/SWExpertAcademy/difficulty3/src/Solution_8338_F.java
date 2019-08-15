import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_8338_F {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			String[] numbers = br.readLine().split(" ");
			int result = 0;
			result+=Integer.parseInt(numbers[0]);
			int number = result;
			for (int i = 1; i < N; i++) {
				if(result < 2) {
					number = Integer.parseInt(numbers[i]);
					result += number;
					continue;
				}
				number = Integer.parseInt(numbers[i]);
				if(number < 2) {
					result += number;
				}else {
					result *= number;
				}
			}
			
			System.out.println("#"+testCase+" "+result);
		}
	}
}
