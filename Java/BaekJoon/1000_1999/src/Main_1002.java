import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_1002 {
	static BufferedReader br;
	static BufferedWriter bw;
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine()); //x,y = -10000~10000 r<=10000
		for (int testCase = 1; testCase <= T; testCase++) {
			String[] line = br.readLine().split(" ");
			int x1 = Integer.parseInt(line[0]);
			int y1 = Integer.parseInt(line[1]);
			int x2 = Integer.parseInt(line[2]);
			int y2 = Integer.parseInt(line[3]);
			int r1 = Integer.parseInt(line[4]);
			int r2 = Integer.parseInt(line[5]);
			int position = 0;
			
			long d = (x2-x1)*(x2-x1)+(y2-y1)*(y2-y1);//두점 사이의 거리 제곱
			long rsub = (r1-r2)*(r1-r2);
			long radd = (r1+r2)*(r1+r2);

			if(x1==x2&&y1==y2&&r1==r2) {
				position = -1;
			}else if(d == radd || d == rsub) {
				position = 1;
			}else if(rsub < d && d < radd) {
				position = 2;
			}else position = 0;
			
			bw.write(String.valueOf(position)+"\n");
		}
		br.close();
		bw.close();
	}
}
