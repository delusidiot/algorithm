import java.util.Scanner;

public class Main_9655 {
	public static void main(String[] args) {
		//상근이 차례 2n승 창영 승
		//창영이 차례 2n승 상근 승
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		//첫턴은 상근
		String result = null;
		N=N%2;
		if(N==1) result = "SK";
		else result="CY"; 
		
		System.out.println(result);
	}
}
