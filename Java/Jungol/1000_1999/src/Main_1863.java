import java.util.Scanner;
public class Main_1863 {
	public static int[] student = null;
	public static Scanner sc = null;
	public static int count = 0;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int n = sc.nextInt(); //학생수
		int m = sc.nextInt(); //조사된 종교 학생 숫자.
		student = new int[n+1];
		for (int i = 1; i <= n; i++) {
			student[i]=i;
		}
		for (int i = 1; i <= m; i++) {
			union(sc.nextInt(), sc.nextInt());
		}
		boolean[] check = new boolean[n+1];
		for (int i = 1; i < n+1; i++) {
			check[find(i)]=true;;
		}
		for (int i = 1; i < n+1; i++) {
			if(check[i])count++;
		}
		System.out.println(count);
	}
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x==y)return;
		student[y]=x;
	}
	public static int find(int x) {
		if(student[x]==x)return x;
		int idx = find(student[x]);
		student[x]=idx;
		return idx; 
	}
}