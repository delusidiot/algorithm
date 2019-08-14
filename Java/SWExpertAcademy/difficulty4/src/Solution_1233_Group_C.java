import java.util.Scanner;

public class Solution_1233_Group_C {
	static Scanner sc;
	static final int T =10;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		for (int testCase = 1; testCase <= T; testCase++) {
			double result = 0;
			int N = sc.nextInt();//정점의 갯수
			sc.nextLine();
			String[] vertex = new String[N+1];
			for (int i = 1; i <= N; i++) {
				vertex[i]= sc.nextLine();
			}
			result = postOrder(vertex, 1);
			if(result<0) {
				System.out.println("#"+testCase+" 0");
			}else {
				System.out.println("#"+testCase+" 1");
			}
			
		}
	}
	static double postOrder(String[] vertex,int start) {
		double result = 0;
		if(vertex[start].split(" ").length<=3) {
			if(vertex[start].split(" ")[1].equals("-")||
			   vertex[start].split(" ")[1].equals("-")||
			   vertex[start].split(" ")[1].equals("-")||
			   vertex[start].split(" ")[1].equals("-")) {
				return -1;
			}
			return 0;
		}
		double a =postOrder(vertex, Integer.parseInt(vertex[start].split(" ")[2]));
		double b =postOrder(vertex, Integer.parseInt(vertex[start].split(" ")[3]));
		result = a+b;
		return result;
	}
}
