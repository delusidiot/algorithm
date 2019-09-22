package line;

import java.util.Scanner;

public class Solution5 {
	static boolean[][] map;
	static int minTime = 0;
	static int get = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		minTime = 0;
		get = 0;
		
		int row = sc.nextInt();
		int col = sc.nextInt();
		map = new boolean[row+1][col+1];
		int conyX = sc.nextInt();
		int conyY = sc.nextInt();
		if(conyX>map.length-1||conyY>map[0].length-1) {
	        System.out.println("fail");
		}else {
			map[conyX][conyY]=true;
			DFS(0,0,0);
	        System.out.println(minTime);
	        System.out.println(get);
		}
	}
	public static void DFS(int x,int y, int count) {
		if(x>map.length-1||y>map[0].length-1) return;
		if(map[x][y]==true) {
			minTime=count;
			get++;
			return;
		}
		DFS(x+1, y,count+1);
		DFS(x, y+1,count+1);
	}
}
