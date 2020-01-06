import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
//피아의 아틀리에 ~신비한 대회의 연금술사~
public class Main_15898 {
	static class Pot{
		int[][] effect;
		char[][] element;
		public Pot() {
			super();
			this.effect = new int[5][5];
			this.element = new char[5][5];
		}
		
	}
	static int MAXQUALITY = 0;
	static int[][][] effects;
	static char[][][] elements;
	static int n;
	static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		n = sc.nextInt();//재료의 개수
		effects = new int[n][4][4];//재료의 개수에 해당하는 효능
		elements = new char[n][4][4];//재료의 개수에 해당하는 원소
		sc.nextLine();
		StringTokenizer str = null;
		String token = null;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 4; j++) {
				str = new StringTokenizer(sc.nextLine()," ");
				for (int k = 0; k < 4; k++) {
					token = str.nextToken();
					if(token.charAt(0)=='-') {
						effects[i][j][k] = -(token.charAt(1)-'0');
					}else {
						effects[i][j][k] = token.charAt(0)-'0';
					}
					
				}
			}
			for (int j = 0; j < 4; j++) {
				str = new StringTokenizer(sc.nextLine()," ");
				for (int k = 0; k < 4; k++) {
					elements[i][j][k] = str.nextToken().charAt(0);
				}
			}
			System.out.println(MAXQUALITY);
		}
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					System.out.print(effects[i][j][k]+"/"+elements[i][j][k]+" ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	public static void DFS(int count) {
		if(count == n) {
			
			return;
		}
	}
	public static int quality() {
		int result = 0;
		for (int i = 0; i < effects.length; i++) {
			for (int j = 0; j < effects.length; j++) {
				
			}
		}
		
		return result;
	}
	public static int bombQuality() {
		int R = 0;
		int B = 0;
		int G = 0;
		int Y = 0;
		return (7*R)+(5*B)+(3*G)+(2*Y);
	}
}
