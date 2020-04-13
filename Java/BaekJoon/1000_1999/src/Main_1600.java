import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main_1600 {
	static int K;
	static int W;
	static int H;
	static int MIN;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[] horseX = {-2,-2,-1,-1,1,1,2,2};
	static int[] horseY = {-1,1,-2,2,-2,2,-1,1};
	static int[][] map;
	static boolean[][][] checked;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();
		map = new int[H][W];
		checked = new boolean[H][W][K+1];
		MIN = 999999999;
		for(int i = 0 ;i < H;i++) {
			for(int j = 0; j<W; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		checked[0][0][K]=true;
		BFS();
		System.out.println(MIN==999999999?-1:MIN);
	}
	static class Node{
		int x;
		int y;
		int k;
		public Node(int x, int y,int k) {
			super();
			this.x = x;
			this.y = y;
			this.k = k;
		}
	}
	public static void BFS() {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(0, 0, K));
		int count = 0;
		while(!q.isEmpty()) {
			int qSize = q.size();
			for(int c = 0; c <qSize;c++) {
				Node n = q.poll();
				if(n.x==H-1 && n.y==W-1) {
					MIN=count;
					return;
				}
				if(n.k>0) {
					for (int i = 0; i < 8; i++) {
						int nx=n.x+horseX[i];
						int ny=n.y+horseY[i];
						if(nx>=0&&nx<H&&ny>=0&&ny<W) {
							if(checked[nx][ny][n.k-1]||map[nx][ny]==1)continue;
								checked[nx][ny][n.k-1] = true;
								q.offer(new Node(nx, ny,n.k-1));
							}
					}
				}
				for (int i = 0; i < 4; i++) {
					int nx=n.x+dx[i];
					int ny=n.y+dy[i];
					if(nx>=0&&nx<H&&ny>=0&&ny<W) {
						if(checked[nx][ny][n.k]||map[nx][ny]==1)continue;
						checked[nx][ny][n.k] = true;
						q.offer(new Node(nx, ny,n.k));
					}
				}
			}
			count++;
		}
	}
}
