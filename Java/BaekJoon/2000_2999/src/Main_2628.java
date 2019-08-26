import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main_2628 {
	static Scanner sc;
	public static void main(String[] args) throws NumberFormatException, IOException {
		sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		int number = sc.nextInt();
		int max = 0;
		int countRow = 0;
		int countCol = 0;
		
		int[][] farm = new int[number][2];
		for (int i = 0; i < farm.length; i++) {
			farm[i][0]=sc.nextInt();
			farm[i][1]=sc.nextInt();
			if(farm[i][0]==0)
				countRow++;
			if(farm[i][0]==1)
				countCol++;
		}
		int[] sliceR = new int[countRow];
		int[] sliceC = new int[countCol];
		int idxR = 0;
		int idxC = 0;
		for (int i = 0; i < farm.length; i++) {
			if(farm[i][0]==0) {
				sliceR[idxR]=farm[i][1];
				idxR++;
			}
			if(farm[i][0]==1) {
				sliceC[idxC]=farm[i][1];
				idxC++;
			}
		}
		Arrays.sort(sliceC);
		Arrays.sort(sliceR);
		int x = 0;
		int y = 0;
		int beforeX = 0;
		int beforeY = 0;
		int count = 0;
		for (int i = 0; i <= sliceR.length; i++) {
			beforeX = x;
			if(i!=sliceR.length) {x=sliceR[i];}
			else {x=C;}
			for (int j = 0; j <= sliceC.length; j++) {
				beforeY=y;
				if(j!=sliceC.length) {y=sliceC[j];}
				else {y=R;}
				count = (x-beforeX)*(y-beforeY);
				if(max<count) max=count;
			}
		}
		System.out.println(max);
	}
}
