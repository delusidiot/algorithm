import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_2007_Group_3 {
	static BufferedReader br;
	static BufferedWriter bw;
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			String line = br.readLine();
			String word = "";
			String word2 = "";
			boolean next = false;
			int i = 0;
			for (int j = 0; j < line.length(); j++) {
				if(line.charAt(i)!=line.charAt(j)) {
					i=0;
					word2="";
					next = true;
					if(!word.equals(word2)) {
						word+=word2;
					}
					
				}
				if(!next) {
					word+=line.charAt(i);
				}else {
					
				}
				i++;
				word2+=line.charAt(j);
			}
			bw.write("#"+testCase+" "+word.length()+"\n");
			bw.flush();
		}
		bw.close();
	}
}
