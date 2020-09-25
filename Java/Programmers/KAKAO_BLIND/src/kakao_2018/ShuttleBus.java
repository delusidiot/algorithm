package kakao_2018;

import java.util.Arrays;

public class ShuttleBus {
    public String solution(int n, int t, int m, String[] timetable) {
        int answer = 0;
        int currentTime = timeToInteger("09:00");
        System.out.println(answer);
        int[] timetables = new int[timetable.length];
        for (int i = 0; i < timetables.length; i++) {
			timetables[i] = timeToInteger(timetable[i]);
		}
        boolean check = false;
        Arrays.sort(timetables);
        System.out.println(Arrays.toString(timetables));
        int human = 0;
        for (int i = 0; i < n; i++) {
        	int count = 0;// 셔틀버스에 탈 사람
        	for (int j = human; human < timetables.length; j++) {
				if(currentTime >= timetables[j] && count < m) {
					answer = timetables[j]-1;
					human++;
					count++;
					check = true;
					if(i == n-1 && j == timetables.length-1 && count < m) {
						answer = 540+t*(n-1);
						check = true;
					}
				}
				else {
					if(i == timetables.length-1 && human >= 1) {
						answer = timetables[human - 1] - 1;
						check = true;
					}
					break;
				}
			}
        	currentTime += t;
		}
        if(!check && (answer == 0 || answer > 540+t*(n-1))) answer = 540+t*(n-1); 
        return integerToTime(answer);
    }
    public static void main(String[] args) {
		
		ShuttleBus2 s = new ShuttleBus2();
		int n = 1;
		int t = 1;
		int m = 5;
		String[] timetable = {"08:00", "08:01", "08:02", "08:03"};
		System.out.println(s.solution(n, t, m, timetable) + ": 09:00");
		n=2; t=10; m=2;
		String[] timetable2 = {"09:10", "09:09", "08:00"};
		System.out.println(s.solution(n, t, m, timetable2) + ": 09:09");
		
		n=2; t=1; m=2;
		String[] timetable3 = {"09:00","09:00","09:00","09:00"};
		System.out.println(s.solution(n, t, m, timetable3) + ": 08:59");
		
		n=1; t=1; m=5;
		String[] timetable4 = {"00:01","00:01","00:01","00:01","00:01"};
		System.out.println(s.solution(n, t, m, timetable4) + ": 00:00");
		
		n=1; t=1; m=1;
		String[] timetable5 = {"23:59"};
		System.out.println(s.solution(n, t, m, timetable5) + ": 09:00");
		
		n=10; t=60; m=45;
		String[] timetable6 = {"23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59"};
		System.out.println(s.solution(n, t, m, timetable6) + ": 18:00");
	}
	public int timeToInteger(String time) {
		String[] hourMinute = time.split(":");
		return Integer.parseInt(hourMinute[0])*60 + Integer.parseInt(hourMinute[1]);
	}
	public String integerToTime(int time) {
		String hour = String.valueOf(time / 60);
		if(hour.length()==1) {
			hour = "0"+hour;
		}
		String minute = String.valueOf(time % 60);
		if(minute.length()==1) {
			minute = "0"+minute;
		}
		return hour + ":" + minute;
	}
}
