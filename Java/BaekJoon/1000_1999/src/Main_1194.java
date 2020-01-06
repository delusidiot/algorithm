import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1194 {
	static int N;
	static int M;
	static char[][] arr;
	static boolean[][][] check;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static class Node {
		int x;
		int y;
		int key;
	
		Node(int x, int y, int key) {
			this.x = x;
			this.y = y;
			this.key = key;
		}
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		Node start = null;
		arr = new char[N][M];
		check = new boolean[N][M][1 << 6];
		String str;
		for (int i = 0; i < N; i++) {
			str = sc.nextLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == '0') {
					start = new Node(i, j, 0);
				}
			}
		}
		System.out.println(BFS(start));
	}

	public static int BFS(Node start) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(start);
		check[q.peek().x][q.peek().y][0] = true;
		int move = 0;
		while (!q.isEmpty()) {
			int qSize = q.size();
			for (int s = 0; s < qSize; s++) {
				Node d = q.poll();
				if (arr[d.x][d.y] == '1') {
					return move;
				}

				for (int i = 0; i < 4; i++) {
					int nx = d.x + dx[i];
					int ny = d.y + dy[i];
					int key = d.key;

					if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
						continue;
					}
					if (arr[nx][ny] == '#') {
						continue;
					}
					if ('a' <= arr[nx][ny] && arr[nx][ny] <= 'f') {
						key |= (1 << arr[nx][ny] - 'a');
					}
					if ('A' <= arr[nx][ny] && arr[nx][ny] <= 'F') {
						if ((key & (1 << (arr[nx][ny] - 'A'))) == 0) {
							continue;
						}
					}
					if (check[nx][ny][key]) {
						continue;
					}
					check[nx][ny][key] = true;
					q.add(new Node(nx, ny, key));
				}
			}
			move++;
		}
		return -1;
	}
}

