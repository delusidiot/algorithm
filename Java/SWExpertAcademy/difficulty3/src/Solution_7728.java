import java.util.Scanner;

public class Solution_7728 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int i = 1; i <= T; i++) {
			String s = sc.nextLine();
			int result = diversity(s);
			System.out.println("#"+i+" "+result);
		}
	}
	public static int diversity(String s) {
		char[] c = s.toCharArray();
		int count = 0;
		outer:for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c.length; j++) {
				if(c[i]==c[j]);
					continue outer;
			}
			count ++;
		}
		return count;
	}
}
