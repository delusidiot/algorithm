import java.util.Scanner;

public class Solution_1231_Group_C {
	//중위 순회 inorder LVR
	//완전 이진트리 형식  100개의 노드를 넘어가지 않는다. 노드당 하나의 알파벳만 저장
	static final int T = 10;
	static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		char[] tree = null;
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt(); //각 케이스의 트리가 갖는 정점의 총 수
			sc.nextLine();
			tree = new char[128];
			for (int i = 1; i <= N; i++) {
				String input = sc.nextLine();
				tree[i] = input.split(" ")[1].toCharArray()[0]; //입력 값중 문자만 선택해 넣습니다.
			}
			System.out.print("#"+testCase+" ");
			inorder(tree, 1);
			System.out.println();
		}
	}
	static void inorder(char[] tree,int start) {
		if(tree[start]=='\u0000') {
			return;
		}
		inorder(tree, start*2);
		System.out.print(tree[start]);
		inorder(tree, start*2+1);
	}
}
