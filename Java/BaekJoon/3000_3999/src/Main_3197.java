import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_3197 {
	static int R;
	static int C;
	static char[][] lake;
	static Scanner sc;
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static ArrayList<Node> swam;
	static LinkedList<Node> melt;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		sc.nextLine();
		lake = new char[R][C];
		swam = new ArrayList<>();
		melt = new LinkedList<>();
		String str = null;
		for (int i = 0; i < R; i++) {
			str = sc.nextLine();
			lake[i]=str.toCharArray();
			for (int j = 0; j < C; j++) {
				if(lake[i][j]=='L') swam.add(new Node(i, j));
			}
		}
		int day = 0;
		out:while(true) {
			boolean[][] visited = new boolean[R][C];
			Queue<Node> q = new LinkedList<>();
			q.add(swam.get(0));
			while(!q.isEmpty()) {
				Node n = q.poll();
				visited[n.x][n.y] = true;
				for (int i = 0; i < 4; i++) {
					int nx = n.x + dx[i];
					int ny = n.y + dy[i];
					if(nx<0||ny<0||nx>=R||ny>=C)continue;
					if(lake[nx][ny]=='X'||visited[nx][ny])continue;
					if(lake[nx][ny]=='L') {
						break out;
					}
					q.add(new Node(nx, ny));
				}
			}
			
			day ++;
			visited = new boolean[R][C];
			for (int i = 0; i <R; i++) {
				for (int j = 0; j < C; j++) {
					if(lake[i][j]!='X') {
						for (int x = 0; x < 4; x++) {
							int ni = i+dx[x];
							int nj = j+dy[x];
							if(ni<0||nj<0||ni>=R||nj>=C)continue;
							if(visited[ni][nj]) continue;
							if(lake[ni][nj]=='X') {
								visited[ni][nj]=true;
								melt.add(new Node(ni, nj));
							}
						}
					}
				}
			}
			while(!melt.isEmpty()) {
				Node n = melt.pop();
				lake[n.x][n.y]='.';
			}
		}
		System.out.println(day);
	}
}
