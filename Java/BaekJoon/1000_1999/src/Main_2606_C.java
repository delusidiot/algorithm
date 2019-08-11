import java.util.Scanner;

//바이러스
public class Main_2606_C {
	static Scanner sc;
	static int count = 0;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int number = sc.nextInt()+1; //컴퓨터의수 100개 이하
		int pair = sc.nextInt(); // 네트워크 상에 연결되어 있는 컴퓨터의 번호 쌍 갯수
		int[][] network = new int[number][number];
		boolean[] checked = new boolean[number];
		for (int i = 0; i < pair; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			network[x][y] = 1;
			network[y][x] = 1;
		}
		dfs(network, 1, checked);
		System.out.println(count);
	}
	static void dfs (int[][] network, int start, boolean[] checked) {
		checked[start] = true;
		for (int i = 1; i < checked.length; i++) {
			if(!checked[i] && network[start][i]==1) {
				dfs(network,i,checked);
				count ++;
			}
		}
	}
}
