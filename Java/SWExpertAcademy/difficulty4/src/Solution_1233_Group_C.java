import java.util.Scanner;
// testCase 가 깔끔하게 안들어 있어서 배열 안됨......
public class Solution_1233_Group_C {
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
			String[] treeInfo = new String[3000];
			for (int i = 1; i <= N; i++) {
				String line = sc.nextLine();
				treeInfo[i] = line.split(" ")[1];
			}
			
			result = postOrder(treeInfo, 1);
			System.out.println("#"+testCase+" "+(int)result);
			
		}
	}
	public static double postOrder(String[] tree, int start) {
		double result = 0;
		if(tree[start*2]==null&&tree[start*2+1]==null) {
			return Double.parseDouble(tree[start]);
		}
		double a = postOrder(tree, start*2);
		double b = postOrder(tree, start*2+1);
		switch (tree[start]) {// 연산자
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
