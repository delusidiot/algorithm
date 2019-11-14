import java.util.Scanner;

public class Main_2577 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();//놓인 접시의 수
		int d = sc.nextInt();// 초밥의 가짓수
		int k = sc.nextInt();//연속해서 먹는 접시의 수
		int c = sc.nextInt();//쿠폰 번호
		// 8 30 4 30
		int[] counter = new int[d+1];
		int[] susi = new int[N];
		int count = 0;
		for (int i = 0; i < N; i++) {
			susi[i]=sc.nextInt();
			if(i<k) {
				if(counter[susi[i]]==0) {
					count ++;
				}
				counter[susi[i]]++;
			}
		}
		int max =0;
		if(counter[c]==0) {
			max=count+1;
			count=count+1;
		}
		for (int i = k; i < N+k; i++) {
			counter[susi[i-k]]--;
			if(counter[susi[i-k]]==0) {
				count--;
				if(susi[i-k]==c)count++;
			}
			if(counter[susi[i%N]]==0) {
				count++;
				if(susi[i%N]==c)count--;
			}
			counter[susi[i%N]]++;
			if(count>max) {
				max=count;
			}
		}
		System.out.println(max);
	}
}
