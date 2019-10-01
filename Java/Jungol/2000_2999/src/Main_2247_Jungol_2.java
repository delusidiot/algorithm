import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main_2247_Jungol_2 {
	public static class Node implements Comparable<Node>{
		int start;
		int end;
		public Node(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		public int compareTo(Node o) {
			if(this.start==o.start) return this.end-o.end;
			return this.start-o.start;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Node> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(new Node(sc.nextInt(), sc.nextInt()));
		}
		Collections.sort(list);
		int max = 0;
		int close = 0;
		int start = list.get(0).start;
		int end = list.get(0).end;
		for (int i = 1; i < list.size(); i++) {
			if(list.get(i-1).end+1>=list.get(i).start) {
				if(end<list.get(i).end) {
					end = list.get(i).end;
				}
			}else {
				if(max<end-start) {
					max=end-start;
				}
				if(close<list.get(i).start-list.get(i-1).end) {
					System.out.println(list.get(i).start+" "+list.get(i-1).end);
					close=list.get(i).start-list.get(i-1).end;
				}
			}
		}
		System.out.println(max+" "+close);
	}
}
