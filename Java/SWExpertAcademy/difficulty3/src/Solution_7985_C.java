import java.util.Scanner;
public class Solution_7985_C {
	private static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int depth;
		for (int i = 1; i <= testCase; i++) {
			depth = sc.nextInt();
			System.out.print("#"+i+" ");
			binary(depth);
		}
	}
	public static void binary(int depth) {
		int treeNumber = (1<<(depth))-1;
		int next = 0;
		int[] binaryTree = new int[treeNumber];
		for (int i = 0; i < binaryTree.length; i++) {
			binaryTree[i] = sc.nextInt();
			
		}
		for (int i = 0; i < depth; i++) {
			next=(1<<depth-i-1)-1;
			while(next<binaryTree.length) {
				System.out.print(binaryTree[next]+" ");
				next+=(1<<(depth-i));
			}
			System.out.println();
		}
	}
}
