import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main_1931 {
	static BufferedReader br;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());//T = 10
		int[][] startEnd = new int[T][2];
		int endTime = -1;
		int cnt = 0;
		String line = "";
		String[] lineSplit = null;
		for (int i = 0; i < startEnd.length; i++) {
			line = br.readLine();
			lineSplit = line.split(" ");
			startEnd[i][0] = Integer.parseInt(lineSplit[0]);
			startEnd[i][1] = Integer.parseInt(lineSplit[1]);
		}
		Arrays.sort(startEnd, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[1]==o2[1] ? o1[0]-o2[0] : o1[1]-o2[1];
			}
		});
		for (int i = 0; i < startEnd.length; i++) {
			if(startEnd[i][0] >= endTime) {
				cnt++;
				endTime = startEnd[i][1]; 
			}
		}
		System.out.println(cnt);
	}
}