import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution_4672 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			char[] characters = br.readLine().toCharArray();
			Arrays.sort(characters);
			ArrayList<String> lines = new ArrayList<String>();
			for (int i = 0; i < characters.length; i++) {
				cutting(characters, i, lines);
			}
			System.out.println(lines);
			int count = 0;
			for (String string : lines) {
				if(palindrome(string)) count++;
			}
			bw.write("#"+testCase+" "+count+"\n");
			bw.flush();
		}
		br.close();
		bw.close();
	}
	public static void cutting(char[] characters, int idx, ArrayList<String> lines) {
		StringBuilder sb = new StringBuilder();
		for(int i = idx; i < characters.length; i++) {
	        sb.append(characters[i]);
	        lines.add(sb.toString());
        }
	}
	public static boolean palindrome(String line) {
		char[] characters = line.toCharArray();
		int start = 0;
		int end = characters.length-1;
		boolean palin = true;
		while(start<end) {
			if(characters[start]==characters[end]) {
				start++;
				end--;
			}else {
				palin = false;
				break;
			}
		}
		return palin;
	}
}
