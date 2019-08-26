import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Solution_1251{
	public static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
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
			boolean[] checked = new boolean[N+1];//시작은
			ArrayList<Node>[] list = new ArrayList[N+1];
			for (int i = 0; i < list.length; i++) {
				list[i] = new ArrayList<>();
			}
			
			// 환경 부담금이 최소.....
			// E 해저터널 건설의 환경 부담 세율 실수 E
			// E * 길이 L 의 제곱의 곱(E*L^2)

			bw.write("#"+testCase+" ");
			bw.flush();
		}
		bw.close();
	}
}
