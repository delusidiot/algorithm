import java.util.Scanner;

public class Main_15685 {
	public static void main(String[] args) {
		int[][] dragon = new int[101][101];
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();//시작점  x
			int y = sc.nextInt();//시작점 y
			int d = sc.nextInt();//시작방향 0 x 좌표가 증가 하는 방향, 1 y좌표가 감소, 2 x 감소, 3 y 증가
			int g = sc.nextInt();//세대
			
			dragon[x][y]++;
			switch(d) {
			case 0:
				break;
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			}
		}
		int count = 0;
		for (int i = 0; i < 100; i++) {
			if(dragon[i][i]>0&&dragon[i+1][i]>0&&dragon[i][i+1]>0&&dragon[i+1][i+1]>0) {
				count ++;
			}
		}
		System.out.println(count);

	}
}
