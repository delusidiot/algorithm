import java.util.Scanner;

public class Solution_3282_1 {
	static int max = 0;
	static int N = 0;
	static int K = 0;
	static int[][] VC = null;
	static boolean[] check = null;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			N = sc.nextInt(); //물건 갯수
			K = sc.nextInt(); //가방 부피
			
			VC = new int[N][2];
			check = new boolean[N];
			for (int i = 0; i < VC.length; i++) {
				VC[i][0]=sc.nextInt();//부피
				VC[i][1]=sc.nextInt();//가치
			}
			max = 0;
			DFS(0,0);
			System.out.println("#"+testCase+" "+max);
		}
	}
	public static void DFS(int value,int capacity) {
		if(capacity>K) {
			return;
		}else if(capacity==K) {
			if(max<value)
				max=value;
			return;
		}
		for (int i = 0; i < VC.length; i++) {
			if(!check[i]) {
				check[i]=true;
				int capacityN = capacity+VC[i][0];
				int valueN = value+VC[i][1];
				DFS(valueN, capacityN);
				check[i]=false;
			}
		}
	}
}
