import java.util.Scanner;

public class Main_16917 {
	public static void main(String[] args) {
		//양 후 반반 /A B C
		
		//양 X 후 Y
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int X = sc.nextInt();
		int Y = sc.nextInt();
		int money = 0;
		if((A+B)<2*C) {
			money += A*X;
			money += B*Y;
		}else {
			if(X>Y) {
				money+=Y*C*2;
				money+=(X-Y)*A;
				if(money>(X*C*2)) {
					money=X*C*2;
				}
			}else {
				money+=X*C*2;
				money+=(Y-X)*B;
				if(money>(Y*C*2)) {
					money=Y*C*2;
				}
			}
		}
		System.out.println(money);
	}
}
