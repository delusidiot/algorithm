import java.util.ArrayList;
import java.util.Scanner;

public class Solution_3378 {
	public static String[] master;
	public static String[] beginner;
	public static int p;
	public static int q;
	public static int[] result;
	public static class rcs{
		int r;
		int c;
		int s;
		public rcs(int r, int c, int s) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
		}
		@Override
		public String toString() {
			return "rcs [r=" + r + ", c=" + c + ", s=" + s + "]";
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			p = sc.nextInt();
			q = sc.nextInt();
			sc.nextLine();
			master = new String[p];
			beginner = new String[q];
			for (int i = 0; i < master.length; i++) {
				master[i]=sc.nextLine();
			}
			for (int i = 0; i < beginner.length; i++) {
				beginner[i]=sc.nextLine();
			}
			System.out.println("#"+testCase+" "+hint());
		}
	}
	public static String hint() {
		ArrayList<rcs> possible = new ArrayList<rcs>();
		String result = "";
		for (int r = 1; r <= 20; r++) {
			for (int c = 1; c <= 20; c++) {
				for (int s = 1; s <= 20; s++) {
					if(isAvailable(r,c,s)) {
						possible.add(new rcs(r,c,s));
					}
				}
			}
		}
		result = processIndent(possible);
		return result;
	}
	private static String processIndent(ArrayList<rcs> possible) {
		String result = "";
		int rCount = 0 ,cCount=0, sCount=0;
		int dotNum = 0;
		for (int i = 0; i < beginner.length; i++) {
			dotNum = possible.get(0).r*(rCount)+possible.get(0).c*(cCount)+possible.get(0).s*(sCount);
			boolean flag = true;
			for (int j = 1; j < possible.size(); j++) {
				int dotNum2 = possible.get(j).r*(rCount)+possible.get(j).c*(cCount)+possible.get(j).s*(sCount);
				if(dotNum!=dotNum2) {
					flag = false;
				}
			}
			if(flag)
				result+=dotNum+" ";
			else
				result+="-1 ";
			for (int j = 0; j < beginner[i].length(); j++) {
				char key = beginner[i].charAt(j);
				switch(key) {
				case '(':
					rCount++;
					break;
				case ')':
					rCount--;
					break;
				case '{':
					cCount++;
					break;
				case '}':
					cCount--;
					break;
				case '[':
					sCount++;
					break;
				case ']':
					sCount--;
					break;
				default:
					break;
				}
			}
		}
		return result;
	}

	private static boolean isAvailable(int r, int c, int s) {
		//r('('-')') + c('{'-'}') + s('['-']')
		boolean result = true;
		int rCount = 0 ,cCount=0, sCount=0;
		int dotNum = 0;
		for (int i = 0; i < master.length; i++) {
			int lineDot= 0;
			boolean check = true;
			for (int j = 0; j < master[i].length(); j++) {
				char key = master[i].charAt(j);
				if(i==0&&key!='.')break;
				if(key=='.'&&check)
					lineDot++;
				else {
					check=false;
				}
			}
			for (int j = 0; j < master[i].length(); j++) {
				char key = master[i].charAt(j);
				switch(key) {
				case '(':
					rCount++;
					break;
				case ')':
					rCount--;
					break;
				case '{':
					cCount++;
					break;
				case '}':
					cCount--;
					break;
				case '[':
					sCount++;
					break;
				case ']':
					sCount--;
					break;
				default:
					break;
				}
			}
			if(lineDot!=dotNum) {
				result =false;
				break;
			}
			dotNum = r*(rCount)+c*(cCount)+s*(sCount);
		}
		return result;
	}
}
