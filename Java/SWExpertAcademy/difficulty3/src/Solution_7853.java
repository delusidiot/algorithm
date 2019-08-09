import java.util.Scanner;

public class Solution_7853 {
	static boolean[] checked = null;
	static int count = 0 ;
	static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		
		for (int testCase = 1; testCase <= T; testCase++) {
			String string = sc.nextLine();
			char[] ch = string.toCharArray();
			checked = new boolean[ch.length];
			count = 0;
			typingError(ch, 0);
			System.out.println("#"+testCase+" "+count);
		}
	}
	public static void typingError(char[] ch, int start) {
		if(start == ch.length) {
			count ++;
			System.out.print(count+" : ");
			for (int i = 0; i < ch.length; i++) {
				System.out.print(ch[i]);
			}
			System.out.println();
			return;
		}
		char temp;
		

		if(start!=0) {				//i-1
			if(ch[start]==ch[start-1]) {
			}
			else {
				temp = ch[start-1];
				ch[start-1]=ch[start];
				typingError(ch, start+1);
				ch[start-1]=temp;
			}
		}
		
		typingError(ch, start+1);	//i
		
		if(start!=ch.length-1) {		//i+1
			if(ch[start]==ch[start+1]) {
			}
			else {
//				temp = ch[start+1];
				ch[start+1]=ch[start];
				typingError(ch, start+1);
//				ch[start+1] = temp;
			}
		}
	}
}
