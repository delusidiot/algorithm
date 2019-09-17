import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution_1263_2 {
	static int[] dist;
	static boolean[] visited =  null;
	static BufferedReader br;
	static BufferedWriter bw;
	static ArrayList<Node>[] list;
	static int result;
	static int N;
	static class Node implements Comparable<Node>{
    	int index;
    	int cost;
		public Node(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}
		public int compareTo(Node o) {
			return cost == o.cost ? index - o.index : cost - o.cost;
		}    	
    }
	public static void main(String[] args)throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			result=Integer.MAX_VALUE;
			String[] line = br.readLine().split(" ");
			N=Integer.parseInt(line[0]);
			list = new ArrayList[N+1];
			dist = new int[N+1];
	        visited = new boolean[N +1];
			for(int i = 0; i <= N; i++) {
				list[i] = new ArrayList<>();
			}
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(Integer.parseInt(line[(N*(i-1)+j)])==1)
						list[i].add(new Node(j, 1));
				}
			}
			for (int i = 1; i <= N; i++) {
				dijkstra(i);
				int r = 0;
				for (int j = 1; j <= N; j++) {
					r+=dist[j];
				}
				if(result>r) result = r;
				Arrays.fill(dist, Integer.MAX_VALUE);
			}
			bw.write("#"+testCase+" "+result+"\n");
			bw.flush();
		}
		br.close();
		bw.close();
	}
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.offer(new Node(start,dist[start]));
		Node node;
		while(!pq.isEmpty()) {
			node = pq.poll();
			int minIndex = node.index;
			visited[minIndex]=true;
			for (int i = 0; i < list[node.index].size(); i++) {
				Node tempNode = list[node.index].get(i);
				if(dist[tempNode.index]>tempNode.cost + dist[minIndex]) {
					dist[tempNode.index] = tempNode.cost + dist[minIndex];
					pq.offer(new Node(tempNode.index, dist[tempNode.index]));
				}
			}
			
		}
		for(int i = 1; i <N+1; i++) {
			if (dist[i]!= Integer.MAX_VALUE) {
                System.out.print(dist[i]+" ");
            } else {
                System.out.println("INF");
            }
		}
		System.out.println();
	}
}
