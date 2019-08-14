import java.util.Scanner;

public class Solution_7584_F {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String P = makeP();
		for (int testCase = 1; testCase <= T; testCase++) {
			int K = sc.nextInt();
			System.out.println("#"+testCase+" "+P.charAt(K-1));
		}
		
	}
	public static String makeP() {
		String start = "0";
		while(start.length()<=100000) {
			start = start+"0"+f(g(start));
		}
		return start;
	}
	public static String f(String line) {// 0->1, 1->0으로 반전
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < line.length(); i++) {
			if(line.charAt(i)=='0') {
				sb.append("1");
			}else {
				sb.append("0");
			}
		}
		return sb.toString();
	}
	public static String g(String line) {// 좌우 반전
		return (new StringBuffer(line)).reverse().toString();
	}
}
//100000000000000000