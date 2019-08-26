import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution_3124{
	static BufferedReader br;
	static BufferedWriter bw;
	static Scanner sc;
	static int[] p;
	static long result =0;
	public static void main(String[] args) throws Exception {
		sc = new Scanner(System.in);
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int vertax = 0;
		int edge = 0;
		TreeSet<TreeNode> ts;
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			vertax = Integer.parseInt(st.nextToken());
			edge = Integer.parseInt(st.nextToken());
			p = new int[vertax+1];
			ts = new TreeSet<>();
			makeSet();
			for (int i = 0; i < edge; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int dist = Integer.parseInt(st.nextToken());
				ts.add(new TreeNode(start, end, dist));
			}
			result = 0;
			for (TreeNode node : ts) { // 간선
				unionSet(node);
			}
			System.out.println("#"+testCase+" "+result);
		}
	}
	static int findSet(int x) {
		if(x == p[x]) {
			return x;
		}
		int idx=findSet(p[x]);
		p[x]=idx;
		return idx;
	}
	static void makeSet() {
		for (int i = 0; i < p.length; i++) {
			p[i] = i;
		}
	}
	static void unionSet(TreeNode node) {
		int x = findSet(node.start);
		int y = findSet(node.end);
		if(x != y) {
			p[y]=x;
			result = result + node.dist;
		}
	}
	public static class TreeNode implements Comparable<TreeNode>{
		int start;
		int end;
		int dist;
		public TreeNode(int start, int end, int dist) {
			super();
			this.start = start;
			this.end = end;
			this.dist = dist;
		}
		public String toString() {
			return start+" "+dist+" ";
		}
		@Override
		public int compareTo(TreeNode o) {
			return this.dist -o.dist > 0 ? 1: -1;
		}
		
	}
}
 