package undefind;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1935{
	static BufferedReader br;
	static BufferedWriter bw;
	static int N, M, R, C, L;
	static int[][] hide;
	static int count = 0;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			hide = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < M; j++) {
					hide[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			count = 0;
			boolean[][] check = new boolean[N][M];
			if(hide[R][C]==0) {
				count = 0;
			}else {
				BFS(L, R, C, check);
			}
			bw.write("#"+testCase+" "+count+"\n");
			bw.flush();
		}
		br.close();
		bw.close();
	}
	public static int dx[]= {-1,1,0,0}; //
	public static int dy[]= {0,0,-1,1};
	public static class Position{
		int x;
		int y;
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void BFS(int L,int x,int y,boolean[][] check) {
		Queue<Position> q = new LinkedList<>();
		q.offer(new Position(x, y));
		check[x][y]=true;
		while(!q.isEmpty()) {
			int size = q.size();
			if(L==0) break;
			L--;
			for (int i = 0; i < size; i++) {
				count++;
				Position p = q.poll();
				
				int[] arr = null;
				switch (hide[p.x][p.y]) {
				case 1:// + 0,1,2,3
					arr = new int[]{0,1,2,3};
					for (int j = 0; j < arr.length; j++) {
						Position p2 = innerDFS(L,arr[j], p.x, p.y, check);
						if(p2!=null) {
							q.offer(p2);
							check[p2.x][p2.y]=true;
						}
					}
					break;
				case 2:// | 0,1
					arr = new int[]{0,1};
					for (int j = 0; j < arr.length; j++) {
						Position p2 = innerDFS(L,arr[j], p.x, p.y, check);
						if(p2!=null) {
							q.offer(p2);
							check[p2.x][p2.y]=true;
						}
					}
					break;
				case 3: // - 2,3
					arr = new int[]{2,3};
					for (int j = 0; j < arr.length; j++) {
						Position p2 = innerDFS(L,arr[j], p.x, p.y, check);
						if(p2!=null) {
							q.offer(p2);
							check[p2.x][p2.y]=true;
						}
					}
					break;
				case 4://   0,3
					arr = new int[]{0,3};
					for (int j = 0; j < arr.length; j++) {
						Position p2 = innerDFS(L,arr[j], p.x, p.y, check);
						if(p2!=null) {
							q.offer(p2);
							check[p2.x][p2.y]=true;
						}
					}
					break;
				case 5://  3 1
					arr = new int[]{1,3};
					for (int j = 0; j < arr.length; j++) {
						Position p2 = innerDFS(L,arr[j], p.x, p.y, check);
						if(p2!=null) {
							q.offer(p2);
							check[p2.x][p2.y]=true;
						}
					}
					break;
				case 6:// 2 1
					arr = new int[]{1,2};
					for (int j = 0; j < arr.length; j++) {
						Position p2 = innerDFS(L,arr[j], p.x, p.y, check);
						if(p2!=null) {
							q.offer(p2);
							check[p2.x][p2.y]=true;
						}
					}
					break;
				case 7:// 0 2
					arr = new int[]{0,2};
					for (int j = 0; j < arr.length; j++) {
						Position p2 = innerDFS(L,arr[j], p.x, p.y, check);
						if(p2!=null) {
							q.offer(p2);
							check[p2.x][p2.y]=true;
						}
					}
					break;
				default:
					return;
				}
			}
		}
	}
	public static Position innerDFS(int L,int i, int x, int y,boolean[][] check) {
		int nx = x+dx[i];
		int ny = y+dy[i];
		if(M>ny && 0<=ny && N>nx && 0<=nx &&!check[nx][ny]&&hide[nx][ny]!=0) {
			if(i==0) {
				if(hide[nx][ny]==3||hide[nx][ny]==4||hide[nx][ny]==7) {
					return null;
				}
			}else if(i==1) {
				if(hide[nx][ny]==3||hide[nx][ny]==5||hide[nx][ny]==6) {
					return null;
				}
			}else if(i==2) {
				if(hide[nx][ny]==2||hide[nx][ny]==6||hide[nx][ny]==7) {
					return null;
				}
			}else if(i==3) {
				if(hide[nx][ny]==2||hide[nx][ny]==4||hide[nx][ny]==5) {
					return null;
				}
			}
			return new Position(nx, ny);
		}else {
			return null;
		}
	}
}
