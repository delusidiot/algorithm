import java.util.Scanner;
// 최대 상금 문제
// 교환횟수에 따른 모든 교환 경우를 다 해보고 가장 큰 경우를 출력해줍니다.
public class Solution_1244 {
	static Scanner sc;
	static int max = 0;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int testCase = 1; testCase <= T; testCase++) {
			String input = sc.nextLine();
			char[] numberInfo = input.split(" ")[0].toCharArray();
			int change = Integer.parseInt(input.split(" ")[1]);
			max = Integer.parseInt(input.split(" ")[0]);
			dfs(0, 0, change, numberInfo);
			System.out.println("#"+testCase+" "+max);
		}
	}
	public static void dfs(int start, int count, int change,char[] numberInfo) {
		if(count == change) {//교환 횟수가 모두 끝났을 경우
			String result = "";
			for (int i = 0; i < numberInfo.length; i++) {
				result+=numberInfo[i];
			}
			if(Integer.parseInt(result)>max)
				max = Integer.parseInt(result);
			return;
		}
		for (int i = start; i < numberInfo.length; i++) {
			for (int j = i+1; j < numberInfo.length; j++) {//모든 교환 방법을 다 해본다.
				if(numberInfo[i] <= numberInfo[j]) {
					char temp;
					temp = numberInfo[i];
					numberInfo[i] = numberInfo[j];
					numberInfo[j] = temp;
					dfs(i, count+1, change, numberInfo);
					temp = numberInfo[i];
					numberInfo[i] = numberInfo[j];
					numberInfo[j] = temp;
				}
			}
		}
	}
}
