import java.util.Scanner;

public class Main_1717 {
	static int[] p = null;
	static int n = 0;
	static int m = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		p = new int[n+1];
		make();
		for (int i = 0; i < m; i++) {
			int key = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			switch (key) {
			case 0:
				union(x,y);
				break;
			case 1:
				if(find(x)==find(y)) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
				break;
			default:
				break;
			}
		}
	}
	public static void make() {
		for (int i = 0; i < p.length; i++) {
			p[i]=i;
		}
	}
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x==y) {
			return;
		}
		p[y]=find(x);
	}
	public static int find(int x) {
		if(p[x]==x)return x;
		int idx = find(p[x]);
		p[x]=idx;
		return idx;
	}
	
}
