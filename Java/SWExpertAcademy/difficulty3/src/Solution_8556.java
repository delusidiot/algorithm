import java.util.Scanner;

public class Solution_8556 {
	public static void main(String[] args) {
		//north 0 west 90
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int testCase = 1; testCase <= T; testCase++) {
			String line = sc.nextLine();
			//w 3 n 4
			int west = 0;
			int north = 0;
			for (int i = 0; i < line.length(); i++) {
				if(line.charAt(i)=='n') {
					north++;
					i+=3;
				}else if(line.charAt(i)=='w') {
					west++;
					i+=2;
				}
			}
			System.out.println(west+" "+north);
			String result = "";
			if(west==0&&north==1) {
				result="0";
			}else if(west==1&&north==0) {
				result="90";
			}else {
				int count = 0;
				while((90*west)%(2<<count)==0) {
					count++;
				}
				System.out.println(count);
				System.out.println((90*west)/(1<<count)+"/"+(1<<north-count));
			}
			System.out.println("#"+testCase+" "+result);
		}
	}
}
