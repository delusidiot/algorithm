import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1462 {
	static Scanner sc;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int count = 0;
	static int max = 0;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		//이동은 상하좌우 이웃한 육지로만 가능. 한칸에 한시간
		// 서로간 최단거리 이동하는데 있어 가장 긴 시간이 걸리는 육지 2곳에
		//같은곳 2번 x 멀리 돌아가기 x
		int row = sc.nextInt();
		int column = sc.nextInt();
		sc.nextLine();
		char[][] map = new char[row][column];
		for (int i = 0; i < row; i++) {
			String line = sc.nextLine();
			map[i]=line.toCharArray();
		}
		boolean[][] checked = new boolean[row][column];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if(map[i][j]=='W') {
					checked[i][j] = true;
				}
			}
		}
		for (int i = 0; i < checked.length; i++) {
			for (int j = 0; j < checked[0].length; j++) {
				if(!checked[i][j]) {
					boolean[][] checkedCopy = new boolean[checked.length][checked[0].length];
					for (int k = 0; k < checkedCopy.length; k++) {
						for (int k2 = 0; k2 < checkedCopy[0].length; k2++) {
							checkedCopy[k][k2]=checked[k][k2];
						}
					}
					BFS(row, column, i, j, checkedCopy);
					if(max<count) {
						max=count;
					}
				}
			}
		}
		System.out.println(count);
	}
	public static void BFS(int row,int col, int i, int j, boolean[][] checked) {
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		qx.offer(i);
		qy.offer(j);
		count=0;
		while(!qx.isEmpty()) {
			int size = qx.size();
			count++;
			for (int l = 0; l < size; l++) {
				int x = qx.poll();
				int y = qy.poll();
				checked[x][y]= true;
				for (int k = 0; k < dx.length; k++) {
					if(x+dx[k]<row&&x+dx[k]>=0&&y+dy[k]<col&&y+dy[k]>=0) {
						if(!checked[x+dx[k]][y+dy[k]]) {
							checked[x+dx[k]][y+dy[k]] = true;
							qx.offer(x+dx[k]);
							qy.offer(y+dy[k]);
						}
					}
				}
			}
		}
	}
}
