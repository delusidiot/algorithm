import java.util.Scanner;

public class Main_1219 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		sc.nextLine(); // 행 열 버림
		int paperNumber = sc.nextInt(); // 색종이 장수
		int miss = sc.nextInt();
		
		int[][] missList = new int[1001][2];
		
		int max = 0;
		for(int i = 1; i <= miss; i++) {
			missList[i][0] = sc.nextInt();
			missList[i][1] = sc.nextInt();
			if(max < missList[i][0]) {
				max = missList[i][0];
			}
		}
		divide(miss, 1, missList);
		int r, c;
		while(true) {
			int paperAmount = 0;
			int s = 0;
			for(int i = 1; i<= miss; i++) {
				if(paperAmount > paperNumber) {
					s = 1;
					break;
				}
				c = max;
				r = missList[i][1] + max;
				paperAmount++;
				for(; i <= miss; i++) {
					if(missList[i][0] > c || missList[i][1] > r) {
						i -= 1;
						break;
					}
				}
			}
			if (s == 1)
				max++;
			else {
				System.out.println(max);
				break;
			}
		}
	}
	static void divide(int right, int left , int[][] missList) {
		if(right <= left)
			return;
		int r = right;
		int l = left;
		int m = (r + l) / 2;
		int[] temp = new int[2];
		while(r >= l){
			while(missList[r][1] >= missList[m][1] && r >= m) r--;
			while(missList[l][1] <= missList[m][1] && l <= m) l++;
			if(r > l) {
				temp[0] = missList[r][0];
				temp[1] = missList[r][1];
				missList[r][0] = missList[l][0];
				missList[r][1] = missList[l][1];
				missList[l][0] = temp[0];
				missList[l][1] = temp[1];
			}
			else if(r == l) {
				temp[0] = missList[m][0];
				temp[1] = missList[m][1];
				missList[m][0] = missList[l][0];
				missList[m][1] = missList[l][1];
				missList[l][0] = temp[0];
				missList[l][1] = temp[1];
			}
			else {
				if(m+1 < right) {
					divide(right, m+1, missList);
				}
				if(m-1 < left) {
					divide(m-1, left, missList);
				}
			}
		}
	}
}
