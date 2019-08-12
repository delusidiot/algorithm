import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1106 {
	static Scanner sc;
	static int[] dx =  {1,2,1,2,-1,-2,-1,-2};
	static int[] dy =  {2,1,-2,-1,2,1,-2,-1};
	static int count = 0;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();//장기판 행의수
		int M = sc.nextInt();//장기판 열의수
		
		int horseR = sc.nextInt();//말 행
		int horseC = sc.nextInt();//말 열
		
		int pawnR = sc.nextInt();
		int pawnC = sc.nextInt();
		boolean[][] checked = new boolean[N+1][M+1];
//		dfs(N, M, pawnR, pawnC, horseR, horseC, 1,checked);
		BFS(N, M, pawnR, pawnC, horseR, horseC, checked);
		System.out.println(count);
	}
	static public void dfs(int N, int M, int pawnR, int pawnC,int horseR, int horseC, int start,boolean[][] checked) {
		for (int i = 0; i < 8; i++) {
			checked[horseR][horseC]=true;
			int x = horseR+dx[i];
			int y = horseC+dy[i];
			if(x<N && x>0 && y<M && y>0 && (x != pawnR|| y != pawnC)) {
				if(!checked[x][y])
					dfs(N, M, pawnR, pawnC, x, y, start+1,checked);
			}
			if(x == pawnR&& y == pawnC) {
				count = start;
			}
		}
	}
	static public void BFS(int N, int M, int pawnR, int pawnC,int horseR, int horseC, boolean[][] checked) {
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		qx.offer(horseR);
		qy.offer(horseC);
		while(!qx.isEmpty()) {
			count ++;
			int x = qx.poll();
			int y = qy.poll();
			checked[x][y] = true;
			for (int i = 0; i < dx.length; i++) {
				if(x+dx[i]>0&&x+dx[i]<=N&&y+dy[i]>0&&y+dy[i]<=M) {
					if(pawnR==x+dx[i]&&pawnC==y+dy[i])
						return;
					if(!checked[x+dx[i]][y+dy[i]]){
						checked[x+dx[i]][y+dy[i]] = true;
						qx.offer(x+dx[i]);
						qy.offer(y+dy[i]);
					}
				}
			}
		}
	}
}
