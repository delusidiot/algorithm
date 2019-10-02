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
			int angle = 0;
			for (int i = 0; i < line.length(); i++) {
				if(line.charAt(i)=='n') {
					north++;
					i+=3;
					
				}else if(line.charAt(i)=='w') {
					west++;
					i+=2;
				}
			}
			double denominator = Math.pow(2,( north + west - 2));
			int forth = 45;
			int numerator = 0;
			for (int i = 0; i < west; i++) {
				forth<<=i;
				numerator+=forth;
			}
			
			System.out.println("#"+testCase+" "+numerator+"/"+denominator);
		}
	}
}
