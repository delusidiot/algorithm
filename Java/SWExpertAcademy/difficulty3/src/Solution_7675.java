import java.util.Arrays;
import java.util.Scanner;

public class Solution_7675 {
	//통역사 문제
	public static void main(String[] args) {
		//.?! 하나 마지막.
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();// 테스트 케이스
		
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt(); //문장의 개수
			sc.nextLine();
			String line = sc.nextLine();
			line.replace("?", ".");
			System.out.println(line);
			line.replace("!", ".");
			System.out.println(line);
			String[] syntax = line.split(".");
			System.out.println(Arrays.toString(syntax));
			String[] words = null;
			System.out.println("#"+testCase+" ");
			for (int i = 0; i < syntax.length; i++) {
				int result = 0;
				words=syntax[i].split(" ");
				for (int j = 0; j < words.length; j++) {
					char[] charactor = words[i].toCharArray();
					if(charactor[0]>='A'&&charactor[0]<='Z') {
						int count = 0;
						for (int k = 1; k < charactor.length; k++) {
							if(charactor[k]>='a'&&charactor[k]<='z') {
								
							}else {
								count++;
							}
						}
						if(count==0) {
							result++;
						}
					}
				}
				System.out.println(result+"");
			}
			System.out.println();
			
		}
		String line = "";
		line.endsWith(".!?");
	}
}
