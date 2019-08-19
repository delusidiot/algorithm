import java.util.Scanner;

public class Solution_2007_Group {
	static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int testCase = 1; testCase <= T; testCase++) {
			String line = sc.nextLine();
			char[] lineToChar = line.toCharArray();
			int end = 0;
			for (int i = 1; i < lineToChar.length-1; i++) {
				if(lineToChar[i]==lineToChar[0]&&lineToChar[i+1]==lineToChar[1]) {
					end = i;
					break;
				}
			}
			System.out.println("#"+testCase+" "+end);
		}
	}
}
