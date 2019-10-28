package undefind;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution2105 {
	static int[] dx = {1,1,-1,-1,0};
	static int[] dy = {1,-1,-1,1,0};
	static int[][] map;
	static boolean[][] mapCheck; 
	static int max;
	static int startX = 0;
	static int startY = 0;
	static int N = 0;
	static boolean[] check;
	static int CNT = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			N = sc.nextInt();
			max = -1;
			map = new int[N][N];
			mapCheck=new boolean[N][N];
			CNT = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j]=sc.nextInt();
				}
			}
			
			for (int i = 0; i < N; i++) {	
				for (int j = 0; j < N; j++) {
					mapCheck[i][j]=true;
					if(i>=N-2||j==0||j==N-1) continue;
					check = new boolean[101];
					set = new HashSet<>();
					startX = i;
					startY = j;
					set.add(map[startX][startY]);
					check[map[startX][startY]]=true;
					DFS2(0, i+dx[0], j+dy[0], 1, map[startX][startY]);
//					DFS(0,i+dx[0],j+dy[0],2);
				}
			}
			System.out.println("#"+testCase+" "+max);
		}
	}
	static Set<Integer> set;
	public static void DFS(int way, int nextX, int nextY, int count) {
		if(way>3)return;
		if(nextX==startX&& nextY==startY) {
			if(max<count-1) {
				max=count-1;
			}
			return;
		}
		set.add(map[nextX][nextY]);
		if(set.size()!=count) return;
		if(check[map[nextX][nextY]] || mapCheck[nextX][nextY])return;
		
		if(nextX+dx[way]<N&&nextX+dx[way]>=0&&nextY+dy[way]<N&&nextY+dy[way]>=0)
			DFS(way, nextX+dx[way], nextY+dy[way],count+1);
		if(nextX+dx[way+1]<N&&nextX+dx[way+1]>=0&&nextY+dy[way+1]<N&&nextY+dy[way+1]>=0)
			DFS(way+1, nextX+dx[way+1], nextY+dy[way+1],count+1);
		
		set.remove(map[nextX][nextY]);
	}
	
	public static void DFS2(int way, int nextX, int nextY, int count, int result) {
		if(way>3) return;
		if(nextX==startX&& nextY==startY) {
			if(max<count) {
				max=count;
			}
			return;
		}
		if(check[map[nextX][nextY]]||mapCheck[nextX][nextY])return;
		check[map[nextX][nextY]]=true;
		result+=map[nextX][nextY];
		
		if(nextX+dx[way]<N&&nextX+dx[way]>=0&&nextY+dy[way]<N&&nextY+dy[way]>=0)
			DFS2(way, nextX+dx[way], nextY+dy[way],count+1,result);
		if(nextX+dx[way+1]<N&&nextX+dx[way+1]>=0&&nextY+dy[way+1]<N&&nextY+dy[way+1]>=0)
			DFS2(way+1, nextX+dx[way+1], nextY+dy[way+1],count+1,result);
		
		result-=map[nextX][nextY];
		check[map[nextX][nextY]]=false;
	}
}
