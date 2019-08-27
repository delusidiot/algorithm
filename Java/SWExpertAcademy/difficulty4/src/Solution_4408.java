import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Solution_4408 {
	static int count =0;
	static int N = 0;
	static int allClear = 0;
	public static class Node implements Comparable<Node>{
		int start;
		int end;
		public Node(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Node o) {
			return this.start-o.start;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine().trim()); // 돌아가야할 학생수
			ArrayList<Node> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				String[] line = br.readLine().split(" ");
				int start = (Integer.parseInt(line[0].trim())-1)/2;
				int end = (Integer.parseInt(line[1].trim())-1)/2;
				if(start>end) {
					int temp = start;
					start = end;
					end = temp;
				}
				list.add(new Node(start,end));
			}
			Collections.sort(list);
			count = 0;
			while(list.size()>0) {
				int idx = 0;
				Node n = list.get(idx);
				int end = n.end;
				count++;
				list.remove(idx);
				while(list.size()>0&& list.size()>idx) {
					Node n2 = list.get(idx);
					if(end<n2.start) {
						end =n2.end;
						list.remove(idx);
					}else {
						idx++;
					}
				}
			}
			bw.write("#"+testCase+" "+count+"\n");
			bw.flush();
		}
		br.close();
		bw.close();
	}
}
