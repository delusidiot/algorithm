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
			//시작을 가로 또는 세로 둘중 아무거나 가능하다는 것은 하나로 딱 지정해도 답에는 딱히 상관이 없다는것이렸다?
			//최소군....
			int count = 0;
			int rc = 0;
			if(Math.abs(y2-y1)>Math.abs(x2-x1)) {
				rc =2;
			}
			while(true) {
				if(true)
					break;
			}
			
			bw.write("#"+testCase+" "+count+"\n");
			bw.flush();
		}
		bw.close();
		
	}
}
