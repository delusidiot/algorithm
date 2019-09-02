import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Solution_8424 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			LinkedList<Integer>[] list = new LinkedList[N+1];
			for (int i = 0; i < list.length; i++) {
				list[i]=new LinkedList<>();
			}
			for (int i = 0; i < N; i++) {
				int first = sc.nextInt();
				int second = sc.nextInt();
				list[first].add(second);
				list[second].add(first);
			}
			int start = 1;
			for (int i = 0; i < list.length; i++) {
				if(list[i].size()==1) start = i;
			}
			Stack<Integer> st = new Stack<>();
			int count = 1;
			while(!st.contains(start)) {
				st.add(start);
				start=list[start].pop();
			}
			while(st.pop()!=start) {
				count++;
			}
			System.out.println("#"+testCase+" "+count);
			boolean[] checked = new boolean[N+1];
			BFS(list, checked);
		}
	}
	public static void BFS(LinkedList<Integer>[] list, boolean[] checked) {//v =1
		Queue<Integer> q = new LinkedList<Integer>();
		int idx = 0;
		
		idx=1;
		q.offer(idx);
		checked[idx]=true;
		while(!q.isEmpty()) {
			int size = q.size();
			idx = q.poll();
			System.out.print(idx+" ");
			Iterator<Integer> it = list[idx].iterator();
			if(q.contains(idx)) System.out.println(idx);
			while (it.hasNext()) {
				int n = it.next();
				
				if(!checked[n]) {
					checked[n]=true;
					q.offer(n);
				}
			}
		}
		
		return;
	}
}
