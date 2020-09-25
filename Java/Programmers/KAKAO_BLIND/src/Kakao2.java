import java.util.*;
import java.util.Map.Entry;

public class Kakao2 {
	public static void main(String[] args) {
		Kakao2 k = new Kakao2();
		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = {2,3,4};
		System.out.println(Arrays.toString(k.solution(orders, course)));
		
	}
	public String[] solution(String[] orders, int[] course) {
		List<String> list = new LinkedList<String>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		Info[] max = new Info[11];
		for (int i = 0; i < max.length; i++) {
			max[i] = new Info();
		}
		for (int i = 0; i < orders.length; i++) {
			for (int j = 0; j < course.length; j++) {
				boolean[] visited = new boolean[orders[i].length()];
				comb(map, orders[i], visited, 0, orders[i].length(), course[j]);
			}
		}
		System.out.println(map);
		for (Entry<String, Integer> entry : map.entrySet()) {
			if(entry.getValue() > 1) {
				if(max[entry.getKey().length()].max < entry.getValue()) {
					max[entry.getKey().length()] = new Info();
					max[entry.getKey().length()].max = entry.getValue();
					max[entry.getKey().length()].list.add(entry.getKey());
				}else if(max[entry.getKey().length()].max == entry.getValue()){
					max[entry.getKey().length()].list.add(entry.getKey());
				}
			}
		}
		for (int i = 0; i < max.length; i++) {
			for (String s : max[i].list) {
				list.add(s);
			}
		}
		Collections.sort(list);
        String[] answer = new String[list.size()];
        int i = 0;
        for (String l : list) {
        	answer[i] = l;
			i++;
		}
        
        return answer;
    }
	public void comb (Map<String, Integer> map, String order, boolean[] visited, int start, int course, int r) {
		if(r == 0) {
			insert(map, order, visited, course);
			return;
		}
		for(int i=start; i < course; i++) {
	        visited[i] = true;
	        comb(map, order, visited, i + 1, course, r - 1);
	        visited[i] = false;
	    }
	}
	public void insert(Map<String, Integer> map, String order, boolean[] visited, int n) {
		StringBuilder sb = new StringBuilder();
		List<Character> list = new ArrayList<Character>();
		for (int i = 0; i < n; i++) {
            if (visited[i]) {
                list.add(order.charAt(i));
            }
        }
		Collections.sort(list);
		for (Character character : list) {
			sb.append(character);
		}
		if(map.get(sb.toString())== null) {
			map.put(sb.toString(), 1);
		}else {
			map.put(sb.toString(), map.get(sb.toString())+1);
		}
	}
}
class Info{
	int max;
	List<String> list;
	public Info() {
		max = 0;
		list = new ArrayList<String>();
	}
}
