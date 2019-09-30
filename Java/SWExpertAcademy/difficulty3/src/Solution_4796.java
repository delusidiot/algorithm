import java.util.ArrayList;
import java.util.Scanner;

public class Solution_4796 {
	static Scanner sc = null;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int[] h = new int[N];
			for (int i = 0; i < h.length; i++) {
				h[i]=sc.nextInt();
			}
			ArrayList<ArrayList<Integer>> list = new ArrayList<>();
			ArrayList<Integer> li = null;
			
			int end = 0;
			int start = 0;
			int listCounter=0;
			while(end<h.length-1) {
				start = end;
				list.add(new ArrayList<>());
				while(end+1<h.length&&h[end]<h[end+1]) {
					end++;
				}
				while(end+1<h.length&&h[end]>h[end+1]) {
					end++;
				}
				for (; start <= end; start++) {
					list.get(listCounter).add(h[start]);
				}
				listCounter++;
			}
			int count = 0;
			for (int i = 0; i < list.size(); i++) {
				int maxIdx = 0;
				int max = 0;
				for (int j = 0; j < list.get(i).size(); j++) {
					if(max<list.get(i).get(j)) {
						max=list.get(i).get(j);
						maxIdx=j;
					}
				}
				if(maxIdx==list.get(i).size()-1||maxIdx==0)continue;// 배열의 가장 끝과 가장 처음이 가장 큰 값이 면 우뚝선 산이 아니다
				count = count + ((maxIdx)*(list.get(i).size()-1-maxIdx));
			}
			System.out.println("#"+testCase+" "+count);
		}
	}
}
