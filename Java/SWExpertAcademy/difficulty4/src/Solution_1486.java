import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_1486 {
	static BufferedReader br;
	static BufferedWriter bw;
	static int min;
	static int N;
	static int B;
	static int[] clerk;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine()+" ");
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			min=Integer.MAX_VALUE;
			clerk= new int[N];
			st = new StringTokenizer(br.readLine()+" ");
			for (int i = 0; i < clerk.length; i++) {
				clerk[i]=Integer.parseInt(st.nextToken());
			}
			arr = new int[N];
			for (int i = 0; i < arr.length; i++) {
				arr[i]=i;
			}
			for (int i = 1; i <= N; i++) {
				tr=new int[i];
				comb(N,i);
			}
			bw.write("#"+testCase+" "+(min-B)+"\n");
			bw.flush();
		}
		bw.close();
	}
	public static int[] tr;
	public static int[] arr;
	public static void comb(int n, int r) {
		if(r==0) {
			int result = 0;
			for (int i = 0; i < tr.length; i++) {
				result += clerk[tr[i]];
			}
			if(result>=B) {
				if(min>result)
					min=result;
			}
			return;
		}if(n<r) {
			return;
		}else {
			tr[r-1]=arr[n-1];
			comb(n-1,r-1);
			comb(n-1,r);
		}
	}
}
