import java.util.Scanner;

public class Solution_3501_2_Answer {
	static int startIdx, x, y, y2, a, b;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			
			x = sc.nextInt();
			y =sc.nextInt();
			int divider = gcd(x,y);
			x/=divider;
			y/=divider;
			System.out.print("#"+testCase+" ");
			if(checkCirc()) {
				System.out.print(x/y);
				x = (x%y)*10;
				if(x != 0)
					System.out.print(".");
		        while(x != 0) {
		        	System.out.print(x/y);
		            x = (x%y)*10;
		        }
		        System.out.println();
			}else {
				int length = getCircularLength(); 
				System.out.print(x/y+".");                // 처음 시작 계산하고 출력
				 
		        for(int i=0; i<startIdx; i++) {    // 순환 시작 위치까지는 그냥 계산해서 출력
		            x = (x % y) * 10;
		            System.out.print(x/y);
		        }
		        
		        System.out.print("(");    // 순환 시작 전에 괄호 넣어줌
		 
		        for(int i=0; i<length; i++) {
		            x = (x % y) * 10;
		            System.out.print(x/y);
		        }
		        System.out.println(")");
			}
		}
	}
	public static int gcd(int a, int b) {
		int c;
		while(b != 0) {
			c = a % b;
			a = b;
			b = c;
		}
		return a;
	}
	public static boolean checkCirc() {
		if(x%y == 0) {
			return true;
		}
		int x2 = x;
		int y3 = y;
		a = 0;
		b = 0;
		while(y3%2 == 0) {
	        y3 /= 2;
	        a++;
	    }
	    while(y3%5 == 0) {
	        y3 /= 5;
	        b++;
	    }
	    y2 = y3;
	 
	    if(y2 == 1)
	        return true;
	    else
	        return false;
	}
	public static int getCircularLength() {
		int n=1;
	    int target = 9;
	 
	    startIdx = a>b ? a : b;    // 순환 시작 위치 계산
	 
	    while((target %= y2) != 0) {
	        n++;
	        target = target*10 + 9;
	    }
	 
	    return n;
	}
}
