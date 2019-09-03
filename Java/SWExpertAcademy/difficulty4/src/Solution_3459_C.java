import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_3459_C {
	public static BufferedReader br;
	public static BufferedWriter bw;
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			long N = Long.parseLong(br.readLine());
			long sameN = N;
			long count = 0;
			while(sameN>=1) {
				sameN=sameN>>1;
				count++;
			}
			long game = 1;
			String result = "";
			if(N==1) result = "Bob";
			else if(N==2||N==3) result = "Alice";
			else if(count%2==1) {//A 선택
				while (count>1){
					game = game * 2+1; //A
					count--;
					if(count<=1) break;
					game = (game * 2); //B
					count--;
				}
				if(N<game)result = "Alice";
				else result = "Bob";
			}else { //B 선택
				while (count>1){
					game = (game * 2); //A
					count--;
					if(count<=1) break;
					game = game * 2+1;  //B
					count--;
				}
				if(N<game) result = "Bob";
				else result = "Alice";
			}
			bw.write("#"+testCase+" "+result+ "\n");
			bw.flush();
		}
		br.close();
		bw.close();
	}
}
