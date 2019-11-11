import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1733{
	static BufferedReader br;
	static BufferedWriter bw;
	static final int  N = 19;//가로 세로 19
	static int[] dx = {1,1,1,0,0,-1,-1,-1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};
	static int count = 0;
	static int[][] board;
	public static void main(String[] args)throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		count = 0;
		board = new int[N][N];
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()+" ");
			for (int j = 0; j < N; j++) {
				board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int result = 0;
		int resultX = 0;
		int resultY = 0;
		aa:for (int j = 0; j < board.length; j++) {
			for (int i = 0; i < board.length; i++) {
				if(board[i][j]==0)continue;
				for (int i2 = 0; i2 < dx.length; i2++) {
					count = 1;
					int x = i+dx[i2];
					int y = j+dy[i2];
					if(x>=N||y>=N||x<0||y<0)continue;
					int pair = 0;
					switch (i2) {
					case 0: pair = 7;
						break;
					case 1: pair = 6;
						break;
					case 2: pair = 5;
						break;
					case 3: pair = 4;
						break;
					case 4: pair = 3;
						break;
					case 5: pair = 2;
						break;
					case 6: pair = 1;
						break;
					case 7: pair = 0;
						break;
					default:
						break;
					}
					DFS(i2, pair, i, j, board[i][j]);
					if(count==5) {
						resultX=i;
						resultY=j;
						result=board[i][j];
						break aa;
					}
				}
			}
		}
		if(result == 0)
			bw.write(result+"\n");
		else 
			bw.write(result+"\n"+(resultX+1)+" "+(resultY+1)+"\n");
		br.close();
		bw.close();
	}
	static void DFS(int i2,int pair, int x, int y ,int number) {
		int idx = 1;
		int idxp = 1;
		int nxp = x+dx[pair];
		int nyp = y+dy[pair];
		while(!(nxp>=N||nyp>=N||nxp<0||nyp<0||board[nxp][nyp]==0)&&board[nxp][nyp]==number) {
			idxp++;
			nxp = x+(idxp*dx[pair]);
			nyp = y+(idxp*dy[pair]);
			count++;
		}
		int nx = x+dx[i2];
		int ny = y+dy[i2];
		if(i2==pair)return;
		while(!(nx>=N||ny>=N||nx<0||ny<0||board[nx][ny]==0)&&board[nx][ny]==number) {
			idx++;
			nx = x+(idx*dx[i2]);
			ny = y+(idx*dy[i2]);
			count++;
		}
	}
}
