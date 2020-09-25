package kakao_2019;

import java.util.*;

class RoadSearcher {
	public static int idx = 0;
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        Node[] nodes = new Node[nodeinfo.length];
        for(int i = 0; i < nodeinfo.length; i++){
            int[] arr = {nodeinfo[i][0], nodeinfo[i][1], i + 1};
            nodes[i] = new Node(arr);
        }
        System.out.println(Arrays.toString(nodes));
        System.out.println();
        Arrays.sort(nodes, new Comparator<Node>(){
            public int compare(Node n1, Node n2) {
                return (n2.values[1] == n1.values[1]) ? (n1.values[0] - n2.values[0]) : (n2.values[1] - n1.values[1]);
            }
        });
        System.out.println(Arrays.toString(nodes));
        Node root = nodes[0];
        for(int i = 1; i < nodeinfo.length; i++){
            insert(root, nodes[i]);
        }
        idx = 0;
        preOrder(root, answer[0]);
        idx = 0;
        postOrder(root,answer[1]);
        return answer;
    }
    public static void insert(Node root, Node node){
        if(root.values[0] > node.values[0]){
            if (root.left != null){
            	insert(root.left, node);
            }else{
                root.left = node;
            }
        }else{
            if (root.right != null){
            	insert(root.right, node);                
            }else{
                root.right = node;
            }
        }
    }
    public static void preOrder(Node root,int[] list) {
    	list[idx] = root.values[2];
    	idx++;
    	if(root.left != null) {
    		preOrder(root.left, list);
    	}
    	if(root.right != null) {
    		preOrder(root.right, list);
    	}
    }
    public static void postOrder(Node root, int[] list) {
    	if(root.left != null) {
    		postOrder(root.left, list);
    	}
    	if(root.right != null) {
    		postOrder(root.right, list);
    	}
    	list[idx] = root.values[2];
    	idx++;
    }
    public static void main(String[] args) {
    	int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
    	RoadSearcher s = new RoadSearcher();
    	s.solution(nodeinfo);
	}
}
class Node{
	int[] values;
	Node left;
	Node right;
	public Node(int[] values){
        this.values = values;
    }
	@Override
	public String toString() {
		return  values[2]+"";
	}
}

