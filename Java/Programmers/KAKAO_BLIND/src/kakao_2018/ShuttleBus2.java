package kakao_2018;

import java.util.PriorityQueue;

public class ShuttleBus2 {
    public String solution(int n, int t, int m, String[] timetable) {
        int answer = 0;
        int currentTime = timeToInteger("09:00");
        PriorityQueue<Integer> times = new PriorityQueue<>();// 기본 오름차순
        for (String time : timetable) {
			times.add(timeToInteger(time));
		}
        int passengerCounter = 0;
        int crew = times.poll();
        
        while(n != 0) {
        	if(n == 1) {
        		if(times.size() < m - 1 - passengerCounter) {
        			answer = currentTime;
        			break;
        		}else {
        			if(crew <= currentTime && passengerCounter < m) {
        				passengerCounter++;
        				if(!times.isEmpty())
        					crew = times.poll();
        				if(passengerCounter == m) {
    		        		answer = crew - 1;
    		        		n--;
        				}
        			}else{
        				answer = currentTime;
        				n--;
        			}
        		}
        	}else {
	        	if(crew <= currentTime && passengerCounter < m) {
	        		passengerCounter++;
	        		if(times.isEmpty()) {
	        			answer = currentTime + ((n-1)*t);
	        			break;
	        		}
	        		crew = times.poll();
	        		if(passengerCounter == m) {
		        		n--;
		        		passengerCounter = 0;
		        		currentTime += t;
		        	}
	        	}else{
	        		n--;
	        		passengerCounter = 0;
	        		currentTime += t;
	        	}
        	}
        }
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
