import java.util.Scanner;

public class Solution_1240_C {
	static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int testCase = 1; testCase <= T; testCase++) {
			int height = sc.nextInt();
			int width = sc.nextInt();
			sc.nextLine();
			char[] display = null;
			int count = 0;
			String[] dis = new String[height];
			for (int i = 0; i < height; i++) {
				dis[i] = sc.nextLine();
			}
			cry:while (true){
				String line = dis[count++]; 
				display = line.toCharArray();
				for (int i = 0; i < display.length; i++) {
					if(display[i]=='1')
						break cry;
				}
			}
			char[] cryptograph = new char[56];
			int end = 0;
			for (end = display.length-1; end >= 0; end--) {
				if(display[end] == '1')
					break;
			}
			int start = end-56+1;
			for (int i = 0; i < cryptograph.length; i++) {
				cryptograph[i]=display[start++];
			}
			int[] numbers =	decoder(cryptograph);
			System.out.println("#"+testCase+" "+examine(numbers));
		}
		// 0 : 3211, 1 : 2221, 2 : 2122, 3 : 1411, 4 : 1132,
		// 5 : 1231, 6 : 1114, 7 : 1312, 8 : 1213, 9 : 3112
	}
	//8 개 7code
	public static int[] decoder(char[] cryptograph) {
		int[] numbers = new int[8];
		int[] counter = new int[4];
		int[] decodeNumber = {3211,2221,2122,1411,1132,1231,1114,1312,1213,3112};
		for (int i = 0; i < 8; i++) {
			int count = 1;
			int idx = 0;
			int start = i*7;
			int end = ((i+1)*7)-1;
			for (int j = start; j <= end; j++) {
				if(j+1<=end && cryptograph[j]==cryptograph[j+1])
					count++;
				else {
					counter[idx++]=count;
					count = 1;
				}
			}
			// 0 : 3211, 1 : 2221, 2 : 2122, 3 : 1411, 4 : 1132,
			// 5 : 1231, 6 : 1114, 7 : 1312, 8 : 1213, 9 : 3112
			String number="";
			for (int j = 0; j < counter.length; j++) {
				number+=counter[j];
			}
			for (int j = 0; j < decodeNumber.length; j++) {
				if(decodeNumber[j]==Integer.parseInt(number)) {
					numbers[i]=j;
				}
			}
		}
		return numbers;
	}
	public static int examine(int[] numbers) {
		int odd = 0;
		int even = 0;
		for (int i = 0; i < numbers.length; i++) {
			if(i%2==0) {
				odd+=numbers[i];
			}else {
				even+=numbers[i];
			}
		}
		int result =(odd*3)+even;
		if(result%10 > 0) {
			return 0;
		}result = 0;
		for (int i = 0; i < numbers.length; i++) {
			result += numbers[i]; 
		}
		return result;
	}
}
