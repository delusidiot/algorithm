import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main_3197_3 {
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
	static int[][] melt;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		sc.nextLine();
		lake = new char[R][C];
		melt = new int[R][C];
		swam = new ArrayList<>();
		Queue<Node> q = new LinkedList<>(); 
		String str = null;
		for (int i = 0; i < R; i++) {
			str = sc.nextLine();
			lake[i]=str.toCharArray();
			for (int j = 0; j < C; j++) {
				if(lake[i][j]=='L') swam.add(new Node(i, j));
				for (int k = 0; k < k; k++) {
					int nx = i+dx[k];
					int ny = j+dx[k];
					if(nx<0||ny<0||nx>=R||ny>=C)continue;
					if(lake[nx][ny]=='X') {
						
						lake[nx][ny] = '.';
						melt[nx][ny] = 1;
						q.add(new Node(nx,ny));
					}
				}
			}
		}
		int day = 1;
		while(!q.isEmpty()) {
			Node n = q.poll();
			day++;
			for (int k = 0; k < k; k++) {
				int nx = n.x+dx[k];
				int ny = n.y+dx[k];
				if(nx<0||ny<0||nx>=R||ny>=C)continue;
				if(lake[nx][ny]=='X') {
					lake[nx][ny] = '.';
					melt[nx][ny] = day;
					q.add(new Node(nx,ny));
				}
			}
		}
		System.out.println(day);
	}
}
