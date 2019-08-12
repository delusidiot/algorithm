import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1106_copy_C {
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
		BFS(N, M, pawnR, pawnC, horseR, horseC, checked);
		System.out.println(count);
	}
	static public void BFS(int N, int M, int pawnR, int pawnC,int horseR, int horseC, boolean[][] checked) {
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		qx.offer(horseR);
		qy.offer(horseC);
		while(!qx.isEmpty()) {
			int size =qx.size();
			count ++;
			for (int k = 0; k < size; k++) {
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
}
