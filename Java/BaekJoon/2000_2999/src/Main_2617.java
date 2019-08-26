import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2617 {
	static BufferedReader br;
	static BufferedWriter bw;
	static int result = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] compare = new int[N][2];
		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			compare[i][0]= Integer.parseInt(line[0]);
			compare[i][1]= Integer.parseInt(line[1]);
		}
		for (int i = 0; i < compare.length; i++) {
			System.out.println(Arrays.toString(compare[i]));
		}
		LinkedList<Integer>[] list = new LinkedList[N+1];
		LinkedList<Integer>[] listMin = new LinkedList[N+1];
		for (int i = 0; i < list.length; i++) {
			list[i]= new LinkedList<Integer>();
			listMin[i]= new LinkedList<Integer>();
		}
		for (int i = 0; i < compare.length; i++) {
			list[compare[i][0]].add(compare[i][1]);
			listMin[compare[i][1]].add(compare[i][0]);
		}
		for (int i = 1; i < list.length; i++) {
			System.out.println(i+"list "+list[i]);
			System.out.println(i+"min "+listMin[i]);
		}
		boolean[] checked = null;
		for (int i = 1; i < list.length; i++) {
			int count = 0;
			checked = new boolean[N+1];
			checked = checking(i, list, checked);
			for (int j = 1; j < checked.length; j++) {
				if(checked[i]) {
					count++;
				}
			}
			count--;
			if(count>N/2) {
				result++;
			}
		}
		System.out.println(result);
	}
	public static boolean[] checking(int start, LinkedList<Integer>[] list, boolean[] checked) {
		checked[start] = true;
		Queue<Integer> q = new LinkedList<>();
		Iterator<Integer> it = list[start].iterator();
		while(it.hasNext()) {
			q.offer(it.next());
		}
		System.out.println("q : "+q);
		while(!q.isEmpty()) {
			int idx = q.poll();
			checked[idx]=true;
			it = list[idx].iterator();
			int value  = 0;
			while(it.hasNext()) {
				value =it.next();
				if(!checked[value])
					q.offer(value);
			}
		}
		return checked;
	}
}
