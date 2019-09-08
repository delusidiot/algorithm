import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 7810. 승현이의 질문
public class Solution_7810_A {
	static int[] nums = new int[1000001];
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(reader.readLine());
		StringTokenizer st =  null;
		int num = 0;
		int max = 0;
		int cnt = 0;
		for(int t = 1; t <= TC; t++) {
			Arrays.fill(nums, 0);
			max = 0;
			cnt = 0;
			reader.readLine(); // 버림
			st = new StringTokenizer(reader.readLine());
			
//			카운팅 개념을 이용해서 카운트 배열 만들고 카운딩 함
			while(st.hasMoreTokens()) {
				num = Integer.parseInt(st.nextToken());
				nums[num]++;
				max = Math.max(num, max);
			}
//			H는 수열에서 H보다 크거나 같은 숫자가 H개 이상 존재하는 값
//			만약 이러한 숫자가 여러 개면 그 중 가장 큰 값이 궁금하다.(큰수에서 작은수로 찾으면 됨)
			while(cnt < max) {
				cnt += nums[max];
				max--;
			}
			System.out.println("#" + t + " " + cnt);
		}
	}
}
