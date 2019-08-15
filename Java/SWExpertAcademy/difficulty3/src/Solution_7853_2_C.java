import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Solution_7853_2_C {
	static BufferedReader br;
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			String string = br.readLine();
			long result = comparison(string);
			System.out.println("#"+testCase+" "+result);
		}
	}
//	public static long comparison(String string) {
//		long result = 1;
//		if(string.length()==1)
//			return result;
//		else if(string.charAt(0)!=string.charAt(1))
//			result *=2;
//		
//		for(int i = 1; i<string.length()-1; i++) {
//			boolean task1 = string.charAt(i-1) != string.charAt(i);
//			boolean task2 = string.charAt(i) != string.charAt(i+1);
//			boolean task3 = string.charAt(i-1) != string.charAt(i+1);
//			if(task1&&task2&&task3)
//				result*=3;
//			else if(!task1&&!task2&&!task3)
//				result*=1;
//			else
//				result*=2;
//			result%=1000000007;
//		}
//		if(string.charAt(string.length()-2)!=string.charAt(string.length()-1))
//			result*=2;
//		return result%1000000007;
//	}
	public static long comparison(String string) {
		int[] counter = new int[string.length()];
		long result = 1;
		for (int i = 0; i < string.length(); i++) {
			int count = 1;
			if(i!=0 && string.charAt(i-1)!=string.charAt(i)) {
				count++;
			}
			if(i!=string.length()-1 && string.charAt(i)!=string.charAt(i+1)) {
				count++;
			}
			if(i!=0 &&i!=string.length()-1&& string.charAt(i-1)==string.charAt(i+1)) {
				if(string.charAt(i-1)!=string.charAt(i)) {
					count--;
				}
			}
			counter[i] = count;
		}
		for (int i = 0; i < string.length(); i++) {
			result = result * counter[i];
			result %= 1000000007;
		}
		return result % 1000000007;
	}
}
