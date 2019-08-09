import java.util.Scanner;
//BufferedReader를 이용하면 메모리 Overflow가 일어남.....
public class Solution_8104_C {
//	static BufferedReader br;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
//		br = new BufferedReader(new InputStreamReader(System.in));
		int T = sc.nextInt();//Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
//			String line = br.readLine();
//			String[] numbers = line.split(" ");
			int N = sc.nextInt();//Integer.parseInt(numbers[0]);
			int K = sc.nextInt();//Integer.parseInt(numbers[1]);  //총인원 N*K
			System.out.print("#"+testCase+" ");
			for(int i = 0; i<K ;i++) {
				int result = 0;
				for (int j = 0; j < N; j++) {
					if(j%2==0)
						result = result +(K*j)+(i+1);
					else
						result = result +(K*j)+(K-i);
				}
				System.out.print(result+" ");
			}
			System.out.println();
		}
	}
}
