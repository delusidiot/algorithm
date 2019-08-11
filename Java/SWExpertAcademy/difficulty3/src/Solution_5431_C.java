import java.util.Scanner;

public class Solution_5431_C {
	static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int student = sc.nextInt();
			int submit = sc.nextInt();
			int[] students = new int[student+1];
			int[] submission = new int[submit]; 
			for (int i = 0; i < submit; i++) {
				submission[i]= sc.nextInt();
				students[submission[i]] = 1;
			}
			System.out.print("#"+testCase+" ");
			for (int i = 1; i < students.length; i++) {
				if(students[i]==0)
					System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}
