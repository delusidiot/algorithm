import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution_1258_2_C {
	static LinkedList<rc> list = null;
	public static class rc implements Comparable<rc>{
		int r = 0;
		int c = 0;
		public rc(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		public String toString() {
			return r+" "+c;
		}
		@Override
		public int compareTo(rc o) {
			if(this.r*this.c==o.r*o.c) return this.r-o.r;
			return (this.r*this.c)-(o.r*o.c);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			list = new LinkedList<>();
			int n = sc.nextInt();
			int[][] chemicals = new int[n][n];
			for (int i = 0; i < chemicals.length; i++) {
				for (int j = 0; j < chemicals.length; j++) {
					chemicals[i][j] = sc.nextInt();
				}
			}
			
			for (int i = 0; i < chemicals.length; i++) {
				for (int j = 0; j < chemicals.length; j++) {
					if(chemicals[i][j]==0)continue;
					int x = 0;
					int y = 0;
					while (x+i<n&&chemicals[i+x][j]!=0) {
						x++;
					}while(y+j<n&&chemicals[i][j+y]!=0) {
						y++;
					}
					for (int k = i; k < i+x; k++) {
						for (int k2 = j; k2 < j+y; k2++) {
							chemicals[k][k2]=0;
						}
					}
					list.add(new rc(x,y));
				}
			}
			System.out.print("#"+testCase+" "+list.size()+" ");
			Collections.sort(list);
			Iterator<rc> it = list.iterator();
			while(it.hasNext()) {
				System.out.print(it.next()+" ");
			}
			System.out.println();
		}
	}
	public static void dfs(int[][] chemicals, int x, int y) {
		
	}
}
