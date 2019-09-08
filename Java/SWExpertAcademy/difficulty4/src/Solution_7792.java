import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution_7792 {
	static BufferedReader br;
	static BufferedWriter bw;
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			String[] line = new String[N];
			for (int i = 0; i < line.length; i++) {
				line[i] = br.readLine();
			}
			int max = 0;
			String result = "";
			boolean[] count = new boolean[26];
			int first = 0;
			for (int i = 0; i < line.length; i++) {
				Arrays.fill(count, false);
				for (int j = 0; j < line[i].length(); j++) {
					int idx = line[i].charAt(j)-'A';
					if(idx<0||idx>25) continue;
					count[idx]=true;
				}
				first = boolCount(count);
				
				if(max<first) {
					max=first;
					result=line[i];
				}
				else if(max==first) {
					for (int j = 0; j < line[i].length(); j++) {
						if(result.charAt(j)<line[i].charAt(j)) {
							break;
						}else if(result.charAt(j)==line[i].charAt(j)) {
							continue;
						}else {
							result = line[i];
							break;
						}
					}
				}
			}
			bw.write("#"+testCase+" "+result+"\n");
			bw.flush();
		}
		br.close();
		bw.close();
	}
	public static int boolCount(boolean[] count) {
		int result = 0;
		for (int i = 0; i < count.length; i++) {
			if(count[i]) result++;
		}
		return result;
	}
	
}
