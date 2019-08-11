import java.util.Scanner;

public class Solution_5215_Group {
	static Scanner sc;
	static int favor = 0;
	static int meterialNumber = 0;
	static int limited = 0;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			meterialNumber = sc.nextInt();
			limited = sc.nextInt();
			favor = 0;
			int[][] meterialInfo = new int[2][meterialNumber];
			boolean[] checked = new boolean[meterialNumber];
			meterialInfo = createInfo(meterialInfo);
			
			caloryCal(0, meterialInfo, 0, 0, checked);
			System.out.println("#"+testCase+" "+favor);
		}
	}
	
	static int[][] createInfo(int[][] meterialInfo) {
		for (int i = 0; i < meterialInfo.length; i++) {
			meterialInfo[0][i]=sc.nextInt();
			meterialInfo[1][i]=sc.nextInt();
		}
		return meterialInfo;
	}
	static void caloryCal(int start,int[][] meterialInfo,int calory,int score, boolean[] checked) {
		if(start == meterialNumber) {
			if(score>limited)
				return;
			if(score>favor) {
				favor = score;
				return;
			}
		}
		for (int i = 0; i < meterialNumber; i++) {
			checked[i]=true;
			calory+=meterialInfo[0][start];
			score+=meterialInfo[1][start];
			caloryCal(start+1, meterialInfo, calory, score,checked);
			calory-=meterialInfo[0][start];
			score-=meterialInfo[1][start];
			checked[i]=false;
		}
	}
}
