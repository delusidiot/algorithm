import java.util.*;
import java.util.Map.Entry;


public class Kakao3 {
	public static void main(String[] args) {
		Kakao3 k = new Kakao3();
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		System.out.println(Arrays.toString(k.solution(info, query)));
		
	}
	 public int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		Tree tree = new Tree();
		for (int i = 0; i < info.length; i++) {
			String[] s = info[i].split(" ");
 			tree.insert(s);
		}
		
		System.out.println(tree.rootNode);
		for (int i = 0; i < query.length; i++) {
			String[] s = query[i].split(" ");
			answer[i] = tree.search(s);
		}
		return answer;
	}
}
class Tree{
	TreeNode rootNode;
	public Tree() {
		rootNode = new TreeNode();
	}
	public void insert(String[] s) {
		TreeNode thisNode = this.rootNode;
		for (int i = 0; i < s.length; i++) {
			thisNode = thisNode.childNodes.computeIfAbsent(s[i], c -> new TreeNode());
			if(i == s.length-1) thisNode.counter++;
		}
	}
	public int search(String[] s) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(this.rootNode);
		TreeNode thisNode = this.rootNode;
		int idx = 0;
		int i = 0;
		while(true) {
			int size = q.size();
			if(size == 0 ) return 0;
			if(s[i].equals("and")) {
				i++;
				continue;
			}
			if(idx == 4) break;
			for (int j = 0; j < size; j++) {
				thisNode = q.poll();
				if(thisNode == null) continue;
				if(s[i].equals("-")) {
					for (Entry<String, TreeNode> childs : thisNode.childNodes.entrySet()) {
						q.add(childs.getValue());
					}
				}else {
					q.add(thisNode.childNodes.get(s[i]));
				}
			}
			i++;
			idx++;
		}
		int counter = 0;
		while(!q.isEmpty()) {
			thisNode = q.poll();
			if(thisNode == null) continue;
			for (Entry<String, TreeNode> childs : thisNode.childNodes.entrySet()) {
				System.out.println(Integer.parseInt(s[i]) + " : " + Integer.parseInt(childs.getKey()));
				if(Integer.parseInt(s[i]) <= Integer.parseInt(childs.getKey())) {
					counter += childs.getValue().counter;
				}
			}
		}
		return counter;
	}
}
class TreeNode{
	Map<String, TreeNode> childNodes = null;
	int counter;
	public TreeNode() {
		childNodes = new HashMap<String, TreeNode>();
	}
	@Override
	public String toString() {
		return "childNodes=" + childNodes + ", counter=" + counter + "]";
	}
}
