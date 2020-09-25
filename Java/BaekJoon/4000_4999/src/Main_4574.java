import java.util.Scanner;

public class Main_4574 {
	static Scanner sc;
	static final int BOARD_SIZE = 9;
	static int[][] sudokuBoard;
	static boolean[][][] sudokuAnswerBoard;
	
	public static boolean fill(int row, int col, int num) {
		boolean result = false;
		num--;
		boolean[] check = new boolean[BOARD_SIZE+1];
		for (int i = 0; i < BOARD_SIZE; i++) {
			sudokuAnswerBoard[row][i][num] = true;
			sudokuAnswerBoard[i][col][num] = true;
		}
		if(row >= 0 && row < 3) {
			if(col >= 0 && col < 3) { // 1번
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						sudokuAnswerBoard[i][j][num] = true;
						check[sudokuBoard[i][j]] = true;
					}
				}
			}else if(col >= 3 && col < 6) { // 2번
				for (int i = 0; i < 3; i++) {
					for (int j = 3; j < 6; j++) {
						sudokuAnswerBoard[i][j][num] = true;
						check[sudokuBoard[i][j]] = true;
					}
				}
			}else { // 3번  // 6-8
				for (int i = 0; i < 3; i++) {
					for (int j = 6; j < 9; j++) {
						sudokuAnswerBoard[i][j][num] = true;
						check[sudokuBoard[i][j]] = true;
					}
				}
			}
		}else if(row >= 3 && row < 6) { 
			if(col >= 0 && col < 3) { // 4번
				for (int i = 3; i < 6; i++) {
					for (int j = 0; j < 3; j++) {
						sudokuAnswerBoard[i][j][num] = true;
						check[sudokuBoard[i][j]] = true;
					}
				}
			}else if(col >= 3 && col < 6) { // 5번
				for (int i = 3; i < 6; i++) {
					for (int j = 3; j < 6; j++) {
						sudokuAnswerBoard[i][j][num] = true;
						check[sudokuBoard[i][j]] = true;
					}
				}
			}else { // 6번 // 6-8
				for (int i = 3; i < 6; i++) {
					for (int j = 6; j < 9; j++) {
						sudokuAnswerBoard[i][j][num] = true;
						check[sudokuBoard[i][j]] = true;
					}
				}
			}
		}else { // 6-8
			if(col >= 0 && col < 3) { // 7번
				for (int i = 6; i < 9; i++) {
					for (int j = 0; j < 3; j++) {
						sudokuAnswerBoard[i][j][num] = true;
						check[sudokuBoard[i][j]] = true;
					}
				}
			}else if(col >= 3 && col < 6) { // 8번
				for (int i = 6; i < 9; i++) {
					for (int j = 3; j < 6; j++) {
						sudokuAnswerBoard[i][j][num] = true;
						check[sudokuBoard[i][j]] = true;
					}
				}
			}else { // 9번 // 6-8
				for (int i = 6; i < 9; i++) {
					for (int j = 6; j < 9; j++) {
						sudokuAnswerBoard[i][j][num] = true;
						check[sudokuBoard[i][j]] = true;
					}
				}
			}
		}
		int count = 0;
		for (int i = 1; i <= BOARD_SIZE; i++) {
			if(!check[i]) count++;
		}
		if(count == 1)result =true;
		return result;
	}//0-2 3-5 6-8
	
	

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int haveGrid = -1;
		int puzzleNumber = 0;
		while(true) {
			puzzleNumber++;
			int answerCounter = 9; // 81
			haveGrid = sc.nextInt();
			if(haveGrid == 0) break;
			sc.nextLine();
			sudokuBoard = new int[BOARD_SIZE][BOARD_SIZE];
			sudokuAnswerBoard = new boolean[BOARD_SIZE][BOARD_SIZE][BOARD_SIZE];
			for (int i = 0; i < haveGrid; i++) {
				String[] dominoNumbers = sc.nextLine().split(" ");
				
				int row = dominoNumbers[1].charAt(0)-'A';
				int col = dominoNumbers[1].charAt(1)-'1';
				int num = Integer.parseInt(dominoNumbers[0]);
				sudokuBoard[row][col] = num;
				fill(row, col, num);
				
				row = dominoNumbers[3].charAt(0)-'A';
				col = dominoNumbers[3].charAt(1)-'1';
				num = Integer.parseInt(dominoNumbers[2]);
				sudokuBoard[dominoNumbers[3].charAt(0)-'A'][dominoNumbers[3].charAt(1)-'1'] = Integer.parseInt(dominoNumbers[2]);
				fill(row, col, num);
				answerCounter += 2;
			}
			System.out.println(answerCounter);
			String[] numbers = sc.nextLine().split(" ");
			for (int i = 0; i < 9; i++) {
				int row = numbers[i].charAt(0)-'A';
				int col = numbers[i].charAt(1)-'1';
				sudokuBoard[row][col] = i+1;
				fill(row, col, i+1);
			}
			System.out.println("Before Puzzle "+puzzleNumber);
			for (int i = 0; i < BOARD_SIZE; i++) {
				for (int j = 0; j < BOARD_SIZE; j++) {
					System.out.print(sudokuBoard[i][j]);
				}
				System.out.println();
			}
			for (int i = 0; i < BOARD_SIZE; i++) {
				for (int j = 0; j < BOARD_SIZE; j++) {
					for (int k = 0; k < BOARD_SIZE; k++) {
						System.out.print(sudokuAnswerBoard[i][j][k]+"\t");
					}
					System.out.print("|");
				}
				System.out.println();
			}
			
			while(answerCounter != 81) {
				int counter = 0;
				for (int r = 0; r < BOARD_SIZE; r++) {
					for (int c = 0; c < BOARD_SIZE; c++) {
						if(sudokuBoard[r][c]==0) {
							int boolConter = 0;
							int answerNum = 0;
							for (int n = 0; n < BOARD_SIZE; n++) {
								if(!sudokuAnswerBoard[r][c][n]) {
									boolConter++;
									answerNum = n+1;
								}
							}
							if(boolConter == 1) {
								sudokuBoard[r][c] = answerNum;
								System.out.println(r +", "+c+" : "+ answerNum);
								System.out.println(fill(r,c,answerNum));
								counter++;
							}
						}
					}
				}
				answerCounter+= counter;
				System.out.println(answerCounter);
				System.out.println("Puzzle "+puzzleNumber);
				for (int i = 0; i < BOARD_SIZE; i++) {
					for (int j = 0; j < BOARD_SIZE; j++) {
						System.out.print(sudokuBoard[i][j]);
					}
					System.out.println();
				}
				System.out.println();
			}
			
			//// 출력
			System.out.println("Puzzle "+puzzleNumber);
			for (int i = 0; i < BOARD_SIZE; i++) {
				for (int j = 0; j < BOARD_SIZE; j++) {
					System.out.print(sudokuBoard[i][j]);
				}
				System.out.println();
			}
		}
	}

}
