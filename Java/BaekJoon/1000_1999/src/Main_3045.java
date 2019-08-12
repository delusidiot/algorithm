import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_3045 {
	static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		//A X Y == X노드를 Y의 앞으로 이동       idx-1
		//B X Y == X노드를 Y의 뒤로 이동          idx
		int N = sc.nextInt(); //노드의수
		int M = sc.nextInt(); //연산의 수
		sc.nextLine();
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		for (int i = 0; i < M; i++) {
			String oper = sc.next();
			int moveNode = sc.nextInt();
			int targetNode = sc.nextInt();
			int moveIdx = 0;
			int targetIdx = 0;
			switch (oper) {
			case "A":
				for (int j = 0; j < N; j++) {
					if(moveNode ==list.get(j)) {
						moveIdx = j;
					}
					if(targetNode ==list.get(j)) {
						targetIdx = j;
					}
				}
				if(targetIdx>moveIdx) {
					int move = list.get(moveIdx);
					list.add(targetIdx,move);
					list.remove(moveIdx);
				}else if(targetIdx<moveIdx) {
					int move = list.get(moveIdx);
					list.add(targetIdx,move);
					list.remove(moveIdx+1);
				}
				break;
			case "B":
				for (int j = 0; j < N; j++) {
					if(targetNode ==list.get(j)) {
						targetIdx = j;
					}
					if(moveNode ==list.get(j)) {
						moveIdx = j;
					}
				}
				if(targetIdx>moveIdx) {
					int move = list.get(moveIdx);
					list.add(targetIdx+1,move);
					list.remove(moveIdx);
				}else if(targetIdx<moveIdx) {
					int move = list.get(moveIdx);
					list.add(targetIdx+1,move);
					list.remove(moveIdx+1);
				}
				break;
			default:
				break;
			}
		}
///////////////////////////교체 완료!!
		/////////////// 원래대로 돌아오는 최소 알고리즘...
		reFirst(list);
	}
	static void reFirst(LinkedList<Integer> list) {
		Queue<Character> q = new LinkedList<>();
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		int size = list.size();
		int idx = 0;
		for (int i = 0; i < size-1; i++) {
			idx = i;
			while(list.get(i)!=(i+1)) {//only A
				idx++;
				if(list.get(idx)==(i+1)) {
					q.offer('A');
					q1.offer(i+1);
					q2.offer(list.get(i));
					list.add(i,list.get(idx));
					list.remove(idx+1);
				}
				
			}
		}
		System.out.println(q.size());
		size = q.size();
		while (!q.isEmpty()) {
			System.out.println(q.poll()+" "+q1.poll()+" "+q2.poll());
		}
//		while (!list.isEmpty()) {
//			System.out.print(list.poll()+" ");
//		}
//		System.out.println();
	}
}
