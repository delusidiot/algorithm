import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Solution_1251{
	public static class IslandNode implements Comparable<IslandNode>{
		int no;
		int x;
		int y;
		double dist;
		public IslandNode(int no, int x, int y, double dist) {
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
	static PriorityQueue<IslandNode> pq = new PriorityQueue<>();
	static ArrayList<IslandNode> list = new ArrayList<>();
	static int N;
	static double Answer;
	static double environment;
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());
			String[] X = br.readLine().split(" ");
			String[] Y = br.readLine().split(" ");
			//			X.....
			int[] checked = new int[N+1];//시작은
			Arrays.fill(checked, Integer.MAX_VALUE);
			
			for (int i = 0; i < N; i++) {
				list.add(new IslandNode(i, Integer.parseInt(X[i]), Integer.parseInt(Y[i]), 0));
			}
			environment = Double.parseDouble(br.readLine());//환경 부담금
			for (int i = 1; i < N; i++) {
				double result = Math.pow(list.get(0).x - list.get(i).x, 2) + Math.pow(list.get(0).y - list.get(i).y, 2);
				pq.offer(new IslandNode(i, -1, -1, result * environment));
			}
//			Iterator<IslandNode> it = pq.iterator();
//			while(it.hasNext()) {
//				System.out.println(it.next());
//			}
			
			// 환경 부담금이 최소.....
			// E 해저터널 건설의 환경 부담 세율 실수 E
			// E * 길이 L 의 제곱의 곱(E*L^2)
			hanaro();
			bw.write("#"+testCase+" "+Answer+"\n");
			bw.flush();
		}
		bw.close();
	}
	static void hanaro() {

		boolean[] visited = new boolean[N];
		
		IslandNode island;
		int number;
		double weight;
		int count = 0;
		
		visited[0] = true;

		while (!pq.isEmpty()) {

			island = pq.poll();
			number = island.no;
			weight = island.dist;
			
			if(count == N - 1)
				break;
			if(visited[number])
				continue;
			visited[number] = true;
			Answer += weight;
			count++;
			
			for(int i = 1; i < N; i++) {
				
				if(!visited[i])
					pq.offer(new IslandNode(i, -1, -1,
							(Math.pow(list.get(number).x - list.get(i).x, 2) + Math.pow(list.get(number).y - list.get(i).y, 2)) * environment));
			}
		}
	}
}
