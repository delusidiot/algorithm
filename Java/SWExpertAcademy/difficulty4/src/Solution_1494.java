

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_1494 {
	public static class Earthworm{
		int x;
		int y;
		public Earthworm(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	public static long minimum = Long.MAX_VALUE;
	public static int[] arr = null;
	public static int[] tr = null;
	public static ArrayList<Earthworm> list = null;
	public static boolean[] check = null;
	public static int N = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			N = sc.nextInt();
			minimum = Long.MAX_VALUE;
			list = new ArrayList<>();
			check = new boolean[N];
			for (int i = 0; i < N; i++) {
				list.add(new Earthworm(sc.nextInt(), sc.nextInt()));
			}
			arr=new int[N];
			tr = new int[N/2];
			for (int i = 0; i < arr.length; i++) {
				arr[i]=i;
			}
			comb(N, N/2);
			System.out.println("#"+testCase+" "+minimum);
		}
	}
	public static void comb(int n, int r) {
		if(r==0) {
			long startX = 0;
			long startY = 0;
			long endX = 0;
			long endY = 0;
			for (int i = 0; i < tr.length; i++) {
				check[tr[i]]=true;
			}
			for (int i = 0; i < N; i++) {
				if(check[i]) {
					startX+=list.get(i).x;
					startY+=list.get(i).y;
				}else {
					endX+=list.get(i).x;
					endY+=list.get(i).y;
				}
			}
			Arrays.fill(check, false);
			startX=startX-endX;
			startY=startY-endY;
			long vector = (startX*startX)+(startY*startY);
			if(minimum>vector)
				minimum=vector;
			return;
		}
		else if(n<r) return;
		else {
			tr[r-1] = arr[n-1];
			comb(n-1,r-1);
			comb(n-1,r);
		}
	}
}
