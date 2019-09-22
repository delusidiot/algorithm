package naver;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution3 {
	public static void main(String[] args) {
		int[][] test = {{1, 0, 3},{2, 1, 3},{3, 3, 2},{4, 9, 1},{5, 10, 2}};
		int[][] test2 = {{1, 0, 5},{2, 2, 2},{3, 3, 1},{4, 4, 1},{5, 10, 2}};
		System.out.println(Arrays.toString(solution(test2)));
	}
	public static class Doc implements Comparable<Doc>{
		int number;
		int time;
		int page;
		public Doc(int number, int time, int page) {
			super();
			this.number = number;
			this.time = time;
			this.page = page;
		}
		
		@Override
		public String toString() {
			return "Doc [number=" + number + ", time=" + time + ", page=" + page + "]";
		}

		public int compareTo(Doc d) {
			return this.page-d.page;
		}
	}
	public static int[] solution(int[][] data){
		int[] answer = new int[data.length];
		Doc[] docs = new Doc[data.length];
		PriorityQueue<Doc> pq = new PriorityQueue<Doc>();
		for (int i = 0; i < docs.length; i++) {
			docs[i]= new Doc(data[i][0], data[i][1], data[i][2]);
		}
		for (int i = 0; i < docs.length; i++) {
			System.out.println(docs[i]);
			
		}
		int i = 0;
		int timeCounter = 0;
		Doc print = null;
		
		while(i<docs.length) {
			if(print==null) {
				print = docs[i];
				timeCounter+=print.page;
				answer[i]=print.number;
				i++;
			}else {
				for (int j = i; j < docs.length; j++) {
					if(docs[j].time<=timeCounter) {
						pq.offer(docs[j]);
					}
				}
				if(pq.size()==0) {
					print = null;
					continue;
				}
				while(!pq.isEmpty()) {
					print = pq.poll();
					timeCounter+=print.page;
					answer[i]=print.number;
					i++;
				}
			}
		}
		return answer;
	}
}
