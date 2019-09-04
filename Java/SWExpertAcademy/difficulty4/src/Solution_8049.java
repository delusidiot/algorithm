import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_8049 {
	public static BufferedReader br;
	public static BufferedWriter bw;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] detect1="FF~MCM~".toCharArray();//3번째 F 7번째
		char[] detect2="FC~MF".toCharArray();//3번째 C
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			StringBuffer sb = new StringBuffer();
			char[] stringToChar = br.readLine().toCharArray();
			boolean check = false;
			int i = 0;
			int j = 0;
			while(i < stringToChar.length) {
				switch (detect1[j]) {
				case '~':
					if(detect1[j-1]!=stringToChar[i]) {
						j++;
					}else {
						i++;
					}
					break;
				default:
					if(detect1[j]!=stringToChar[i]) {
						j=0;
					}
					j++;
					i++;
					break;
				}
				if(j==detect1.length-1) {
					check= true;
					break;
				}
			}
			if(!check) {
				i = 0;
				j = 0;
				while(i < stringToChar.length) {
					switch (detect1[j]) {
					case '~':
						if(detect1[j-1]!=stringToChar[i]) {
							j++;
						}else {
							i++;
						}
						break;
					default:
						if(detect1[j]!=stringToChar[i]) {
							j=0;
						}
						j++;
						i++;
						break;
					}
					if(j==detect1.length-1) {
						check= true;
						break;
					}
				}
			}
			
			if(check) {
				sb.append("DETECTED!");
			}else {
				sb.append("NOTHING!");
			}
			bw.write("#"+testCase+" "+sb.toString()+"\n");
			bw.flush();
		}
		br.close();
		bw.close();
	}
}
