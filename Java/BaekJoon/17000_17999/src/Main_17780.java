import java.util.Arrays;
import java.util.Scanner;

public class Main_17780 {
	final static int ENDGAME = 3;
	final static int RED = 1;
	final static int BLUE = 2; 
	static Scanner sc ;
	final static int[] dx = {0,0,0,-1,1};
	final static int[] dy = {0,1,-1,0,0};
	static class Piece{
		int x;
		int y;
		int way;
		int level;
		public Piece(int x, int y, int way) {
			super();
			this.x = x;
			this.y = y;
			this.way = way;
			this.level = 0;
		}
		@Override
		public String toString() {
			return "Piece [x=" + x + ", y=" + y + ", way=" + way + ", level=" + level + "]";
		}
	}
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] board = new int[N+2][N+2]; //white == 0, red == 1, blue == 2 
		for (int i = 0; i < board.length; i++) {
			Arrays.fill(board[i], 2);
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				board[i][j]=sc.nextInt();
			}
		}
		Piece[] pieces = new Piece[K];
		for (int i = 0; i < K; i++) {
			pieces[i]= new Piece(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		boolean check= true;
		int turn = 0;
		
		while(check) {
			turn++;
			for (int i = 0; i < K; i++) {
				if(pieces[i].level != 0) continue; //가장 아래의 말이 아니면 움직이지 않음.
				int nx = pieces[i].x+dx[pieces[i].way];
				int ny = pieces[i].y+dy[pieces[i].way];
				if(board[nx][ny]==BLUE) {
					pieces[i].way=reverse_way(pieces[i].way);
					nx = pieces[i].x+dx[pieces[i].way];
					ny = pieces[i].y+dy[pieces[i].way];
					if(board[nx][ny]==BLUE) {
						nx = pieces[i].x;
						ny = pieces[i].y;
					}
				}
				int topMax = 0;
				for (int j = 0; j < K; j++) {// 원래 좌표에 얼마나 쌓여있는가
					if(j==i) continue;
					if(pieces[j].x==nx&&pieces[j].y==ny) {
						if(topMax<=pieces[j].level) {
							topMax=pieces[j].level+1;
						}
					}
				}
				for (int j = 0; j < K; j++) {//자신을 제외한 다른 말이 같은 좌표에 있다면 옮기기
					if(j == i || pieces[j].x!=pieces[i].x || pieces[j].y!=pieces[i].y) continue;
					
					pieces[j].x = nx;
					pieces[j].y = ny;
					pieces[j].level += topMax;
					if(pieces[j].level>=ENDGAME) {
						check = false;
					}
				}
				//자신은 가장 마지막에 옮깁니다.
				pieces[i].x = nx;
				pieces[i].y = ny;
				pieces[i].level += topMax;
				if(pieces[i].level>=ENDGAME) {
					check = false;
				}
				if(board[pieces[i].x][pieces[i].y]==RED && topMax==0) { //붉은 색일때 가장 아래의 말과 가장 위의 말의 level 교체
					Piece bottom = null;
					Piece top = null;
					int topLevel = 0;
					for (int j = 0; j < K; j++) {
						if(pieces[j].x==pieces[i].x && pieces[j].y==pieces[i].y) {
							if(pieces[j].level==0)
								bottom = pieces[j];
							if(pieces[j].level>topLevel) {
								top = pieces[j];
								topLevel=pieces[j].level;
							}
						}
					}
					bottom.level = topLevel;
					if(top!=null)
						top.level = 0;
				}
			}
			if(turn >= 1000) {
				check=false;
				turn = -1;
			}
		}
		System.out.println(turn);
	}
	public static int reverse_way(int way) {
		if( way == 1 ) return 2;
		else if( way == 2 ) return 1;
		else if( way == 3 ) return 4;
		else return 3; //way == 4
	}
}
