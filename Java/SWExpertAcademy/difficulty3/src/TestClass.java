import java.util.Arrays;
import java.util.Scanner;

public class TestClass {
	static Scanner sc;
	public static void main(String[] args) {
		int[] test = {5,3,1,2,4};
		int key;
		for (int i = 1; i < test.length; i++) {
			key = test[i];
			int j=i-1;
			while(j>=0&&test[j]>key) {
				test[j+1]=test[j];
				j--;
			}
			test[j+1]=key;
		}
		System.out.println(Arrays.toString(test));
	}
	private static int doPow2(int base, int exp) {
		int newBase = 0;
		if (exp == 1)
			return base;
		else if (exp == 0)
			return 1;
		newBase = doPow2(base, exp/2);
		if(exp %2 == 1) {
			return newBase*newBase*base;
		}
		return newBase*newBase;
	}
}
