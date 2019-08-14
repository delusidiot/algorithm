import java.util.Scanner;
public class Solution_1232_Group_2 {
	static Scanner sc;
	static final int T =10;
	class Node{
		char data;
		Node left;
		Node right;
	}
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
			System.out.println("#"+testCase+" "+(int)result);
		}
	}
	static double postOrder(String[] vertex,int start) {
		double result = 0;
		if(vertex[start].split(" ").length<=2) {
			return Double.parseDouble(vertex[start].split(" ")[1]);
		}
		double a =postOrder(vertex, Integer.parseInt(vertex[start].split(" ")[2]));
		double b =postOrder(vertex, Integer.parseInt(vertex[start].split(" ")[3]));
		switch (vertex[start].split(" ")[1]) {// 연산자
		case "-":
			result = a-b;
			break;
		case "+":
			result = a+b;
			break;
		case "*":
			result = a*b;
			break;
		case "/":
			result = a/b;
			break;
		default:
			break;
		}
		return result;
	}
}
