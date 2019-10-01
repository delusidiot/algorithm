import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1082_C {
	static int min = 0;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int R = 0;
	static int C = 0;
	static Queue<Node> fire;
	static char[][] map;
	static BufferedReader br;
	static BufferedWriter bw;
	public static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		int Sx = 0;
		int Sy = 0;
		int Dx = 0;
		int Dy = 0;
		fire = new LinkedList();
		for (int i = 0; i < R; i++) {
			map[i]=br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if(map[i][j]=='S') {
					Sx = i;
					Sy = j;
				}
				if(map[i][j]=='D') {
					Dx = i;
					Dy = j;
				}
				if(map[i][j]=='*') {
					fire.add(new Node(i, j));
				}
			}
		}
		BFS(Sx, Sy, Dx, Dy);
		bw.close();
	}
	public static void BFS(int Sx, int Sy, int Dx, int Dy) throws IOException {
		Queue<Node> q = new LinkedList();
		int count = 0;
		boolean goal = false;
		boolean[][] check = new boolean[R][C];
		check[Sx][Sy]=true;
		q.offer(new Node(Sx, Sy));
		int size = 0;
		int fireSize = 0;
		Node n = null;
		while(!q.isEmpty()&&!goal) {
			size = q.size();
			count++;
			fireSize = fire.size();
			for (int j = 0; j < fireSize; j++) {
				n = fire.poll();
				for (int k = 0; k < dx.length; k++) {
					int nx = n.x+dx[k];
					int ny = n.y+dy[k];
					if(nx<R&&nx>=0&&ny<C&&ny>=0) {
						if(map[nx][ny]=='.') {
							fire.add(new Node(nx, ny));
							map[nx][ny]='*';
						}
					}
				}
			}
			for (int i = 0; i < size; i++) {
				n = q.poll();
//				check[n.x][n.y]=true;
				//이동
				for (int j = 0; j < dx.length; j++) {
					int nx = n.x+dx[j];
					int ny = n.y+dy[j];
					if(nx<R&&nx>=0&&ny<C&&ny>=0&&!check[nx][ny]) {
						if(map[nx][ny]=='D') goal= true;
						if(map[nx][ny]=='.') {
							q.offer(new Node(nx, ny));
							check[nx][ny]=true;
						}
					}
				}
			}
		}
		if(!goal) {
			bw.write("KAKTUS\n");
		}else {
			bw.write(count+"\n");
		}
	}
}
