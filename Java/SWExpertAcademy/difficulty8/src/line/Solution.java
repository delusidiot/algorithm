package line;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
        int number = sc.nextInt();
        int consumer = sc.nextInt();
    	int[] consumers = new int[consumer];
        for (int i = 0; i < number; i++) {
        	int min = Integer.MAX_VALUE;
        	int idx = 0;
        	for (int j = 0; j < consumer; j++) {
				if(min>consumers[j]) {
					min = consumers[j];
					idx=j;
				}
			}
        	consumers[idx]+=sc.nextInt();
		}
        int result = 0;
        for (int i = 0; i < consumers.length; i++) {
			if(result<consumers[i])result=consumers[i];
		}
        System.out.println(result);
	}
}
