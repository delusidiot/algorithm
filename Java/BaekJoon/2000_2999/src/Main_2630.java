import java.util.Scanner;

public class Main_2630 {
	static int[][] paper =null;
	static int white = 0;
	static int blue = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		white = 0;
		blue = 0;
		int N = sc.nextInt();
		paper = new int[N][N];
		for (int i = 0; i < paper.length; i++) {
			for (int j = 0; j < paper.length; j++) {
				paper[i][j]=sc.nextInt();
			}
		}
		cutting(0,N,0,N);
		System.out.println(white);
		System.out.println(blue);
	}
	public static void cutting(int startX, int endX,int startY,int endY) {
		if(confirm(startX, endX, startY, endY)) {
			if(paper[startX][startY]==0)white++;
			else blue++;
		}else {
			cutting(startX, (startX+endX)/2, startY, (startY+endY)/2);
			cutting((startX+endX)/2, endX, startY, (startY+endY)/2);
			cutting((startX+endX)/2, endX, (startY+endY)/2, endY);
			cutting(startX, (startX+endX)/2, (startY+endY)/2, endY);
		}
	}
	public static boolean confirm(int startX, int endX,int startY,int endY) {
		boolean conf = true;
		int base = paper[startX][startY];
		for (int i = startX; i < endX; i++) {
			for (int j = startY; j < endY; j++) {
				if(paper[i][j]!=base) {
					return false;
				}
			}
		}
		return conf;
	}
}
