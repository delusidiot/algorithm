package recursion;

public class ArraySum {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,10};
		System.out.println(sum(0,arr));
	}
	public static int sum(int n, int[] arr) {
		if(n==arr.length) {
			return 0;
		}else {
			return sum(n+1, arr)+arr[n];
		}
	}
}
