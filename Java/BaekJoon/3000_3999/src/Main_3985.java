import java.util.Scanner;

public class Main_3985 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int N = sc.nextInt();
		int[][] people = new int[N][2];
		for (int i = 0; i < N; i++) {
			people[i][0]=sc.nextInt();
			people[i][1]=sc.nextInt();
		}
		int max=0;
		int max2= 0;
		boolean[] rollCake= new boolean[L+1];
		int happy = 0;
		int unhappy =0;
		for (int i = 0; i < N; i++) {
			int count =0;
			int sub = people[i][1]-people[i][0]+1;
			for (int start = people[i][0]; start <= people[i][1]; start++) {
				if(!rollCake[start]) {
					rollCake[start]=true;
					count++;
				}
			}
			if(max<count) {
				max=count;
				happy=i;
			}
			if(max2<sub) {
				max2=sub;
				unhappy=i;
			}
		}
		System.out.println(unhappy+1);
		System.out.println(happy+1);
		
	}
}
