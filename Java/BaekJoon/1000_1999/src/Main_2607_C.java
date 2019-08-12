import java.util.Scanner;

public class Main_2607_C {
	static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int T = sc.nextInt(); // 단어의 개수
		sc.nextLine();
		// ABCDEFGHIJKLMNOPQRSTUVWXYZ
		int[] firstCount = new int[26];
		int[] compareCount = new int[26];
		char[] first = null;
		char[] compare = null;
		String alpha = sc.nextLine();
		first = alpha.toCharArray();
		for (int i = 0; i < first.length; i++) { //A = 97
			firstCount[(first[i]-'A')]++;
		}
		int count = 0;
		for (int i = 1; i < T; i++) {
			alpha = sc.nextLine();
			compareCount = new int[26];
			compare = alpha.toCharArray();
			for (int j = 0; j < compare.length; j++) {
				compareCount[(compare[j]-'A')]++;
			}
			int same = 0;
			for (int j = 0; j < firstCount.length; j++) {
				if(firstCount[j]>0) {
					if(compareCount[j] == firstCount[j]) {
						same += firstCount[j];
					}else{
						if(compareCount[j]>firstCount[j])
							same += firstCount[j];
						else {
							same += compareCount[j];
						}
						//둘중 작은쪽을 더해야된다.
					}
				}
			}
			if((first.length-1)==compare.length) {//compare갯수와 같아야된다.
				if(same==compare.length)
					count++;
			}else if(first.length==compare.length) {//compare갯수와 같거나 하나 작아야됨
				if(same==compare.length||same==compare.length-1)
					count++;
			}else if((first.length+1)==compare.length) {//first갯수와 같아야됨
				if(same==first.length)
					count++;
			}
		}
		System.out.println(count);
	}
}
