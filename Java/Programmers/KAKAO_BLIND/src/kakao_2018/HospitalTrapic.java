package kakao_2018;

import java.util.Arrays;

public class HospitalTrapic {
	public int solution(String[] lines) {
		int answer = 0;
		int[][] times = new int[2][lines.length];
		for (int i = 0; i < lines.length; i++) {
			String[] logList = lines[i].split(" ");
			String[] t = logList[1].split(":");
			int processingTime = (int)(Double.parseDouble(logList[2].substring(0, logList[2].length() - 1))*1000);
			
			times[1][i]+=Integer.parseInt(t[0])*60*60*1000;
			times[1][i]+=Integer.parseInt(t[1])*60*1000;
			times[1][i]+=Double.parseDouble(t[2])*1000;
			times[0][i] = times[1][i]-processingTime+1;
		}
		for (int i = 0; i < lines.length; i++) {
			int count = 0;
			for (int j = 0; j < lines.length; j++) {
				if(times[0][j] >= times[0][i] && times[0][j] < times[0][i]+1000) {
					count++;
				}else if(times[1][j] >= times[0][i] && times[1][j] < times[0][i]+1000) {
					count++;
				}else if(times[0][j] <= times[0][i] && times[1][j] >= times[0][i]+1000) {
					count++;
				}
			}
			answer = count > answer ? count :answer;
			
		}
		for (int i = 0; i < lines.length; i++) {
			int count = 0;
			for (int j = 0; j < lines.length; j++) {
				if(times[0][j] >= times[1][i] && times[0][j] < times[1][i]+1000) {
					count++;
				}else if(times[1][j] >= times[1][i] && times[1][j] < times[1][i]+1000) {
					count++;
				}else if(times[0][j] <= times[1][i] && times[1][j] >= times[1][i]+1000) {
					count++;
				}
			}
			answer = count > answer ? count :answer;
		}
		System.out.println(Arrays.toString(times[0]));
		System.out.println(Arrays.toString(times[1]));
		return answer;
	}
	
	
	//시작 시간과 끝 시간을 포함한다.
	public static void main(String[] args) {
		HospitalTrapic h = new HospitalTrapic();
		String[] lines = 
			{
				"2016-09-15 20:59:57.421 0.351s",
				"2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s",
				"2016-09-15 20:59:58.688 1.041s",
				"2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s",
				"2016-09-15 21:00:00.741 1.581s",
				"2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s",
				"2016-09-15 21:00:02.066 2.62s"
			};
		System.out.println(h.solution(lines));
	}
}