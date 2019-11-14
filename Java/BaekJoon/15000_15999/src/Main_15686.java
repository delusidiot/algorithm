import java.util.Arrays;
import java.util.Scanner;

public class Main_15686 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt(); //치킨집 갯수
		int[][] chicken = new int[N+1][N+1];
		
		for (int i = 1; i < chicken.length; i++) {
			for (int j = 1; j < chicken.length; j++) {
				chicken[i][j]=sc.nextInt();
			}
		}
		// 0 빈칸 1 집 2 츽흰 
		for (int i = 0; i < chicken.length; i++) {
			System.out.println(Arrays.toString(chicken[i]));
		}
	}
}
