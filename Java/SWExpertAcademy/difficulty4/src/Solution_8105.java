import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_8105 {
	static BufferedReader br;
	static BufferedWriter bw;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			int[] stone = new int[2];//1~1000
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < stone.length; i++) {
				stone[i]=Integer.parseInt(st.nextToken());
			}
			int max = 8;
			int result = 0;
			for (int i = 0; i < max; i++) {
				for (int j = 0; j < stone.length; j++) {
					if(stone[j]==0) continue;
					if(stone[j]%2==1) result++;
					stone[j]/=2;
				}
				if(result%2==1) {
					break;
				}
			}
			bw.write("#"+testCase+" "+(result%2)+"\n");
			bw.flush();
		}
		br.close();
		bw.close();
	}
}
