import java.util.Scanner;

public class Main_14889 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] ability = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ability[i][j] = sc.nextInt();
			}
		}
		
		int l = 1<<N;
		System.out.println(l);
		for (int i = 0; i < l/2; i++) {
			for (int j = 0; j < l; j++) {
				if((i &(1<<j))==0){
					
				}
			}
		}
	}
}
