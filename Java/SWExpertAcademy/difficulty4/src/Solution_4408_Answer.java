import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
/**
 * 4408. 자기 방으로 돌아가기 D4	175 ms , 코드는 많이 복잡함 
 *	알고리즘 설계기법 : Greedy
 *	BruteForce (완전탐색) : 돌아갈 학생의 동선이 서로 겹치지 않는 그룹을 모두 만들어보는 것은 시간이 많이 걸릴 것이다.
 *	Greedy (탐욕기법) : 이동동선 출발 - 도착 의 두숫자를 작은수 - 큰수 가 될 수 있도록 배치하고
 *				회의실 배정 문제와 유사하게 (정렬기준은 다름)
 *				출발번호를 기준으로 정렬 후, 겹치지 않도록 동선들을 선택(제거함), 몇번만에 제거되는지 체크하면 됨
 */
public class Solution_4408_Answer {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int TC = sc.nextInt(); // T <= 10
    	for (int testCase = 1; testCase <= TC; testCase++) {
    		int N = sc.nextInt(); // 돌아가야할 학생들의 수, N명
    		
    		LinkedList<Move> ll = new LinkedList<Move>(); // 동선을 저장할 객체
    		for (int i = 0; i < N; i++) {
				int a = (sc.nextInt()-1)/2; // 현재 방번호, <= 400
				int b = (sc.nextInt()-1)/2; // 돌아가야 할 방번호, <= 400
				
				// a가 더 클 수도 있고, b가 더 클 수도 있다
				if (a > b) { // a가 더 크면 swap
					int temp = a;
					a = b;
					b = temp;
				}
				
				ll.add(new Move(a, b)); // a <= b
    		}
    		Collections.sort(ll);
    		int cnt = 0;
    		while(ll.size() > 0) {
    			int index = 0;
    			Move m = ll.get(index);
    			int end = m.end;
    			cnt++;
    			ll.remove(index);
    			while(ll.size() > 0 && ll.size() > index) {
    				Move mm = ll.get(index);
    				if (end < mm.start) {
    					end = mm.end;
    					ll.remove(index);
    				} else {
    					index++;
    				}
    			}
    		}
    		
    		System.out.println("#"+testCase+" "+cnt);
		} // end of for testCase
    } // end of main
    public static class Move implements Comparable<Move> {
    	int start;
    	int end;
		public Move(int start, int end) {
			this.start = start;
			this.end = end;
		}
		public int compareTo(Move o) {
			return this.start - o.start;
		}
    }
} // end of class































