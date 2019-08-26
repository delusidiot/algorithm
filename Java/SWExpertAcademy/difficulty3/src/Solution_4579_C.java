import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_4579_C {
	static BufferedReader br ;
	static BufferedWriter bw ;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			String line = br.readLine();
			System.out.println("#"+testCase+" "+(palindrome(line)?"Exist":"Not exist"));
			
		}
	}
	public static boolean palindrome(String line){
		char[] characters = line.toCharArray();
		int start = 0;
		int end = characters.length-1;
		boolean palin = true;
		while(start<end) {
			if(characters[start]==characters[end]) {
				start++;
				end--;
			}else if(characters[start]=='*'||characters[end]=='*'){
				break;
			}else {
				palin = false;
				break;
			}
		}
		return palin;
	}
}
