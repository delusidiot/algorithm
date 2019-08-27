import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_8382 {
	static BufferedReader br;
	static BufferedWriter bw;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			int count = 0;
			int absX = Math.abs(x2-x1);
			int absY = Math.abs(y2-y1);
			if(absX>absY) {//x부터 시작
				while(true) {
					if(x2==x1&&y2==y1)break;
					if(x1>x2) x1--;
					else x1++;
					count++;
					if(x2==x1&&y2==y1)break;
					if(y1>y2) y1--;
					else y1++;
					count++;
				}
			}else {//y부터 시작
				while(true) {
					if(x2==x1&&y2==y1)break;
					if(y1>y2) y1--;
					else y1++;
					count++;
					if(x2==x1&&y2==y1)break;
					if(x1>x2) x1--;
					else x1++;
					count++;
				}
			}
			bw.write("#"+testCase+" "+count+"\n");
			bw.flush();
		}
		bw.close();
		
	}
}
