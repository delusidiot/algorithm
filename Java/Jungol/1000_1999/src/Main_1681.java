import java.util.Arrays;
import java.util.Scanner;

public class Main_1681 {
	static int N;
	static int[][]  map;
	static int[][] dp ;
	static final int START = 0;
	static final int INF = 10000000;
	static boolean[] check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		map = new int[N][N];
		dp = new int[N][1 << N];
		int num = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				num = sc.nextInt();
				if(num==0) {
					map[i][j]=INF;
				}else {
					map[i][j]=num;
				}
				if(i==j)
					map[i][j]=0;
				
			}
		}
		for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
		check = new boolean[N];
		check[0]=true;
		min = INF;
		DFS(0, 0);
		System.out.println(min);
//		System.out.println(solve(START,  1<<START));
	}
	static int min;
	
	static int solve(int cur, int B){
		if (dp[cur][B] != -1) return dp[cur][B];
        if (B == (1 << N) - 1) {
            return dp[cur][B] = map[cur][0] != INF ? map[cur][0] : INF;
        }
        dp[cur][B] = INF;
        for (int i = 0; i < N; i++) {
            if (map[cur][i] == INF || (B & (1 << i)) > 0) continue;
            dp[cur][B] = Math.min(dp[cur][B], solve(i, B | (1 << i)) + map[cur][i]);
        }
        return dp[cur][B];
	}
	
	public static void DFS(int pos, int dist) {
		check[pos]= true;
		if(all(check)) {
			if(map[pos][0]==0)
				return;
			dist+=map[pos][0];
			if(dist<min)
				min=dist;
			check[pos]= false;
			return;
		}
		for (int i = 1; i < N; i++) {
			if(check[i])continue;
			if(i==pos)continue;
			if(map[pos][i]==INF)continue;
			DFS(i,dist+map[pos][i]);
		}
		check[pos]= false;
	}
	public static boolean all(boolean[] check) {
		boolean result=true;
		for (int i = 0; i < check.length; i++) {
			if(!check[i])
				return false;
		}
		return result;
	}
}
