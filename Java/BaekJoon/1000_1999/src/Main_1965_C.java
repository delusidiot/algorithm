import java.util.ArrayList;
import java.util.Scanner;

public class Main_1965_C {
	public static void main(String[] args) {
		//딱 LIS 문제
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		int[] boxSize = new int[n];
		for (int i = 0; i < n; i++) {
			boxSize[i]=sc.nextInt();
		}
		int idx = 0;
		list.add(boxSize[0]);
		for (int i = 1; i < boxSize.length; i++) {
			if(list.get(idx)<boxSize[i]) {
				list.add(boxSize[i]);
				idx++;
			}else {
				//2분 탐색
				int ii = low(list, boxSize[i], idx);
				list.set(ii, boxSize[i]);
			}
			System.out.println(list);
		}
		
		System.out.println(list.size());
	}
	public static int low(ArrayList<Integer> list, int size, int idx) {
		int index = 0;
		while(index < idx) {
			int mid = (index + idx) / 2;
			if(list.get(mid)>= size) {
				idx = mid;
			} else {
				index = mid + 1;
			}
		}
		return idx;
	}
}
