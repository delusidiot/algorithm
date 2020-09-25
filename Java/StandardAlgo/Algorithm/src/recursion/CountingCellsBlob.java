package recursion;
public class CountingCellsBlob {
	static int max = -1;
	static int dx[] = {1,1,1,0,-1,-1,-1,0};
	static int dy[] = {-1,1,0,1,-1,1,0,-1};
	final static int N = 8;
	public static void main(String[] args) {
		int[][] cells = {{0,1,0,1,0,0,0,0},
						{0,0,1,0,0,0,10,0},
						{0,0,0,0,0,0,1,0},
						{0,1,0,1,0,0,0,0},
						{0,1,1,1,0,0,0,0},
						{0,1,0,1,0,1,0,0},
						{0,1,1,1,0,0,1,0},
						{0,1,0,1,0,0,0,1}};
							
	}
	public static void counting(int x, int y, int[][] cells) {
		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx<8 && ny < 8 && nx>=0 && ny>=0 ) {
				
				counting(nx, ny, cells);
			}
		}
	}
}
