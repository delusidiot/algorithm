import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
//실행시간 줄이기
public class Solution_7853_F {
	static BufferedReader br;
	static Set<String> typingErrors = null;
	static char[] ch2 = null;
	static long count = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			String string = br.readLine();
			char[] ch = string.toCharArray();
			ch2 = string.toCharArray();
			count = 0;
			typingErrors = new HashSet<>();
			typingError(ch, 0);
			Iterator<String> it = typingErrors.iterator();
			while(it.hasNext()) {
				it.next();
				count ++;
			}
			System.out.println("#"+testCase+" "+count);
		}
	}
	public static void typingError(char[] ch, int start) {
		if(start == ch.length) {
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < ch.length; i++) {
				result.append(ch[i]);
			}
			
			typingErrors.add(result.toString());
			return;
		}
		char temp = '\u0000';
		if(start>0) {
			if(ch[start]==ch2[start-1]) {
			}else {
				temp = ch[start];
				ch[start]=ch2[start-1];
				typingError(ch, start+1);
				ch[start]=temp;
			}
		}
		typingError(ch, start+1);
		if(start<ch.length-1){
			if(ch[start]==ch2[start+1]) {
			}else {
				temp = ch[start];
				ch[start] = ch2[start+1];
				typingError(ch, start+1);
				ch[start] = temp;
			}
		}
	}
}
