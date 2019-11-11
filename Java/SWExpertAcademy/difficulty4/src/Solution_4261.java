import java.util.Scanner;

public class Solution_4261 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int testCase = 1; testCase <= T; testCase++) {
			String number = sc.next();
			int N = Integer.parseInt(sc.next());
			int count = 0;
			for (int i = 0; i < N; i++) {
				String strings = sc.next();
				if(strings.length()!=number.length())continue;
				boolean check= true;
				for (int j = 0; j < number.length(); j++) {
					if(number.charAt(j)=='2') {
						if(strings.charAt(j)=='a'||strings.charAt(j)=='b'||strings.charAt(j)=='c') {
						}else {
							check=false;
							break;
						}
					}else if(number.charAt(j)=='3') {
						if(strings.charAt(j)=='d'||strings.charAt(j)=='e'||strings.charAt(j)=='f') {
						}else {
							check=false;
							break;
						}
					}else if(number.charAt(j)=='4') {
						if(strings.charAt(j)=='g'||strings.charAt(j)=='h'||strings.charAt(j)=='i') {
						}else {
							check=false;
							break;
						}
						
					}else if(number.charAt(j)=='5') {
						if(strings.charAt(j)=='j'||strings.charAt(j)=='k'||strings.charAt(j)=='l') {
						}else {
							check=false;
							break;
						}
						
					}else if(number.charAt(j)=='6') {
						if(strings.charAt(j)=='m'||strings.charAt(j)=='n'||strings.charAt(j)=='o') {
						}else {
							check=false;
							break;
						}
						
					}else if(number.charAt(j)=='7') {
						if(strings.charAt(j)=='p'||strings.charAt(j)=='q'||strings.charAt(j)=='r'||strings.charAt(j)=='s') {
						}else {
							check=false;
							break;
						}
						
					}else if(number.charAt(j)=='8') {
						if(strings.charAt(j)=='t'||strings.charAt(j)=='u'||strings.charAt(j)=='v') {
						}else {
							check=false;
							break;
						}
						
					}else if(number.charAt(j)=='9') {
						if(strings.charAt(j)=='w'||strings.charAt(j)=='x'||strings.charAt(j)=='y'||strings.charAt(j)=='z') {
						}else {
							check=false;
							break;
						}
					}else {
						check=false;
						break;
					}
				}
				if(check) {
					count++;
				}
			}
			System.out.println("#"+testCase+" "+count);
		}
	}
}
