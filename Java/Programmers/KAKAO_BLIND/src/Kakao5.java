import java.util.*;


public class Kakao5 {
	public static void main(String[] args) {
		Kakao5 k = new Kakao5();
		String play_time = "02:03:55";
		String adv_time = "00:14:15";
		String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
		System.out.println(k.solution(play_time, adv_time, logs));
	}
	public String solution(String play_time, String adv_time, String[] logs) {
		String[] play = play_time.split(":");
		String[] adv = adv_time.split(":");
		int playTime = Integer.parseInt(play[0])*60*60 + Integer.parseInt(play[1])*60 +Integer.parseInt(play[2]);
		int advTime = Integer.parseInt(adv[0])*60*60 + Integer.parseInt(adv[1])*60 +Integer.parseInt(adv[2]);
		UserTime[] logsTime = new UserTime[logs.length];
		for (int i = 0; i < logsTime.length; i++) {
			String[] log = logs[i].split("-");
			String[] starts = log[0].split(":");
			String[] ends = log[1].split(":");
			logsTime[i] = new UserTime(Integer.parseInt(starts[0])*60*60 + Integer.parseInt(starts[1])*60 +Integer.parseInt(starts[2])
									, Integer.parseInt(ends[0])*60*60 + Integer.parseInt(ends[1])*60 +Integer.parseInt(ends[2]));
		}
		
		System.out.println(playTime);
		System.out.println(advTime);
		Arrays.sort(logsTime);
		System.out.println(Arrays.toString(logsTime));
		
		for (int i = 0; i < logsTime.length; i++) {
			
		}
		
        String answer = "";
        return answer;
    }
}
class UserTime implements Comparable<UserTime>{
	int start;
	int playTime;
	public UserTime(int start, int end) {
		super();
		this.start = start;
		this.playTime = end - start;
	}
	@Override
	public String toString() {
		return "UserTime [start=" + start + ", playTime=" + playTime + "]";
	}
	@Override
	public int compareTo(UserTime o) {
		return this.start - o.start;
	}
}
