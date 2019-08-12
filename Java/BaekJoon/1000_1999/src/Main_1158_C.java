import java.util.LinkedList;
import java.util.Scanner;

public class Main_1158_C {
	static Scanner sc;
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		int[] numbers = new int[N];
		int idx = 0;
		for (int i = 0; i < numbers.length; i++) {
			idx = (idx + K-1)%(N-i);
			numbers[i]=list.get(idx);
			list.remove(idx);
		}
		String result = "";
		for (int i = 0; i < numbers.length; i++) {
			if(i == numbers.length-1) {
				result = result + numbers[i];
			}else {
				result = result + numbers[i]+", ";
			}
		}
		System.out.println("<"+result+">");
	}
}
