import java.util.Scanner;

public class Main_14889 {
	static int min = 1000000000;
	static int[][] ability;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ability = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ability[i][j] = sc.nextInt();
				
			}
		}
		int[] start = null;
		int[] link = null;
		first : for(int i =0; i < 1<<N; i++) {
			startScore = 0;
			linkScore =0;
			start = new int[N/2];
			link = new int[N/2];
			int idxS = 0;
			int idxL = 0;
			for (int j = 0; j < N; j++) {
				if((i & 1<<(j))!= 0) {
					if(idxS>=N/2) continue first;
					start[idxS++]=j;
				}else {
					if(idxL>=N/2) continue first;
					link[idxL++]=j;
				}
			}
			int score = 0;
			for (int j = 0; j < start.length-1; j++) {
				for (int k = j+1; k < start.length; k++) {
					startScore+=ability[start[j]][start[k]];
					startScore+=ability[start[k]][start[j]];
				}
			}
			for (int j = 0; j < start.length-1; j++) {
				for (int k = j+1; k < start.length; k++) {
					linkScore+=ability[link[j]][link[k]];
					linkScore+=ability[link[k]][link[j]];
				}
			}
			
			if(min>Math.abs(startScore-linkScore)) {
				min = Math.abs(startScore-linkScore);
			}
		}
		System.out.println(min);
	}
	static int[] tr = new int[2];
	static int startScore = 0;
	static int linkScore =0;
	static int comb(int n, int r,int[] arr,int score) {
		if( r==0 ) {
			score+= ability[tr[0]][tr[1]];
			score+= ability[tr[1]][tr[0]];
			return score;
			
		}
		else if(n<r) return 0;
		else {
			tr[r-1] = arr[n-1];
			comb(n-1,r-1,arr,score);
			comb(n-1,r,arr,score);
		}
		return 0;
	}
}
