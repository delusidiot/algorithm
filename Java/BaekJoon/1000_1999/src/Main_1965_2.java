import java.util.ArrayList;
import java.util.Scanner;

public class Main_1965_2 {
	public static void main(String[] args) {
		//딱 LIS 문제
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		int[] boxSize = new int[n];
		for (int i = 0; i < n; i++) {
			boxSize[i]=sc.nextInt();
		}
		int idx = 0;
		list.add(boxSize[0]);
		System.out.println(list.size());
	}
}
