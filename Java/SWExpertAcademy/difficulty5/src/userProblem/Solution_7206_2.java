package userProblem;

import java.util.HashMap;
import java.util.Scanner;

public class Solution_7206_2 {
	static HashMap<Integer, Integer> value = new HashMap<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			value.clear();
			int number = sc.nextInt();
			System.out.println("#"+testCase+" "+game(number));
		}
	}
	public static int game(int number) {
		if(number<10) {
			return 0;
		}
		if(value.containsKey(number)) {
			return value.get(number);
		}
		String s = String.valueOf(number);
		int len = s.length();
		int max = 0;
		for (int i = 1; i < (1<<len); i++) {
			int num = 0;
			int mul =1;
			for (int j = 0; j < len; j++) {
				if((i & (1<< j)) == 0) {
					num = num * 10 + (s.charAt(j)-'0');
				}else {
					mul *= num;
					num = s.charAt(j)-'0';
				}
			}
			mul *= num;
			num = game(mul);
			max = Math.max(max, num);
		}
		value.put(number, ++max);
		return max;
	}
}
