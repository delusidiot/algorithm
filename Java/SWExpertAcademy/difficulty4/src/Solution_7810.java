import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_7810 {
	public static BufferedReader br;
	public static BufferedWriter bw;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			int[] numbers = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int max = 0;
			for (int i = 0; i < numbers.length; i++) {
				numbers[i]=Integer.parseInt(st.nextToken());
				max = Math.max(numbers[i], max);
			}
			Arrays.sort(numbers);
			int[] counting = new int[max+1];
			for (int i = 0; i < numbers.length; i++) {
				counting[numbers[i]]++;
			}
			int count =0;
			while(count<max) {
				count+=counting[max];
				max--;
			}
			bw.write("#"+testCase+" "+count+"\n");
			bw.flush();
		}
		bw.close();
	}
}