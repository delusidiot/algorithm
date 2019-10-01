import java.util.ArrayList;
import java.util.Scanner;

public class Main_6987 {
	static final int res = 4;
	static int[][] scores;
	public static ArrayList<Play> list;
	public static int[] tr =null;
	public static boolean play = false;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		tr = new int[2];
		list = new ArrayList<Play>();
		comb(6,2);
		for (int i = 0; i < res; i++) {
			play = false;
			scores = new int[6][3];
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
			if(win+draw+lose == 30) {
				DFS(0);
			}
			if(play)System.out.print("1 ");
			else System.out.print("0 ");
		}
	}
	public static class Play{
		int a;
		int b;
		public Play(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}
	}
	public static void comb(int n, int r) {
		if(r==0) {
			list.add(new Play(tr[0], tr[1]));
		}else if(n<r) {
			return;
		}else {
			tr[r-1]=n-1;
			comb(n-1,r-1);
			comb(n-1,r);
		}
	}
	public static void DFS(int game) {
		if(game==15) {
			play = true;
			return;
		}
		int i = list.get(game).a;
		int j = list.get(game).b;
		if(scores[i][1]>0&&scores[j][1]>0){
			scores[i][1]--;
			scores[j][1]--;
			DFS(game+1);
			scores[i][1]++;
			scores[j][1]++;
		}
		if(scores[i][0]>0&&scores[j][2]>0) {
			scores[i][0]--;
			scores[j][2]--;
			DFS(game+1);
			scores[i][0]++;
			scores[j][2]++;
		}
		if(scores[i][2]>0&&scores[j][0]>0){
			scores[i][2]--;
			scores[j][0]--;
			DFS(game+1);
			scores[i][2]++;
			scores[j][0]++;
		}
	}
}
