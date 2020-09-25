package kakao_2018;

import java.util.*;

public class ShuttleBus3 {
    public String solution(int n, int t, int m, String[] timetable) {
        int currentTime = timeToInteger("09:00");
        
        PriorityQueue<Integer> times = new PriorityQueue<>();
        for (String time : timetable) {
			times.add(timeToInteger(time));
		}
        int answer = 0;
        while(n-->0) {
            int passengerCounter = m;
            int time = 0;
            while(!times.isEmpty()) {
                if (times.peek() <= currentTime && passengerCounter > 0) {
                	passengerCounter--;
                    time = times.poll();
                } else break;
            }
            if (n != 0) {
                if (times.isEmpty()) {
                	answer = currentTime +((n+1)*t);
                    break;
                }
                currentTime += t;
            } else {// 마지막 버스
                if (passengerCounter > 0) answer = currentTime;
                else answer = time-1;
                break;
            }
        }
        return integerToTime(answer);
    }
	public static void main(String[] args) {
		ShuttleBus3 s = new ShuttleBus3();
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
		int minute = Integer.parseInt(hourMinute[0])*60 + Integer.parseInt(hourMinute[1]);
		if(minute == 1440) minute = 0;
		return minute;
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
