package recursion;

public class Recursion {
	public static void main(String[] args) {
		func(4);
	}
	public static void func(int k) {
		if(k<=0)
			return;
		//base case : 적어도 하나의 recursion에 빠지지 않는 경우가 존재해야 한다.
		else {
			System.out.println("Hello");
			func(k-1);
			//Recursive case : resursion을 반복하다 보면 결국 base case로 수렴 해야 한다.
		}
	}
}
