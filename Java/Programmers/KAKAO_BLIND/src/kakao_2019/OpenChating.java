package kakao_2019;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class OpenChating {
	public static void main(String[] args) {
		OpenChating op = new OpenChating();
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		System.out.println(op.solution(record));
	}
	public String[] solution(String[] record) {
		Map<String, String> users = new HashMap<String, String>();
		Queue<String[]> list = new LinkedList<String[]>();
		
		for(String user : record) {
			String[] info = user.split(" ");
			switch(info[0]) {
			case "Enter":
				users.put(info[1], info[2]);
				//list.add(new String[](""," 님이 들어왔습니다." ));
				break;
			case "Leave":
				//list.add(info[1]+" 님이 나갔습니다.");
				break;
			case "Change":
				users.put(info[1], info[2]);
				break;
			}
		}
        String[] answer = {};
        
        return answer;
        //[닉네임]님이 들어 왔습니다.
        //[닉네임]님이 나갔습니다.
    }
}

