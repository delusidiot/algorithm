import java.util.Scanner;

public class Main_1932 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] triangle = new int[n+1];
		triangle[0]= sc.nextInt();
		int a = 0;
		int b = 0;
		for (int i = 2; i < n+1; i++) {
			int[] result = new int[n+1];
			for (int j = 0; j < i; j++) {
				if(j==0) {
					a = sc.nextInt();
					result[j]=triangle[j]+a;
				}else if(j==i-1) {
					result[j]=triangle[j-1]+sc.nextInt();
				}else {
					a = sc.nextInt();
					if(triangle[j-1]>triangle[j]) {
						result[j]=triangle[j-1]+a;
					}else {
						result[j]=triangle[j]+a;
					}
				}
			}
			for (int j = 0; j < result.length; j++) {
				triangle[j]=result[j];
			}
		}
		int max = 0;
		for (int i = 0; i < triangle.length; i++) {
			if(max<triangle[i]) {
				max = triangle[i];
			}
		}
		System.out.println(max );

	}
}
