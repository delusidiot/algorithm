package line;

import java.util.Scanner;

public class Solution6 {
	static int[] size;
	static char[][] numbers;
	static int N;
	static int maxSize;
	static int col = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		String range = sc.nextLine().trim();
		size = new int[N];
		numbers = new char[N][];
		maxSize = 0;
		String[] line=null;
		for (int i = 0; i < numbers.length; i++) {
			line=sc.nextLine().split(" ");
			size[i]=Integer.parseInt(line[0]);
			numbers[i] = line[1].toCharArray();
			if(maxSize<size[i])maxSize=size[i];
		}
		col=2*maxSize-1;
		switch(range) {
		case "TOP":
			TOP();
			break;
		case "MIDDLE":
			MIDDLE();
			break;
		case "BOTTOM":
			BOTTOM();
			break;
		}
	}
	public static void TOP() {
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0;  k< numbers[j].length; k++) {
					if(size[j]*2-1>i) {
						print(numbers[j][k],size[j],i);
					}else {
						print(' ',size[j],i);
					}
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	public static void MIDDLE() {
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < N; j++) {
				int blank = maxSize-size[j];
				for (int k = 0;  k< numbers[j].length; k++) {
					if(i>=blank&&i<col-blank) {
						print(numbers[j][k],size[j],i-blank);
					}else {
						print(' ',size[j],i);
					}
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	public static void BOTTOM() {
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < N; j++) {
				int blank = col-(2*size[j]-1);
				for (int k = 0;  k< numbers[j].length; k++) {
					if(blank<=i) {
						print(numbers[j][k],size[j],i-blank);
					}else {
						print(' ',size[j],i);
					}
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	public static void print(char number,int size, int line) {
		int c = 2*size-1;
		switch (number) {
		case '0':
			if(line == 0|| line == c-1) {
				for (int i = 0; i < size; i++) {
					System.out.print("#");
				}
			}else {
				for (int i = 0; i < size; i++) {
					if(i==0||i==(size-1)) {
						System.out.print("#");
					}else {
						System.out.print(".");
					}
				}
			}
			break;
		case '1':
			for (int i = 0; i < size; i++) {
				if(i==(size-1)) {
					System.out.print("#");
				}else {
					System.out.print(".");
				}
			}
			break;
		case '2':
			if(line == 0|| line == c-1 ||line==size-1) {
				for (int i = 0; i < size; i++) {
					System.out.print("#");
				}
			}else if(line<c/2+1) {
				for (int i = 0; i < size; i++) {
					if(i==(size-1)) {
						System.out.print("#");
					}else {
						System.out.print(".");
					}
				}
			}else {
				for (int i = 0; i < size; i++) {
					if(i==0) {
						System.out.print("#");
					}else {
						System.out.print(".");
					}
				}
			}
			break;
		case '3':
			if(line == 0|| line == c-1 ||line==size-1) {
				for (int i = 0; i < size; i++) {
					System.out.print("#");
				}
			}else {
				for (int i = 0; i < size; i++) {
					if(i==(size-1)) {
						System.out.print("#");
					}else {
						System.out.print(".");
					}
				}
			}
			break;
		case '4':
			if(line==size-1) {
				for (int i = 0; i < size; i++) {
					System.out.print("#");
				}
			}else if(line<c/2+1) {
				for (int i = 0; i < size; i++) {
					if(i==0||i==(size-1)) {
						System.out.print("#");
					}else {
						System.out.print(".");
					}
				}
			}else {
				for (int i = 0; i < size; i++) {
					if(i==(size-1)) {
						System.out.print("#");
					}else {
						System.out.print(".");
					}
				}
			}
			break;
		case '5':
			if(line == 0|| line == c-1 ||line==size-1) {
				for (int i = 0; i < size; i++) {
					System.out.print("#");
				}
			}else if(line<c/2+1) {
				for (int i = 0; i < size; i++) {
					if(i==0) {
						System.out.print("#");
					}else {
						System.out.print(".");
					}
				}
			}else {
				for (int i = 0; i < size; i++) {
					if(i==(size-1)) {
						System.out.print("#");
					}else {
						System.out.print(".");
					}
				}
			}
			break;
		case '6':
			if(line == c-1 ||line==size-1) {
				for (int i = 0; i < size; i++) {
					System.out.print("#");
				}
			}else if(line<c/2+1) {
				for (int i = 0; i < size; i++) {
					if(i==0) {
						System.out.print("#");
					}else {
						System.out.print(".");
					}
				}
			}else {
				for (int i = 0; i < size; i++) {
					if(i==0||i==(size-1)) {
						System.out.print("#");
					}else {
						System.out.print(".");
					}
				}
			}
			break;
		case '7':
			if(line == 0) {
				for (int i = 0; i < size; i++) {
					System.out.print("#");
				}
			}else {
				for (int i = 0; i < size; i++) {
					if(i==(size-1)) {
						System.out.print("#");
					}else {
						System.out.print(".");
					}
				}
			}
			break;
		case '8':
			if(line == 0|| line == c-1 ||line==size-1) {
				for (int i = 0; i < size; i++) {
					System.out.print("#");
				}
			}else {
				for (int i = 0; i < size; i++) {
					if(i==0||i==(size-1)) {
						System.out.print("#");
					}else {
						System.out.print(".");
					}
				}
			}
			break;
		case '9':
			if(line == 0 ||line==size-1) {
				for (int i = 0; i < size; i++) {
					System.out.print("#");
				}
			}else if(line<c/2+1) {
				for (int i = 0; i < size; i++) {
					if(i==0||i==(size-1)) {
						System.out.print("#");
					}else {
						System.out.print(".");
					}
				}
			}else {
				for (int i = 0; i < size; i++) {
					if(i==(size-1)) {
						System.out.print("#");
					}else {
						System.out.print(".");
					}
				}
			}
			break;
		default:
			for (int i = 0; i < size; i++) {
				System.out.print(".");
			}
			break;
		}
	}
}
