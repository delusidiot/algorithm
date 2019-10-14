import java.util.Scanner;

public class Main_2579 {
	static int max = 0;
	static int number = 0;
	static int[] stairs = null;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		number = sc.nextInt();
		stairs = new int[number];
		for (int i = stairs.length-1; i >= 0; i--) {
			stairs[i]=sc.nextInt();
		}
		recursion(1,0,0);
		System.out.println(max);
		
	}	
	public static void recursion(int count,int idx,int sum) {
		if(idx>number-1) {
			if(max<sum)
				max=sum;
			return;
		}
		if(count > 1) {
			recursion(1, idx+2, sum+stairs[idx]);
		}else {
			recursion(1, idx+2, sum+stairs[idx]);
			recursion(count+1, idx+1, sum+stairs[idx]);
		}
	}
}
