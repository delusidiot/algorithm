package kakao_2018;

import java.util.Arrays;

public class SecretMap {

	public static void main(String[] args) {
		SecretMap s = new SecretMap();
		int n = 5;
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};
		System.out.println(s.solution(n, arr1, arr2));

	}
	public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
			arr1[i] = arr1[i] | arr2[i];
		}
        System.out.println(Arrays.toString(arr1));
        arr2 = arr1.clone();
        for (int i = 0; i < answer.length; i++) {
        	for (int j = 0; j < n; j++) {
        		System.out.print(arr2[i]% 2);
        		arr2[i]/=2;
    		}
        	System.out.println();
		}
        
        for (int i = 0; i < arr1.length; i++) {
        	StringBuilder sb = new StringBuilder();
        	int bit = 1;
        	for (int j = 0; j < n; j++) {
        		if((arr1[i] & bit) > 0)
        			sb.append("#");
        		else
        			sb.append(" ");
        		bit*=2;
			} 
        	answer[i] = sb.reverse().toString();
		}
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
