import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_8457_C {
	static BufferedReader br;
	static BufferedWriter bw;
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());// 갯수
			int B = Integer.parseInt(st.nextToken());// 측정초
			int E = Integer.parseInt(st.nextToken());// 오차범위
			int minB = B-E;
			int maxB = B+E;
			st = new StringTokenizer(br.readLine(), " ");
			int count = 0;
			for (int i = 0; i < N; i++) {
				int time=Integer.parseInt(st.nextToken());
				int add = 0;
				while(add<maxB) {
					add+=time;
					if(add>=minB&&add<=maxB) {
						count ++;
						break;
					}
				}
			}
			
			bw.write("#"+testCase+" "+count+"\n");
			bw.flush();
		}
		br.close();
		bw.close();
		
	}
}
