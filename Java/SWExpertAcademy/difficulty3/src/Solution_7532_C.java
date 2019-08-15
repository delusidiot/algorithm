import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_7532_C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			String line = br.readLine();
			int[] SEM = new int[3];
			SEM[0] = Integer.parseInt(line.split(" ")[0]);
			SEM[1] = Integer.parseInt(line.split(" ")[1]);
			SEM[2] = Integer.parseInt(line.split(" ")[2]);
			
			System.out.println("#"+testCase+" " + SEMCal(SEM));
		}
	}
	public static int SEMCal(int[] SEM) {
		int count = 1;
		while(((count%365==0?365:(count%365))!=SEM[0])||
				((count%24==0?24:(count%24))!=SEM[1])||
				((count%29==0?29:(count%29))!=SEM[2])) {
			count++;
		}
		return count;
	}
}
