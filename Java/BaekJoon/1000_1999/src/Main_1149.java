import java.util.Scanner;

public class Main_1149 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] rgb = new int[N][3];
		for (int i = 0; i < rgb.length; i++) {
			rgb[i][0]=sc.nextInt();//R
			rgb[i][1]=sc.nextInt();//G
			rgb[i][2]=sc.nextInt();//B
		}
		int result = 0;
		int idx = -1;
		for (int i = 0; i < rgb.length; i++) {
			int min = 1001;
			for (int j = 0; j < rgb[i].length; j++) {
				if(idx==j)continue;
				if(min>rgb[i][j]) {
					min=rgb[i][j];
					idx=j;
				}else if(i<rgb.length-1&&min == rgb[i][j]) {
					if(rgb[i+1][j]>rgb[i+1][idx]) {
						min=rgb[i][j];
						idx=j;
					}
				}
			}
			result+=min;
		}
		System.out.println(result);
	}
}
