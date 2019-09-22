package line;

import java.util.Scanner;

public class Solution4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result = 0;
		int N = sc.nextInt();
		boolean[] seat = new boolean[N];
		for (int i = 0; i < seat.length; i++) {
			if(sc.nextInt()==1) {
				seat[i]=true;
			}else {
				seat[i]=false;
			}
		}
		for (int i = 0; i < seat.length; i++) {
			int left = 0;
			int right = 0;
			int idx = i;
			int dist = 0;
			if(!seat[i]) {
				if(i>0) {
					while(!seat[idx]) {
						left++;
						idx--;
					}
				}
				idx=i;
				if(i<seat.length-1) {
					while(!seat[idx]) {
						right++;
						idx++;
					}
				}
				dist = (right>left)? left:right;
				if(result<dist)result =dist;
			}
		}
        System.out.println(result);
	}
}
