import java.util.Scanner;

public class Main_4574_2 {
	static Scanner sc;
	static final int BOARD_SIZE = 9;
	static int[][] sudokuBoard;
	static boolean rows[][];
	static boolean cols[][];
	static boolean squares[][][];
	static boolean dominos[][];
	static int tc = 1;
	static boolean check;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		int haveGrid = -1;
		while(true) {
			haveGrid = sc.nextInt();
			sc.nextLine();
			if(haveGrid == 0) break;
			check = false;
			sudokuBoard = new int[BOARD_SIZE][BOARD_SIZE];
			rows = new boolean[BOARD_SIZE][BOARD_SIZE+1];
			cols = new boolean[BOARD_SIZE][BOARD_SIZE+1];
			squares = new boolean[3][3][BOARD_SIZE+1];
			dominos = new boolean[BOARD_SIZE+1][BOARD_SIZE+1];
			//initialization
			for (int i = 0; i < haveGrid; i++) {
				String[] dominoNumbers = sc.nextLine().split(" ");
				int U = Integer.parseInt(dominoNumbers[0]);
				String LU = dominoNumbers[1];
				int LURow = LU.charAt(0)-'A';
				int LUCol = LU.charAt(1)-'1';
				
				int V = Integer.parseInt(dominoNumbers[2]);
				String LV = dominoNumbers[3];
				int LVRow = LV.charAt(0)-'A';
				int LVCol = LV.charAt(1)-'1';
				
				dominos[U][V] = true;
				dominos[V][U] = true;
				
				sudokuBoard[LURow][LUCol] = U;
				sudokuBoard[LVRow][LVCol] = V;
				cols[LUCol][U] = true;
				cols[LVCol][V] = true;
				rows[LURow][U] = true;
				rows[LVRow][V] = true;
				
				squares[LURow/3][LUCol/3][U] = true;
				squares[LVRow/3][LVCol/3][V] = true;
			}
			String[] numbers = sc.nextLine().split(" ");
			for (int i = 1; i <= 9; i++) {
				int row = numbers[i-1].charAt(0)-'A';
				int col = numbers[i-1].charAt(1)-'1';
				rows[row][i] = true;
				cols[col][i] = true;
				sudokuBoard[row][col] = i;
				squares[row/3][col/3][i] = true;
			}
			System.out.println("Puzzle "+tc);
			DFS(0);
			tc++;
		}
	}
	public static void printBoard() {
		for (int r = 0; r < BOARD_SIZE; r++) {
			for (int c = 0; c < BOARD_SIZE; c++) {
				System.out.print(sudokuBoard[r][c]);
			}
			System.out.println();
		}
	}
	public static void DFS(int idx) {
		if(check)
			return;
		if(idx == BOARD_SIZE * BOARD_SIZE) {
			check = true;
			printBoard();
			return;
		}
		int row = idx / BOARD_SIZE;
		int col = idx % BOARD_SIZE;
		if(sudokuBoard[row][col]!=0) {
			DFS(idx + 1);
		}
		else {
			if(row < 8 && sudokuBoard[row+1][col]==0) {//세로
				for (int i = 1; i <= BOARD_SIZE; i++) {
					for (int j = i+1; j <= BOARD_SIZE; j++) {
						if(!dominos[i][j]) {
							dominos[i][j] = true;
							dominos[j][i] = true;
							if(!rows[row][i] && !cols[col][i] && !squares[row/3][col/3][i]) {
								if(!rows[row+1][j] && !cols[col][j] && !squares[(row+1)/3][col/3][j]) {
									rows[row][i] = true;
									cols[col][i] = true;
									squares[row/3][col/3][i] = true;
									
									rows[row+1][j] = true;
									cols[col][j] = true;
									squares[(row+1)/3][col/3][j] = true;
									
									sudokuBoard[row][col] = i;
									sudokuBoard[row+1][col] = j;
									
									DFS(idx + 1);
									
									rows[row][i] = false;
									cols[col][i] = false;
									squares[row/3][col/3][i] = false;
									
									rows[row+1][j] = false;
									cols[col][j] = false;
									squares[(row+1)/3][col/3][j] = false;
									
									sudokuBoard[row][col] = 0;
									sudokuBoard[row+1][col] = 0;
								}
							}
							if(!rows[row][j] && !cols[col][j] && !squares[row/3][col/3][j]) {
								if(!rows[row+1][i] && !cols[col][i] && !squares[(row+1)/3][col/3][i]) {
									rows[row][j] = true;
									cols[col][j] = true;
									squares[row/3][col/3][j] = true;
									
									rows[row+1][i] = true;
									cols[col][i] = true;
									squares[(row+1)/3][col/3][i] = true;
									
									sudokuBoard[row][col] = j;
									sudokuBoard[row+1][col] = i;
									
									DFS(idx + 1);
									
									rows[row][j] = false;
									cols[col][j] = false;
									squares[row/3][col/3][j] = false;
									
									rows[row+1][i] = false;
									cols[col][i] = false;
									squares[(row+1)/3][col/3][i] = false;
									
									sudokuBoard[row][col] = 0;
									sudokuBoard[row+1][col] = 0;
								}
							}
							dominos[i][j] = false;
							dominos[j][i] = false;
						}
					}
				}
			}
			if(col < 8 && sudokuBoard[row][col+1]==0) {//가로
				for (int i = 1; i <= BOARD_SIZE; i++) {
					for (int j = i+1; j <= BOARD_SIZE; j++) {
						if(!dominos[i][j]) {
							dominos[i][j] = true;
							dominos[j][i] = true;
							
							if(!rows[row][i] && !cols[col][i] && !squares[row/3][col/3][i]) {
								if(!rows[row][j] && !cols[col+1][j] && !squares[row/3][(col+1)/3][j]) {
									rows[row][i] = true;
									cols[col][i] = true;
									squares[row/3][col/3][i] = true;
									
									rows[row][j] = true;
									cols[col+1][j] = true;
									squares[row/3][(col+1)/3][j] = true;
									
									sudokuBoard[row][col] = i;
									sudokuBoard[row][col+1] = j;
									
									DFS(idx +2);
									
									rows[row][i] = false;
									cols[col][i] = false;
									squares[row/3][col/3][i] = false;
									
									rows[row][j] = false;
									cols[col+1][j] = false;
									squares[row/3][(col+1)/3][j] = false;
									
									sudokuBoard[row][col] = 0;
									sudokuBoard[row][col+1] = 0;
								}
							}
							if(!rows[row][j] && !cols[col][j] && !squares[row/3][col/3][j]) {
								if(!rows[row][i] && !cols[col+1][i] && !squares[row/3][(col+1)/3][i]) {
									rows[row][j] = true;
									cols[col][j] = true;
									squares[row/3][col/3][j] = true;
									
									rows[row][i] = true;
									cols[col+1][i] = true;
									squares[row/3][(col+1)/3][i] = true;
									
									sudokuBoard[row][col] = j;
									sudokuBoard[row][col+1] = i;
									
									DFS(idx +2);
									
									rows[row][j] = false;
									cols[col][j] = false;
									squares[row/3][col/3][j] = false;
									
									rows[row][i] = false;
									cols[col+1][i] = false;
									squares[row/3][(col+1)/3][i] = false;
									
									sudokuBoard[row][col] = 0;
									sudokuBoard[row][col+1] = 0;
								}
							}
							dominos[i][j] = false;
							dominos[j][i] = false;
						}
					}
				}
			}
		}
	}
}

