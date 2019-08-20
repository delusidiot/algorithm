import java.util.Scanner;
// String으로 하면 제한시간 초과 발생...
public class Solution_3289 {
	static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int n = sc.nextInt(); // n 이하의 자연수
			int m = sc.nextInt(); //입력으로 주어지는 연산의 개수
			int[] p = new int[n+1];
			makeSet(p);
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < m; i++) {// 입력으로 들어오는 연산 처리
				int key = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				switch (key) {
				case 0:// 합집합
					unionSet(p, a, b);
					break;
				case 1:// 찾기
					a = findSet(p, a);
					b = findSet(p, b);
					if(a==b) {
						result.append("1"); // 값이 같으면
					}else
						result.append("0"); // 값이 다르면
					break;
				default:
					break;
				}
				
			}
			System.out.println("#"+testCase+" "+result.toString());
		}

	}
	public static void makeSet(int[] p) {
		for (int i = 0; i < p.length; i++) {
			p[i]=i;
		}
	}
	public static void unionSet(int[] p,int a, int b) {
		a = findSet(p, a);
		b = findSet(p, b);
		if(a == b) return;
		p[b]=a;
	}
	public static int findSet(int[] p, int set) {
		if(set == p[set]) return set;
		int idx = findSet(p, p[set]);
		p[set]=idx;
		return idx;
	}
}
