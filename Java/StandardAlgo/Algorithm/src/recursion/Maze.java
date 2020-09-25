package recursion;

public class Maze {
	final static int PATH_WAY = 0;
	final static int WALL = 1;
	final static int BLOCKED_COLOUR = 2;
	final static int PATH_COLOUR = 3;
	static int[] dx =  {1,-1,0,0};
	static int[] dy =  {0,0,1,-1};
	static int N = 6;
	static int max = -1;
	public static void main(String[] args) {
		int[][] maze = {{0,1,1,0,1,1},
						{0,1,1,0,0,0},
						{0,0,0,0,1,1},
						{0,1,1,0,1,1},
						{0,1,1,0,1,1},
						{0,1,1,0,0,0}};
		int[][] nonmaze = {{0,1,1,0,1,1},
							{0,1,1,0,0,0},
							{0,0,0,0,1,1},
							{0,1,1,0,1,1},
							{0,1,1,1,1,1},
							{0,1,1,1,0,0}};
		find(0,0,0,nonmaze);
		System.out.println(max);
		System.out.println(findPath(0, 0, nonmaze));
		
	}
	public static void find(int x, int y, int count,int[][] maze) {
		if(x==N-1&&y==N-1) {
			if(count>max) max=count;
		}
		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0&&ny>=0&&nx<N&&ny<N) {
				if(maze[nx][ny]==0) {
					maze[nx][ny]=BLOCKED_COLOUR;
					find(nx,ny,count+1,maze);
					maze[nx][ny]=PATH_WAY;
				}
			}
		}
	}
	public static boolean findPath(int x, int y,int[][] maze) {
		if(x<0||y<0||x>=N||y>=N||maze[x][y]==1) {
			return false;
		}
		else if(x==N-1&&y==N-1) {
			return true;
		}
		else {
			maze[x][y] = 1;
			for(int i = 0; i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(findPath(nx, ny, maze)) {
					return true;
				}
			}
			maze[x][y] = 0;
		}
		return false;
	}
}
