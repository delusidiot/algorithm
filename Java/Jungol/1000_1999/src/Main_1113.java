import java.util.Scanner;

public class Main_1113 {
	static int[] dx = {0, 0, 1, -1}; //우,좌, 하,상
	static int[] dy = {1, -1, 0, 0};
	static int M;
	static int N;
	static int m;
	static int n;
	static boolean[][] road;
	static int min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		min = 10000000;
		M = sc.nextInt();
		N = sc.nextInt();
		
		m = sc.nextInt();
		n = sc.nextInt();
		road = new boolean[M][N];
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				int in = sc.nextInt();
				if(in>0) {
					road[i][j]=true;
				}
			}
		}
		boolean[][] check = new boolean[M][N];
		DFS(0,0,0,-1,check);
		System.out.println(min-1);
	}
	
	public static void DFS(int x, int y, int count,int way,boolean[][] check) {
		if(min<count)return;
		if(x==m&&y==n) {
			if(min>count) {
				min = count;
			}
			return;
		}
		check[x][y]=true;
		for (int i = 0; i < dx.length; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0||nx>=M||ny<0||ny>=N)continue;
			if(!road[nx][ny]||check[nx][ny])continue;
			if(way == i) {
				DFS(nx, ny, count, i,check);
			}else {
				DFS(nx, ny, count+1, i,check);
			}
		}
		check[x][y]=false;
	}
}

