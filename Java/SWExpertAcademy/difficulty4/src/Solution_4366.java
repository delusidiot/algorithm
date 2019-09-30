import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_4366 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			String binary = br.readLine();
			String third = br.readLine();
			int bTd = 0;
			int tTd = 0;
			int one = 1;
			for (int i = binary.length()-1; i >= 0 ; i--) {
				bTd+=(binary.charAt(i)-'0')*one;
				one*=2;
			}
			one=1;
			for (int i = third.length()-1; i >= 0 ; i--) {
				tTd+=(third.charAt(i)-'0')*one;
				one*=3;
			}
			int sub = Math.abs(bTd-tTd);
			
			//2^n + 3^m
			//3^m - 2^n
			int N = 0;
			int M = 0;
			for (int i = 0; i < binary.length(); i++) {
				for (int j = 0; j < third.length(); j++) {
					char a = binary.charAt(i);
					if(a=='1') {
						sub-=Math.pow(2, i);
					}else {
						
					}
				}
			}
			System.out.println(bTd+" "+tTd);
			System.out.println(N+" "+M);
			if(bTd>tTd) {
				bTd-=Math.pow(2, N);
			}else {
				bTd+=Math.pow(2, N);
			}
			bw.write("#"+testCase+" "+bTd+"\n");
			bw.flush();
		}
		br.close();
		bw.close();
	}
}
