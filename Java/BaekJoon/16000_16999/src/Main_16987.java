import java.util.Scanner;

public class Main_16987 {
	public static class Egg{
		int S;//내구성
		int W;//무게
		public Egg(int s, int w) {
			super();
			S = s;
			W = w;
		}
		@Override
		public String toString() {
			return "Egg [S=" + S + ", W=" + W + "]";
		}
	}
	static Egg[] eggs;
	static Scanner sc;
	static int N;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		N = sc.nextInt();
		eggs = new Egg[N];
		for (int i = 0; i < N; i++) {
			eggs[i]= new Egg(sc.nextInt(),sc.nextInt());
		}
		int count = 0;
//		int start = 0;
//		while(start < N-1) {
//			if(eggs[start].S<=0) {
//				start++;
//				continue;
//			}
//			for (int i = 0; i < eggs.length; i++) {
//				if(i==start) continue;
//				if(eggs[start].S<=0) continue;
//				if(eggs[i].S<=0) continue;
//				if(eggs[start].W > eggs[i].S) {
//					eggs[start].S-=eggs[i].W;
//					eggs[i].S-=eggs[start].W;
//				}
//			}
//		}
		for (int i = 0; i < eggs.length; i++) {
			if(eggs[i].S<0)count++;
		}
		for (int i = 0; i < eggs.length; i++) {
			System.out.println(eggs[i]);
		}
		
		System.out.println(count);
	}
	static int max=0;
	public void DFS(int next) {
		if(next == N) {
			int count = 0;
			for (int i = 0; i < eggs.length; i++) {
				if(eggs[i].S<0)count++;
			}
			if(max>count) {
				max=count;
			}
			return;
		}
		for (int i = 0; i < eggs.length; i++) {
			if(i==next)continue;
			
			DFS(next+1);
		}
	}
}
