import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_4366_2 {
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
			int compB = 0;
			int compT = 0;
			one=1;
			aa:for (int i = binary.length()-1; i >= 0 ; i--) {
				compB =bTd;
				char a = binary.charAt(i);
				if(a=='1') {
					compB -=one;
				}else {
					compB +=one;
				}
				
				for (int j = third.length()-1; j >= 0 ; j--) {
					compT=tTd;
					if(third.charAt(j)=='0') {
						if(compT+(int)Math.pow(3, third.length()-j-1)==compB)
							break aa;
						if(compT+2*(int)Math.pow(3, third.length()-j-1)==compB)
							break aa;
							
					}else if(third.charAt(j)=='1') {
						if(compT-(int)Math.pow(3, third.length()-j-1)==compB)
							break aa;
						if(compT+(int)Math.pow(3, third.length()-j-1)==compB)
							break aa;
						
					}else if(third.charAt(j)=='2') {
						if(compT-(int)Math.pow(3, third.length()-j-1)==compB)
							break aa;
						if(compT-2*(int)Math.pow(3, third.length()-j-1)==compB)
							break aa;
					}
				}
				one=one<<1;
			}
			bw.write("#"+testCase+" "+compB+"\n");
			bw.flush();
		}
		br.close();
		bw.close();
	}
}
