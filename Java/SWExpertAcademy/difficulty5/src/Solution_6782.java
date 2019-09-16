import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_6782{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {//N을 2로 만들기 위해!
			long N = Long.parseLong(br.readLine());
			long count = 0;
			long next = 0;
			while(N!=2) {
				if(Math.sqrt(N)%1>0) {
					next=(long)(Math.sqrt(N)/1)+1;
					count+=(next*next-N);// N+1 한 값
					N = next; count ++;// sqrt count+1
				}else {
					N = (long)Math.sqrt(N); count ++;
				}
			}
			bw.write("#"+testCase+" "+count+"\n");
			bw.flush();
		}
		bw.close();
	}
}
