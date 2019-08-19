import java.util.Scanner;

public class Solution_6900_C {
	static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			char[][] win = new char[N][8];//복권번호저장
			int[] prizeMoney = new int[N];//당첨금 저장
			char[][] user = new char[M][8];
			sc.nextLine();
			String line;
			for (int i = 0; i < win.length; i++) {
				line=sc.nextLine();
				win[i]=line.split(" ")[0].toCharArray();
				prizeMoney[i] = Integer.parseInt(line.split(" ")[1]);
			}
			for (int i = 0; i < user.length; i++) {
				user[i]=sc.nextLine().toCharArray();
			}
			int money =0;
			for (int i = 0; i < win.length; i++) {
				for (int j = 0; j < user.length; j++) {
					for (int j2 = 0; j2 < user[j].length; j2++) {
						if(win[i][j2]!='*'&&win[i][j2]!=user[j][j2]) {
							break;
						}
						if(j2==user[j].length-1) money+=prizeMoney[i];
					}
				}
			}
			System.out.println("#"+testCase+" "+money);
		}

	}
}
