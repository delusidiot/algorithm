import java.util.Scanner;

public class Solution_2056_C {
	static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int testCase = 1; testCase <= T; testCase++) {
			String line = sc.nextLine();
			boolean effectiveness = true;
			switch (line.substring(4,6)) {
			case "01":case "03":case "05":case "07":case "08":case "10": case "12"://31일 까지
				if(Integer.parseInt(line.substring(6,8))<=0||Integer.parseInt(line.substring(6,8))>31)
					effectiveness= false;
				break;
			case "02":
				if(Integer.parseInt(line.substring(6,8))<=0||Integer.parseInt(line.substring(6,8))>28)
					effectiveness= false;
				break;
			case "04":case "06":case "09":case "11":
				if(Integer.parseInt(line.substring(6,8))<=0||Integer.parseInt(line.substring(6,8))>30)
					effectiveness= false;
				break;
			default:
					effectiveness= false;
				break;
			}
			if(effectiveness)
				System.out.println("#"+testCase+" "+line.substring(0, 4)+"/"+line.substring(4,6)+"/"+line.substring(6,8));
			else
				System.out.println("#"+testCase+" -1");
		}
		
	}

}
