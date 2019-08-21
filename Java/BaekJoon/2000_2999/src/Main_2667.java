import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_2667 {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,-1,1};
	static BufferedReader br;
	static BufferedWriter bw;
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[N+2][N+2];
		boolean[][] checked = new boolean[N+2][N+2];
		for (int i = 1; i < N+1; i++) {
			String line = br.readLine();
			for (int j = 1; j < N+1; j++) {
				board[i][j]=(line.charAt(j-1)-'0');
				if(board[i][j]==1)
					checked[i][j]=true;
			}
		}
		for (int i = 1; i < checked.length-1; i++) {
			for (int j = 1; j < checked.length-1; j++) {
				if(checked[i][j]) {
					int result = dfs(i,j,0,board,checked);
					System.out.println(result);
				}
			}
		}
//		for (int i = 0; i < N+2; i++) {
//			System.out.println(Arrays.toString(board[i]));
//		}
	}
	public static int dfs(int x, int y, int count, int[][] board, boolean[][] checked) {
		for (int i = 0; i < dx.length; i++) {
			checked[x][y]=false;
			x+=dx[i];
			y+=dy[i];
			if(checked[x][y]) {
				count ++;
				dfs(x, y, count, board, checked);
			}
		}
		return count;
	}
}
