import java.util.Arrays;
import java.util.Scanner;

public class Solution_7732 {
	static Scanner sc;
	public static void main(String[] args) {
		//현재시간보다 약속 시각이 빠른 경우 약속이 다음날에 있는것.
		// 00:00:00
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int testCase = 1; testCase <= T; testCase++) {
			String curruntTime = sc.nextLine();
			String promiseTime = sc.nextLine();
			String result = leftTime(curruntTime, promiseTime);
			System.out.println("#"+testCase+" "+result);
		}
	}
	public static String leftTime (String curruntTime, String promiseTime) {
		
		String[] currunt = curruntTime.split(":");
		String[] promise = promiseTime.split(":");
		int[] curruntInt = new int[currunt.length];
		int[] promiseInt = new int[promise.length];
		for (int i = 0; i < promiseInt.length; i++) {
			curruntInt[i]=Integer.parseInt(currunt[i]);
			promiseInt[i]=Integer.parseInt(promise[i]);
		}
		
		String[] result = new String[currunt.length];
		
		int carry = 0;
		if( (curruntInt[0] >  promiseInt[0])||
			(curruntInt[0] == promiseInt[0] && curruntInt[1] >  promiseInt[1])||
			(curruntInt[0] == promiseInt[0] && curruntInt[1] == promiseInt[1] && curruntInt[2] > promiseInt[2])){
			//24시에서 현재시간을 뺀뒤 약속시간을 더한다.
			carry=-1;
			result[2]=String.valueOf(60-curruntInt[2]+promiseInt[2]%60);
			if((60-curruntInt[2]+promiseInt[2])>60) {
				carry=0;
			}
			result[1]=String.valueOf((60-curruntInt[1]+promiseInt[1]+carry)%60);
			if((60-curruntInt[1]+promiseInt[1]+carry)>60) {
				carry=0;
			}else {
				carry =-1;
			}
			result[0]=String.valueOf((24-curruntInt[0]+promiseInt[0]+carry)%24);
		}else {//약속시간이 더 큰 경우
			carry = 0;
			if((promiseInt[2]-curruntInt[2])<0) {
				result[2]=String.valueOf((promiseInt[2]+60-curruntInt[2])%60);
			}else {
			result[2]=String.valueOf((promiseInt[2]-curruntInt[2])%60);
			}
			if((promiseInt[2]-curruntInt[2])<0) {
				carry=-1;
			}
			if((promiseInt[1]-curruntInt[1]+carry)<0) {
				result[1]=String.valueOf((promiseInt[1]+60-curruntInt[1]+carry)%60);
			}else {	
				result[1]=String.valueOf((promiseInt[1]-curruntInt[1]+carry)%60);
			}
			if((promiseInt[1]-curruntInt[1]+carry)<0) {
				carry=-1;
			}else { carry = 0;}
			
			result[0]=String.valueOf((promiseInt[0]-curruntInt[0]+carry)%24);
		}
		for (int i = 0; i < result.length; i++) {
			if(result[i].length()==1) {
				result[i]="0"+result[i];
			}
		}
		return result[0]+":"+result[1]+":"+result[2];
	}
}
