import java.util.Scanner;

public class Solution_6109 {
	static int N ;
	static int[][] board;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			N = sc.nextInt();
			String move = sc.nextLine().trim();
			board = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					board[i][j]=sc.nextInt();
				}
			}
			play(move);
			System.out.println("#"+testCase);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(board[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
	public static void play(String move) {
		switch (move) {
		case "up":
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N-1; x++) {
					int idx = x+1;
					while(idx<N-1&&board[idx][y]==0) {
						idx++;
					}
					if(board[x][y]==0) {
						board[x][y]=board[idx][y];
						board[idx][y]=0;
						while(idx<N-1&&board[idx][y]==0) {
							idx++;
						}
					}
					if(board[x][y]==board[idx][y]) {
						board[x][y]*=2;
						board[idx][y]=0;
					}
				}
			}
			break;
		case "down":
			for (int y = 0; y < N; y++) {
				for (int x = N-1; x > 0; x--) {
					int idx = x-1;
					while(idx>0&&board[idx][y]==0) {
						idx--;
					}
					if(board[x][y]==0) {
						board[x][y]=board[idx][y];
						board[idx][y]=0;
						while(idx>0&&board[idx][y]==0) {
							idx--;
						}
					}
					if(board[x][y]==board[idx][y]) {
						board[x][y]*=2;
						board[idx][y]=0;
					}
				}
			}
			break;
		case "left":
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N-1; y++) {
					int idx = y+1;
					while(idx<N-1&&board[x][idx]==0) {
						idx++;
					}
					if(board[x][y]==0) {
						board[x][y]=board[x][idx];
						board[x][idx]=0;
						while(idx<N-1&&board[x][idx]==0) {
							idx++;
						}
					}
					if(board[x][y]==board[x][idx]) {
						board[x][y]*=2;
						board[x][idx]=0;
					}
				}
			}
			break;
		case "right":
			for (int x = 0; x < N; x++) {
				for (int y = N-1; y > 0; y--) {
					int idx = y-1;
					while(idx>0&&board[x][idx]==0) {
						idx--;
					}
					if(board[x][y]==0) {
						board[x][y]=board[x][idx];
						board[x][idx]=0;
						while(idx>0&&board[x][idx]==0) {
							idx--;
						}
					}
					if(board[x][y]==board[x][idx]) {
						board[x][y]*=2;
						board[x][idx]=0;
					}
				}
			}
			break;
		default:
			break;
		}
	}
}
