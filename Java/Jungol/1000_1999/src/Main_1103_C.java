import java.util.Scanner;

public class Main_1103_C {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int store = sc.nextInt();
		int[][] stores = new int[store][2];
		for (int i = 0; i < stores.length; i++) {
			stores[i][0]=sc.nextInt();
			stores[i][1]=sc.nextInt();
		}
		//1 북 2 남 3 서 4 동
		//북남 왼  동서 위
		int userDir=sc.nextInt();
		int userPos=sc.nextInt();
		int result = 0;
		for (int i = 0; i < store; i++) {
			switch (userDir) {
			case 1:case 2:
				switch (stores[i][0]) {
				case 1:
					result+=(userDir==1)? Math.abs(userPos-stores[i][1]):c+Math.min(userPos+stores[i][1], 2*r-userPos-stores[i][1]);
					break;
				case 2:
					result+=(userDir==1)? c+Math.min(userPos+stores[i][1], 2*r-userPos+stores[i][1]): Math.abs(userPos-stores[i][1]);
					break;
				case 3:
					result+=(userDir==1)? userPos+stores[i][1]:userPos+c-stores[i][1];
					break;
				case 4:
					result+=(userDir==1)? r-userPos+stores[i][1]:r-userPos+c-stores[i][1];
					break;
				default:
					break;
				}
				break;
			case 3:case 4:
				switch (stores[i][0]) {
				case 1:
					result+=(userDir==3)? userPos+stores[i][1]:userPos+r-stores[i][1];
					break;
				case 2:
					result+=(userDir==3)? c-userPos+stores[i][1] : c-userPos+r-stores[i][1];
					break;
				case 3:
					result+=(userDir==3)? Math.abs(userPos-stores[i][1]):r+Math.min(userPos+stores[i][1], 2*r-userPos-stores[i][1]);
					break;
				case 4:
					result+=(userDir==3)? r+Math.min(userPos+stores[i][1], 2*r-userPos-stores[i][1]):Math.abs(userPos-stores[i][1]);
					break;
				default:
					break;
				}
				break;
			default:
				break;
			}
		}
		System.out.println(result);
	}
}
