import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution_1251{
	public static class IslandNode implements Comparable<IslandNode>{
		int no;
		int x;
		int y;
		int dist;
		public IslandNode(int no, int x, int y, int dist) {
			super();
			this.no = no;
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		@Override
		public int compareTo(IslandNode o) {
			return this.dist > o.dist ? 1 : -1;
		}
	}
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			String[] X = br.readLine().split(" ");
			String[] Y = br.readLine().split(" ");
			//			X.....
			int[] checked = new int[N+1];//시작은
			Arrays.fill(checked, Integer.MAX_VALUE);
			ArrayList<Node>[] list = new ArrayList[N+1];
			for (int i = 0; i < list.length; i++) {
				list[i] = new ArrayList<>();
			}
			for (int i = 0; i < list.length; i++) {
				for (int j = 0; j < list.length; j++) {
					
				}
			}
			int[][] island = new int[N][N];
			for (int i = 0; i < island.length; i++) {
				for (int j = 0; j < island.length; j++) {
					if(i==j) island[i][j]=Integer.MAX_VALUE;
					else {
						island[i][j]=(int) (Math.pow(Double.parseDouble(X[i])-Double.parseDouble(X[j]), 2)
								           +Math.pow(Double.parseDouble(Y[i])-Double.parseDouble(Y[j]), 2));
					}
				}
			}
			for (int i = 0; i < island.length; i++) {
				System.out.println(Arrays.toString(island[i]));
			}
			br.readLine();
			// 환경 부담금이 최소.....
			// E 해저터널 건설의 환경 부담 세율 실수 E
			// E * 길이 L 의 제곱의 곱(E*L^2)

			bw.write("#"+testCase+" "+"\n");
			bw.flush();
		}
		bw.close();
	}
}
