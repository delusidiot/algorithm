import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution_1263 {
	static BufferedReader br;
	static BufferedWriter bw;
	static int result;
	static int N;
	public static void main(String[] args)throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			result=Integer.MAX_VALUE;
			String[] line = br.readLine().split(" ");
			N=Integer.parseInt(line[0]);
			int[][] graph = new int[N+1][N+1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					graph[i][j]=Integer.parseInt(line[(N*(i-1)+j)]);
				}
			}
			for (int i = 1; i <= N; i++) {
				int dist = dijkstra(i, graph);
				if(result>dist)result=dist;
			}
			
			bw.write("#"+testCase+" "+result+"\n");
			bw.flush();
		}
		br.close();
		bw.close();
	}
	public static int dijkstra(int v, int[][] graph) {//v 
		int[] distance = new int[N+1];
		boolean[] check = new boolean[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[v] = 0;
		check[v] = true;
		
		for (int i = 1; i <= N; i++) {
			if(!check[i] && graph[v][i]!=0) {
				distance[i] = graph[v][i];
			}
		}
		for (int i = 0; i < N; i++) {
			int min = Integer.MAX_VALUE;
			int minIdx=-1;
			for (int j = 1; j <= N; j++) {
				if(!check[j] && distance[j]!=Integer.MAX_VALUE) {
					if(distance[j]<min) {
						min=distance[j];
						minIdx = j;
					}
				}
			}
			if(minIdx<1)continue;
			check[minIdx] = true;
			for(int j=1; j<=N; j++) {
				if(!check[j] && graph[minIdx][j]!=0) {
					if(distance[j]>distance[minIdx]+graph[minIdx][j])
						distance[j]=distance[minIdx]+graph[minIdx][j];
				}
			}
		}
		int dist= 0;
		
		for (int i = 1; i <= N; i++) {
			dist+=distance[i];
			System.out.print(distance[i]+" ");
		}
		System.out.println();
		return dist;
	}
}
