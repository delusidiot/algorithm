package recursion;

public class Factorial {
	public static void main(String[] args) {
		System.out.println(func(4));
	}
	public static int func(int n) {
		if(n<=1)return 1;
		else {
			return n*func(n-1);
		}
	}
	//해당 Factorial 계산은 쓸모없는 연산이 많이 일어나기 때문에 다른 방법을 사용하는 것이 좋습니다.
}
