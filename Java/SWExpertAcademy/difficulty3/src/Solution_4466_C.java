import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4466_C {
	static BufferedReader br ;
	static BufferedWriter bw ;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] NK = new int[2];
			int idx = 0;
			while(st.hasMoreTokens()) {
				NK[idx]=Integer.parseInt(st.nextToken());
				idx++;
			}
			st = new StringTokenizer(br.readLine(), " ");
			int[] scores = new int[NK[0]];
			idx = 0;
			while(st.hasMoreTokens()) {
				scores[idx]=Integer.parseInt(st.nextToken());
				idx++;
			}
			int result = 0;
			Arrays.sort(scores);
			for (int i = scores.length-1; i > scores.length-1-NK[1]; i--) {
				result+=scores[i];
			}
			
			System.out.println("#"+testCase+" "+result);
		}
	}
}
