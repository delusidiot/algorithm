import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//중간값 찾기
public class Solution_2063_C {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		int[] numbers = new int[count];
		String n = br.readLine();
		for(int i = 0; i < count; i++) {
			numbers[i]=Integer.parseInt(n.split(" ")[i]);
		}
		Arrays.sort(numbers);
		System.out.println(numbers[count/2]);
	}

}
