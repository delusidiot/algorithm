package line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution3 {
	public static class Node implements Comparable<Node>{
		int start = 0;
		int end = 0;
		public Node(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Node o) {
			if(this.start==o.start)return this.end-o.end;
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
		int count = 1;
		int end = 0;
		int countSame=0;
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).start>=end) {
				end = list.get(i).end;
				if(countSame>0) {
					count-=countSame;
					countSame=0;
				}
			}else {
				if(list.get(i).end==end) countSame++;
				if(end>list.get(i).end) end=list.get(i).end;
				count++;
			}
			if(max<count) {
				max=count;
			}
		}
        System.out.println(max);
	}
}
