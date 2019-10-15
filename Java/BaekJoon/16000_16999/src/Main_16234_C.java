import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_16234_C {
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static int N=0;
	public static int L= 0;
	public static int R= 0;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		int[][] map = new int[N][N];
		boolean[][] check = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		int count = 0;
		while(move(map)) {
			
			ArrayList<ArrayList<Position>> republic = new ArrayList<>();
			for (int i = 0; i < check.length; i++) {
				Arrays.fill(check[i], false);
			}
			int idx = 0;//공화국 인덱스
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!check[i][j]) {
						republic.add(new ArrayList<>());
						Queue<Position> q = new LinkedList<>();
						q.add(new Position(i, j));
						republic.get(idx).add(new Position(i, j));
						check[i][j]=true;
						while(!q.isEmpty()) {
							Position p = q.poll();
							for (int k = 0; k < dx.length; k++) {
								int nx = p.x + dx[k];
								int ny = p.y + dy[k];
								if(nx>=N||nx<0||ny>=N||ny<0||check[nx][ny])continue;
								int people = Math.abs(map[p.x][p.y]-map[nx][ny]);
								if(people<=R&&people>=L) {
									q.add(new Position(nx,ny));
									republic.get(idx).add(new Position(nx, ny));
									check[nx][ny]=true;
								}
							}
						}
						idx++;
					}
				}
			}
			for (ArrayList<Position> list : republic) {
				if(list.size()==0)continue;
				int sum = 0;
				for (Position pos : list) {
					sum+=map[pos.x][pos.y];
				}
				int avg = sum/list.size();
				for (Position pos : list) {
					map[pos.x][pos.y]=avg;
				}
			}
			count++;
		}
		System.out.println(count);
	}
	public static boolean move(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				for (int k = 0; k < dx.length; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					if(nx>=map.length||nx<0||ny>=map.length||ny<0)continue;
					int people = Math.abs(map[i][j]-map[nx][ny]);
					if(people<=R&&people>=L) {
						return true;
					}
				}
			}
		}
		return false;
	}
	public static class Position{
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
	}
}
