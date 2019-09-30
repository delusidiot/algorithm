import java.util.Scanner;

public class Main_2247_Jungol {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int endMax = 0;
		boolean[] time = new boolean[150000000];
		for (int i = 0; i < N; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			if(endMax<end)endMax=end;
			for (int j = start; j < end; j++) {
				time[j]=true;
			}
		}
		int max = 0;
		int close = 0;
		int count = 0;
		int i = 1;
		while(i<endMax) {
			count = 0;
			while(time[i]) {
				count++;
				i++;
			}
			if(max<count)max=count;
			count = 0;
			if(i>=endMax) break;
			while(!time[i]) {
				count++;
				i++;
			}
			if(close<count)close=count;
		}
		System.out.println(max+" "+close);
	}
}
