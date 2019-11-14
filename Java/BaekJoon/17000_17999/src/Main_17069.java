import java.util.Scanner;


public class Main_17069 {
	static int N;
	static int[][] home;
	static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		N = sc.nextInt();
		home = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				home[i][j] = sc.nextInt();
			}
		}
		
		DFS2(1,2,1);
		System.out.println(count);
	}
	static long count = 0;
	public static void DFS2(int x, int y, int status) {
		if(x>N||y>N) return;
		if(x==N && y ==N) {
			count ++;
			return;
		}
		switch(status) {
		case 1:
			if(home[x][y]==1) return;
			DFS2(x,y+1,1);
			DFS2(x+1,y+1,3);
			break;
		case 2:
			if(home[x][y]==1) return;
			DFS2(x+1,y,2);
			DFS2(x+1,y+1,3);
			break;
		case 3:
			if(home[x-1][y]==1||home[x][y-1]==1||home[x][y]==1) return;
			DFS2(x,y+1,1);
			DFS2(x+1,y,2);
			DFS2(x+1,y+1,3);
			break;
		}
	}
}

