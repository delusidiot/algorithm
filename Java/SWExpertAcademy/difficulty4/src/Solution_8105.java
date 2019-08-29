import java.util.Scanner;
public class Solution_8105 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int[] stone = new int[2];//1~100
			int min = 0;
			int max = 0;
			for (int i = 0; i < stone.length; i++) {
				stone[i]=sc.nextInt();
			}
			if(stone[0]>stone[1]) {
				min=stone[1];
				max=stone[0];
			}else {
				min=stone[0];
				max=stone[1];
			}
			String result = "";
			if(max%2==1) {
				
			}
			
			
			
			System.out.println("#"+testCase+" "+result);
		}
	}
}
