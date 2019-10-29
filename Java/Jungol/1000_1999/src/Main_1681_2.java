import java.util.Arrays;
import java.util.Scanner;
 
public class Main_1681_2{
    static int N;
    static int[][] W;
 
    static final int INF = 10000000;
    static final int START = 0;
    static int[][] dp ;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        W = new int[N][N];
        dp = new int[N][1 << N];//방문체크를 비트마스크로
        for(int[] a : W) {
            Arrays.fill(a, INF);
        }
        for (int i = 0; i < W.length; i++) {
            for (int j = 0; j < W.length; j++) {
                int num = sc.nextInt();
                if(num==0) {
                    W[i][j] = INF;
                }else {
                    W[i][j] = num;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            W[i][i]=0;
            Arrays.fill(dp[i], -1);
        }
         
        System.out.println(solve(START,  1<<START));
    }
    static int solve(int cur, int B) {
        // memoization
        if (dp[cur][B] != -1) return dp[cur][B];
 
        // 기저 조건, 모든 마을을 방문하고 시작점(0)으로 되돌아가야 하는 경우
        if (B == (1 << N) - 1) {
            return dp[cur][B] = W[cur][START] != INF ? W[cur][START] : INF;
        }
 
        // 하위 문제
        dp[cur][B] = INF;
        for (int i = 0; i < N; i++) {
            // 갈 수 없거나, 방문했던 마을이라면
            if (W[cur][i] == INF || (B & (1 << i)) > 0) continue;
            dp[cur][B] = Math.min(dp[cur][B], solve(i, B | (1 << i)) + W[cur][i]);
        }
 
        return dp[cur][B];
    }
}