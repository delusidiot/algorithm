import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution_2565 {
	static BufferedReader br;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int wireNum = Integer.parseInt(br.readLine());//100이하의 자연수
		int[][] connect = new int[2][wireNum];
		int max = 0;
		for (int i = 0; i < wireNum; i++) {
			String line = br.readLine();
			connect[0][i]=Integer.parseInt(line.split(" ")[0]);//500 이하의 자연수
			if(max<connect[0][i])
				max=connect[0][i];
			connect[1][i]=Integer.parseInt(line.split(" ")[1]);
			if(max<connect[1][i])
				max=connect[1][i];
		}
		int[] count = new int[max+1];
		
		for (int i = 0; i < wireNum; i++) {
			for (int j = 0; j < wireNum; j++) {
				if(i==j)continue;
				if((connect[0][i]<connect[0][j]||connect[0][i]<connect[1][j])&&(connect[1][i]>connect[0][j]||connect[1][i]>connect[1][j])) {
					count[connect[0][i]]++;
				}
			}
		}
		System.out.println(Arrays.toString(count));
		bw.write("");
		bw.close();
	}
}
