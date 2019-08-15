import java.util.Scanner;

public class Solution_7584_2_C {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long K = 0;
		int result = 0;
		for(int testCase=1; testCase<=T; testCase++) {
			K = sc.nextLong()-1;
			result = 0;
			while(K > 0) {
				if(K%4 == 0) {
					result = 0; break;
				}else if(K%2 == 0) {
					result = 1; break;
				}
				if(K%2 == 1) 
					K = (K-1)/2;
			}
				System.out.println("#"+testCase+" "+result);	
		}
	}
}