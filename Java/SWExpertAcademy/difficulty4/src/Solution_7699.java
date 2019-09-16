import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_7699{
	static BufferedReader br;
	static BufferedWriter bw;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int max = 0;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			String line = br.readLine();
			int R = Integer.parseInt(line.split(" ")[0]);
			int C = Integer.parseInt(line.split(" ")[1]);
			char[][] land = new char[R+2][C+2];
			boolean[] checkAlpha = new boolean[28];// A==1 ~Z ==26
			boolean[][] checkLand = new boolean[R+2][C+2];
			int count = 0;
			max = 0;
			for (int i = 1; i <= R; i++) {
				line = br.readLine();
				for (int j = 1; j <= C; j++) {
					land[i][j]=line.charAt(j-1);
				}
			}
			for (int i = 1; i <= R; i++) {
				for (int j = 1; j <= C; j++) {
					checkLand[i][j]=true;
				}
			}
			dfs(land, checkLand, checkAlpha, 1, 1, count);
			System.out.println("#"+testCase+" "+max);
		}
		br.close();
		bw.close();
	}
	static void dfs(char[][] land, boolean[][] checkLand, boolean[] checkAlpha,int x, int y,int count) {
		checkLand[x][y]=false;
		checkAlpha[land[x][y]-'A']=true;
		count++;
		if(max < count)
			max=count;
		for (int i = 0; i < dx.length; i++) {
			x+=dx[i];
			y+=dy[i];
			if((checkLand[x][y])&&(!checkAlpha[land[x][y]-'A'])) {
				dfs(land, checkLand, checkAlpha, x, y,count);
			}
			x-=dx[i];
			y-=dy[i];
		}
		checkLand[x][y]=true;
		checkAlpha[land[x][y]-'A']=false;
	}
}
