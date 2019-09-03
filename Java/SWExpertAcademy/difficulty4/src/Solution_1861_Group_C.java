import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1861_Group_C {
	public static BufferedReader br;
	public static BufferedWriter bw;
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static int max = 0;
	public static int minRoom = 0;
	public static int N = 0;
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			max = 0;
			N = Integer.parseInt(br.readLine());
			int[][] board = new int[N+2][N+2];
			StringTokenizer st = null;
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 1; j <= N; j++) {
					board[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			int count = 0;
			minRoom = Integer.MAX_VALUE;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					check = new boolean[4];
					count = DFS(board, check, i, j, 1);
					if(max<=count) {
						if(max!=count)minRoom = Integer.MAX_VALUE;
						max = count;
						if(minRoom>=board[i][j]) {
							minRoom = board[i][j];
						}
					}
				}
			}
			bw.write("#"+testCase+" "+minRoom+" "+max+" \n");
		}
		bw.close();
	}
	public static int DFS(int[][] board, boolean[] check,int x, int y,int count) {
		if(check[0]&&check[2]&&check[3]&&check[1]) {
			return count;
		}else {
			Arrays.fill(check, false);
		}
		for (int i = 0; i < dx.length; i++) {
			int nextX = x+dx[i];
			int nextY = y+dy[i];
			if(board[x][y]+1==board[nextX][nextY]) {
				count = DFS(board, check, nextX, nextY, count+1);
			}else {
				check[i]=true;
			}
		}
		return count;
	}
}
