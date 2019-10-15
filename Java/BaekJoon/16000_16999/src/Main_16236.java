import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_16236 {
	public static int[] dx = {-1,0,1,0};
	public static int[] dy = {0,-1,0,1};
	public static class Shark{
		int x;
		int y;
		int size;
		int eating;
		public Shark(int x, int y, int size) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
			this.eating = 0;
		}
		public void sizeUp(int eathing) {
			if(eathing==size) {
				eathing = 0;
				size ++;
			}
		}
		public void searchFish() {
			Arrays.fill(check, false);
			Queue<Node> q = new LinkedList<>();
			q.add(new Node(this.x, this.y));
			while(!q.isEmpty()) {
				Node n = q.poll();
				if(aquarium[n.x][n.y]>0&&aquarium[n.x][n.y]<size) {
					break;
				}
				for (int i = 0; i < dx.length; i++) {
					int nx = n.x + dx[i];
					int ny = n.y + dy[i];
					if(nx>=N||nx<0||ny>=N||ny<0)continue;
					if(aquarium[n.x][n.y]>size&&aquarium[n.x][n.y]<9) continue;
					q.add(new Node(nx, ny));
				}
			}
		}
		public class Node{
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
		@Override
		public String toString() {
			return "Shark [x=" + x + ", y=" + y + ", size=" + size + "]";
		}
	}
	public static int[][] aquarium;
	public static boolean[][] check;
	public static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		aquarium = new int[N][N];
		check = new boolean[N][N];
		Shark shark = null;
		int fishes = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				aquarium[i][j]=sc.nextInt();
				if(aquarium[i][j]==9) {
					shark = new Shark(i, j, 2);
				}else if(aquarium[i][j]>0) {
					fishes++;
				}
			}
		}
		System.out.println(shark);
		
		
	}
}
