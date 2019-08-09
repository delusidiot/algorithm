import java.util.Scanner;

public class Solution_7964_C {
	private static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int city = 0;
		int distance = 0;
		int result = 0;
		
		for (int i = 1; i <= testCase; i++) {
			city = sc.nextInt();
			distance = sc.nextInt();
			result = gateway(city, distance);
			System.out.println("#"+i+" "+result);
		}
	}
	public static int gateway(int city, int distance) {
		int[] allCity = new int[city];
		for (int i = 0; i < allCity.length; i++) {
			allCity[i] = sc.nextInt();
		}
		int count = 0;
		int result = 0;
		for (int i = 0; i < allCity.length; i++) {
			count++;
			if(allCity[i] == 1)
				count = 0;
			if(count==distance) {
				count = 0;
				result++;
			}
		}
		return result;
	}
}
