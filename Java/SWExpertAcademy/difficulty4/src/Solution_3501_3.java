import java.util.ArrayList;
import java.util.Scanner;

public class Solution_3501_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int first = sc.nextInt();
			int second =sc.nextInt();
			ArrayList<Integer> decimalPoint = new ArrayList<>();
			int decimal = 0;
			int sameCount = 0;
			int frontIdx= -1;
			int backIdx=-1;
			boolean check = true;
			if(first%second !=0) {
				int a = first;
				int b = second;
				while(b%2==0) {
					b /=2;
				}
				while(b%5==0) {
					b /=5;
				}
				if(b!=1)check = false;
			}
			for (int i = 0; i < Integer.MAX_VALUE; i++) {
				int count = first/second;
				first=(first%second)*10;
				if(i==0)
					decimal = count;
				else {
					if(frontIdx==-1) {
						for (int p = 0; p < decimalPoint.size(); p++) {
							if(decimalPoint.get(p)==count) {
								frontIdx=p;
								sameCount++;
								break;
							}
						}
						backIdx=frontIdx+1;//다음
					}else {
						if(decimalPoint.get(backIdx)==count) {
							if((decimalPoint.size()-backIdx)==sameCount) {
								break;
							}
							sameCount++;
							backIdx++;

						}else {
							if(decimalPoint.get(frontIdx)==count) {
								frontIdx=0;
								sameCount=1;
							}else {
								frontIdx=-1;
								sameCount=0;
							}
						}
					}
					decimalPoint.add(count);
				}
				if(first==0) break;
			}
			System.out.print("#"+testCase+" "+decimal);
			if(backIdx!=-1) {
				System.out.print(".");
				if(frontIdx==-1) {
					for (int i = 0; i < decimalPoint.size(); i++) {
						System.out.print(decimalPoint.get(i));
					}
				}else {
					for (int i = 0; i < backIdx; i++) {
						if(i==frontIdx)
							System.out.print("(");
						System.out.print(decimalPoint.get(i));
						if(i==(backIdx-1))
							System.out.print(")");
					}
				}
			}
			System.out.println();
		}

	}
}

