import java.util.Scanner;

public class Main_6987 {
	static final int res = 4;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < res; i++) {
			int[][] scores = new int[6][3];
			int win = 0;
			int draw = 0;
			int lose = 0;
			for (int j = 0; j < scores.length; j++) {
				for (int k = 0; k < scores[j].length; k++) {
					scores[j][k] = sc.nextInt();
					if(k==0) {
						win+=scores[j][k];
					}else if(k==1) {
						draw+=scores[j][k];
					}else {
						lose+=scores[j][k];
					}
				}
			}
			for (int j = 0; j < scores.length; j++) {
				for (int k = 0; k < scores.length; k++) {
					if(k==j) continue;
					if(scores[j][0]!=0&&scores[k][2]!=0) {
						scores[j][0]--;
						scores[k][2]--;
						win--;
						lose--;
					}
					if(scores[j][1]!=0&&scores[k][1]!=0) {
						scores[j][1]--;
						scores[k][1]--;
						draw-=2;
					}
					if(scores[j][2]!=0&&scores[k][0]!=0) {
						scores[j][2]--;
						scores[k][0]--;
						win--;
						lose--;
					}
				}
			}
			System.out.println(win +" "+ draw+" "+lose);
			boolean possible = true;
			if(win!=0||lose!=0||draw!=0)
				possible =false;
			if(possible)System.out.print("1 ");
			else System.out.print("0 ");
//			System.out.println();
		}
		
	}
}
