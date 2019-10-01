import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2636_C {
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int R;
	static int C;
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		int[][] cheese = new int[R][C];
		int max = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				cheese[i][j]=sc.nextInt();
			}
		}
		BFS(cheese);
	}
	public static void BFS(int[][] cheese) {
		Queue<Node> q = new LinkedList<>();
		boolean[][] melt = new boolean[R][C];
		Queue<Node> melting = new LinkedList<>();
		ArrayList<Integer> m = new ArrayList<>();
		int count = 1;//녹는 애들 카운트
		while(count!=0) {
			count = 0;
			melt = new boolean[R][C];
			q.add(new Node(0, 0));
			melt[0][0]=true;
			while(!q.isEmpty()) {
				Node n = q.poll();
				for (int i = 0; i < dx.length; i++) {
					int nx = n.x + dx[i];
					int ny = n.y + dy[i];
					if(nx<R&&nx>=0&&ny<C&&ny>=0&&!melt[nx][ny]) {
						melt[nx][ny]=true;
						if(cheese[nx][ny]==0) {
							q.offer(new Node(nx, ny));
						}
						if(cheese[nx][ny]==1) {
							melting.add(new Node(nx, ny));
							count++;
						}
					}
				}
			}
			System.out.println(melting);
			while(!melting.isEmpty()) {
				Node n = melting.poll();
				cheese[n.x][n.y] = 0;
			}
			
			for (int i = 0; i < cheese.length; i++) {
				System.out.println(Arrays.toString(cheese[i]));
			}
			System.out.println(count);
			
			m.add(count);
		}
		System.out.println((m.size()-1));
		System.out.println(m.get(m.size()-2));
	}
}
