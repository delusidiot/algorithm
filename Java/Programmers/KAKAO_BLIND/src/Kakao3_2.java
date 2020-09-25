import java.util.*;
import java.util.Map.Entry;


public class Kakao3_2 {
	public static void main(String[] args) {
		Kakao3_2 k = new Kakao3_2();
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		System.out.println(Arrays.toString(k.solution(info, query)));
		
	}
	public int[] solution(String[] info, String[] query) {
		Map<String, Map<String, Map<String, Map<String, List<Integer>>>>> tree = new HashMap<String, Map<String,Map<String,Map<String,List<Integer>>>>>();
		tree.put("java",new HashMap<String, Map<String,Map<String,List<Integer>>>>());
		tree.put("cpp",new HashMap<String, Map<String,Map<String,List<Integer>>>>());
		tree.put("python",new HashMap<String, Map<String,Map<String,List<Integer>>>>());
		
		tree.get("java").put("backend", new HashMap<String, Map<String,List<Integer>>>());
		tree.get("cpp").put("backend", new HashMap<String, Map<String,List<Integer>>>());
		tree.get("python").put("backend", new HashMap<String, Map<String,List<Integer>>>());
		tree.get("java").put("frontend", new HashMap<String, Map<String,List<Integer>>>());
		tree.get("cpp").put("frontend", new HashMap<String, Map<String,List<Integer>>>());
		tree.get("python").put("frontend", new HashMap<String, Map<String,List<Integer>>>());
		
		
		tree.get("java").get("backend").put("junior", new HashMap<String, List<Integer>>());
		tree.get("cpp").get("backend").put("junior", new HashMap<String, List<Integer>>());
		tree.get("python").get("backend").put("junior", new HashMap<String, List<Integer>>());
		tree.get("java").get("backend").put("senior", new HashMap<String, List<Integer>>());
		tree.get("cpp").get("backend").put("senior", new HashMap<String, List<Integer>>());
		tree.get("python").get("backend").put("senior", new HashMap<String, List<Integer>>());
		
		tree.get("java").get("frontend").put("junior", new HashMap<String, List<Integer>>());
		tree.get("cpp").get("frontend").put("junior", new HashMap<String, List<Integer>>());
		tree.get("python").get("frontend").put("junior", new HashMap<String, List<Integer>>());
		tree.get("java").get("frontend").put("senior", new HashMap<String, List<Integer>>());
		tree.get("cpp").get("frontend").put("senior", new HashMap<String, List<Integer>>());
		tree.get("python").get("frontend").put("senior", new HashMap<String, List<Integer>>());
		
		tree.get("java").get("backend").get("junior").put("chicken", new ArrayList<Integer>());
		tree.get("cpp").get("backend").get("junior").put("chicken", new ArrayList<Integer>());
		tree.get("python").get("backend").get("junior").put("chicken", new ArrayList<Integer>());
		tree.get("java").get("frontend").get("junior").put("chicken", new ArrayList<Integer>());
		tree.get("cpp").get("frontend").get("junior").put("chicken", new ArrayList<Integer>());
		tree.get("python").get("frontend").get("junior").put("chicken", new ArrayList<Integer>());
		
		tree.get("java").get("backend").get("junior").put("pizza", new ArrayList<Integer>());
		tree.get("cpp").get("backend").get("junior").put("pizza", new ArrayList<Integer>());
		tree.get("python").get("backend").get("junior").put("pizza", new ArrayList<Integer>());
		tree.get("java").get("frontend").get("junior").put("pizza", new ArrayList<Integer>());
		tree.get("cpp").get("frontend").get("junior").put("pizza", new ArrayList<Integer>());
		tree.get("python").get("frontend").get("junior").put("pizza", new ArrayList<Integer>());
		
		tree.get("java").get("backend").get("senior").put("chicken", new ArrayList<Integer>());
		tree.get("cpp").get("backend").get("senior").put("chicken", new ArrayList<Integer>());
		tree.get("python").get("backend").get("senior").put("chicken", new ArrayList<Integer>());
		tree.get("java").get("frontend").get("senior").put("chicken", new ArrayList<Integer>());
		tree.get("cpp").get("frontend").get("senior").put("chicken", new ArrayList<Integer>());
		tree.get("python").get("frontend").get("senior").put("chicken", new ArrayList<Integer>());
		
		tree.get("java").get("backend").get("senior").put("pizza", new ArrayList<Integer>());
		tree.get("cpp").get("backend").get("senior").put("pizza", new ArrayList<Integer>());
		tree.get("python").get("backend").get("senior").put("pizza", new ArrayList<Integer>());
		tree.get("java").get("frontend").get("senior").put("pizza", new ArrayList<Integer>());
		tree.get("cpp").get("frontend").get("senior").put("pizza", new ArrayList<Integer>());
		tree.get("python").get("frontend").get("senior").put("pizza", new ArrayList<Integer>());
		
		
		int[] answer = new int[query.length];
		Object o = null;
		for (int i = 0; i < query.length; i++) {
			String[] s = query[i].split(" ");
			for (int j = 0; j < s.length; j++) {
				if(s[i].equals("and")) continue;
				o = tree.get(s[i]);
			}
		}
		// 언어, 직군, 경력, 소울, 점수

		return answer;
	}
}