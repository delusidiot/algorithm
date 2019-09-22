import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Solution_1257 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			int K = Integer.parseInt(br.readLine());
			char[] charactors = br.readLine().toCharArray();
			Set<String> set = new HashSet<String>();
			for (int i = 0; i < charactors.length; i++) {
				cutting(charactors, i, set);
			}
			LinkedList<String> subStrings = new LinkedList<String>(set);
			Collections.sort(subStrings);
			bw.write("#"+testCase+" "+subStrings.get(K-1)+"\n");
			bw.flush();
		}
		br.close();
		bw.close();
	}
	private static void cutting(char[] charactors, int idx, Set<String> set) {
		StringBuilder sb = new StringBuilder();
		for(int i = idx; i < charactors.length; i++) {
	        sb.append(charactors[i]);
	        set.add(sb.toString());
        }
	}
}
