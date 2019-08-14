import java.util.Arrays;
import java.util.Scanner;

public class Solution_7675_C {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			sc.nextLine();
			String line = sc.nextLine();
			line = line.replace('?', '!');
			line = line.replace('.', '!');
			String[] syntax = line.split("!");
			String[] words = null;
			System.out.print("#"+testCase+" ");
			for (int i = 0; i < syntax.length; i++) {
				int result = 0;
				words=syntax[i].split(" ");
				for (int j = 0; j < words.length; j++) {
					char[] charactor = words[j].toCharArray();
					if(charactor.length==0)continue;
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
				System.out.print(result+" ");
			}
			System.out.println();
			
		}
	}
}
