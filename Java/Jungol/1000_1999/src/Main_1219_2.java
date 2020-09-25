import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Main_1219_2 {
	private static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int havePaper = sc.nextInt();
		int haveHole = sc.nextInt();
		int maxHeight = 0;
		int r, c;
		ArrayList<Integer> cols = new ArrayList<Integer>();
		for(int i = 0; i< haveHole; i++) {
			r = sc.nextInt();
			cols.add(sc.nextInt());
			if(maxHeight < r)
				maxHeight = r;
		}
		Collections.sort(cols);
		int counter = 0;
		while(true) {
			counter = 1;
			Iterator<Integer> it = cols.iterator();
			int num = it.next();
			
			while(it.hasNext()) {
				int n = it.next();
				if(num+maxHeight-1 < n) {
					num = n;
					counter++;
				}	
			}
			if(havePaper<counter)
				maxHeight++;
			else
				break;
		}
		System.out.println(maxHeight);
	}
}
