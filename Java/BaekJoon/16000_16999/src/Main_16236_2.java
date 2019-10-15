import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main_16236_2 {
	public static int[] dx = {-1,0,0,1};
	public static int[] dy = {0,-1,1,0};
	public static class Position implements Comparable<Position>{
		int x;
		int y;
		public Position(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Position [x=" + x + ", y=" + y + "]";
		}
		@Override
		public int compareTo(Position o) {
			if(this.x ==o.x) return this.y-o.y;
			return this.x-o.x;
		}
	}
	public static int[][] aquarium;
	public static boolean[][] check;
	public static int N;
	public static int sharkSize = 2;
	public static int sharkEat = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		aquarium = new int[N][N];
		check = new boolean[N][N];
		Position shark = null;
		int[] fishes = new int[7]; 
//		int[][] test = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				aquarium[i][j]=sc.nextInt();
				if(aquarium[i][j]==9) {
					shark = new Position(i, j);
					aquarium[i][j]=0;
				}else if(aquarium[i][j]>0) {
					fishes[aquarium[i][j]]++;
				}
			}
		}
		int result = 0;
		int fish = fishes[1];
//		int count = 0;
		while(fish>0) {
			int dist = 0;
			int targetX=-1;
			int targetY=-1;
			Queue<Position> q = new LinkedList<>();
			q.add(shark);
			for (int i = 0; i < check.length; i++) {
				Arrays.fill(check[i], false);
			}
			check[shark.x][shark.y]=true;
			aa:while(!q.isEmpty()) {
				int size = q.size();
				dist++;
				Collections.sort((List<Position>) q);
				for (int s = 0; s < size; s++) {
					Position p = q.poll();
					
					if(aquarium[p.x][p.y]>0&&aquarium[p.x][p.y]<sharkSize) {
						aquarium[p.x][p.y] = 0;
						sharkEat++;
						if(sharkSize==sharkEat) {
							if(sharkSize<7)
								fish+=fishes[sharkSize];
							sharkSize++;
							sharkEat=0;
						}
						targetX=p.x;
						targetY=p.y;
						break aa;
					}
					for (int i = 0; i < dx.length; i++) {
						int x = p.x+dx[i];
						int y = p.y+dy[i];
						if(x>=N||x<0||y>=N||y<0)continue;
						if(aquarium[x][y]>sharkSize)continue;
						if(check[x][y])continue;
						q.add(new Position(x, y));
						check[x][y]=true;
					}
				}
			}
			if((shark.x==targetX&&shark.y==targetY)||targetX<0) {
				fish--;
				continue;
			}
			shark.x=targetX;
			shark.y=targetY;
			result +=(dist-1);
			fish--;
//			count++;
//			test[shark.x][shark.y]=count;
//			System.out.println(count + ":"+shark+" 거리 : "+(dist-1));
		}
//		for (int i = 0; i < test.length; i++) {
//			System.out.println(Arrays.toString(test[i]));
//		}
		System.out.println(result);
	}
}
