import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2468 {
	static BufferedReader br;
	static BufferedWriter bw;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int max = 0;
	static int count = 0;
	static int result = 0;
	public static void main(String[] args)throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());//안전지역 한변의 길이
		StringTokenizer st = null;
		int[][] cheese = new int[N][N];
		max = 0;

		result = 1;// 처음엔 무조건 한덩이
		int[][] copyCheese = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				cheese[i][j]=Integer.parseInt(st.nextToken());
				if(cheese[i][j]>max)
					max=cheese[i][j];
			}
		}
		for (int i = 1; i <= max; i++) {
			for (int k = 0; k < cheese.length; k++) {
				System.arraycopy(cheese[k], 0, copyCheese[k], 0, cheese.length);
			}
			count = 0;
			for (int j = 0; j < copyCheese.length; j++) {
				for (int j2 = 0; j2 < copyCheese.length; j2++) {
					dfs(i, copyCheese, j, j2, N,true);
					if(count>result) result = count;
				}
			}
		}
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}
	public static void dfs(int eat,int[][] cheese,int start, int end,int N, boolean C) {
		if(cheese[start][end]<=eat) return;
		if(C) count++;

		cheese[start][end]=0;
		C=false;
		for (int i = 0; i < 4; i++) {
			int x = start+dx[i];
			int y = end+dy[i];
			if(x<0||x>=N||y<0||y>=N)
				continue;
			dfs(eat, cheese, x, y, N,C);
		}
	}
}
