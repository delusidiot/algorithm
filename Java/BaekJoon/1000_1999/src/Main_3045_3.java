import java.util.Scanner;

public class Main_3045_3 {
	static Scanner sc;
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		sc = new Scanner(System.in);
		int N = sc.nextInt(); //노드의수
		int M = sc.nextInt(); //연산의 수
		sc.nextLine();
		for (int i = 0; i < N; i++) {
			list.add(i, i+1);
		}
		for (int i = 0; i < N ; i++) {
			System.out.print(list.get(i)+" ");
		}
		for (int i = 0; i < M; i++) {
			String oper = sc.next();
			int moveNode = sc.nextInt();
			int targetNode = sc.nextInt();
			switch (oper) {
			case "A":
				list.operA(moveNode, targetNode);
				break;
			case "B":
				list.operB(moveNode, targetNode);
				break;

			default:
				break;
			}
		}
		for (int i = 0; i < N ; i++) {
			System.out.print(list.get(i)+" ");
		}
		
	}
}

class DoublyLinkedList {
    
    private Node header;
    private int size;
    public DoublyLinkedList(){
        header = new Node(null);
        size=0;
    }
    
    
    private  class Node{
        
        private Object data;
        public Node previousNode;
        public Node nextNode;
        
        Node(Object data){
            
            this.data = data;
            this.previousNode = null;
            this.nextNode = null;
            
        }
    }
    public Object get(int index){
        return getNode(index).data;
    }
    
    private Node getNode(int index){
        
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index : "+index+", Size : " + size);
        }
        
        Node node = header;
        
        // index 가 리스트 size의 중간 앞이면 순차적으로 탐색한다.
        if(index < (size/2)){
            
            for(int i =0; i<=index; i++){
                node = node.nextNode;
            }
            
        }else{
            // index가 리스트 size의 중간보다 뒤면 뒤에서부터 탐색한다.
            for(int i = size; i > index; i--){
                node = node.previousNode;
        
            }
        }
        
        return node;
    }
    public void addFirst(Object data){

    	// 데이터를 담은 새로운 노드 생성
    	Node newNode = new Node(data);    

    	// 새로운 노드가 다음 노드로 첫번째 노드를 가리킨다.
    	newNode.nextNode = header.nextNode;    

    	// 리스트가 비어있지 않으면
    	if(header.nextNode != null){

    		// 첫 노드가 자신의 앞 노드로 새로운 노드를 가리킨다..
    		header.nextNode.previousNode = newNode;

    	}else{    // 리스트가 비어있으면

    		// 헤더가 마지막 노드를 새로운 노드로 가리키도록 한다.
    		header.previousNode = newNode;

    	}

    	// 헤더가 첫번째 노드로 새로운 노드를 가리키도록 한다.
    	header.nextNode = newNode;
    	size++;
    }
    public void add(int index, int data){

    	// index가 0 이면 addFirst() 함수를 호출한다.
    	if(index ==0){

    		addFirst(data);
    		return;
    	}

    	// 삽입할 index 위치의 앞 노드를 가져온다.
    	Node previous = getNode(index-1);

    	// 삽입할 index의 위치의 다음 노드를 가져온다.
    	Node next = previous.nextNode;

    	// data로 새로운 노드 생성
    	Node newNode = new Node(data);

    	// 앞노드가 새로운 노드를 다음노드로 가리킨다.
    	previous.nextNode = newNode;

    	// 새로운 노드가 앞노드를 이전노드로 가리킨다.
    	newNode.previousNode = previous;

    	//새로운 노드의 다음 노드에 다음노드를 지정한다.
    	newNode.nextNode = next;

    	// 삽입 위치가 마지막 위치가 아니면
    	if(newNode.nextNode != null){

    		// 다음 노드가 새로운 노드를 앞노드로 지정한다.
    		next.previousNode = newNode;

    	}else{ // 삽입 위치가 마지막 이면

    		// 헤더가 가리키는 마지막 노드가 새로운 노드가 된다..
    		header.previousNode = newNode;
    	}

    	size++;
    }
    public Object removeFirst(){

    	// 첫번째 노드를 가져온다.
    	Node firstNode = getNode(0);

    	// 헤더가 첫 노드로 두번째 노드를 가리킨다.
    	header.nextNode = firstNode.nextNode;

    	// 리스트가 비어있지 않을 때
    	if(header.nextNode != null){

    		// 두번째 노드가 가리키는 앞 노드는 없다.
    		firstNode.nextNode.previousNode = null;

    	}else{ // 리스트가 비게 되면

    		// 헤더가 가리키는 마지막 노드가 없다.
    		header.previousNode = null;

    	}

    	size--;
    	// 첫번째 노드의 데이터를 반환
    	return firstNode.data;
    }
    public Object remove(int index){

    	if(index<0 || index>=size){
    		throw new IndexOutOfBoundsException("Index : " + index + ", Size : " + size);
    	}else if(index==0){
    		return removeFirst();    // index가 0 이면 첫번째 데이터 제거
    	}

    	// 제거할 index 위치의 노드를 가져온다.
    	Node removeNode = getNode(index);
    	// 제거할 노드의 앞노드를 가져온다.
    	Node previous = removeNode.previousNode;
    	// 제거할 노드의 뒷노드를 가져온다.
    	Node next = removeNode.nextNode;

    	// 앞노드가 다음노드를 다음으로 가리킨다.
    	previous.nextNode = next;

    	// 제거되는 노드가 마지막 노드가 아니면
    	if(next!=null){

    		// 제거 노드의 뒷노드가 앞노드로  제거 노드 앞 노드를 가리킨다.
    		next.previousNode = previous;

    	}else{ // 제거 노드가 마지막 노드면

    		// 헤더가 마지막 노드로 앞노드를 가리킨다.
    		header.previousNode = previous;

    	}

    	size--;

    	// 제거노드의 데이터를 반환
    	return removeNode.data;
    }
    public void operA(int moveData, int targetData) {
    	Node moveNode = null;
    	Node targetNode = null;
		for (int i = 0; i < size; i++) {
			if((Integer)this.getNode(i).data==moveData) {
				moveNode = this.getNode(i);
			}
			if((Integer)this.getNode(i).data==targetData) {
				targetNode = this.getNode(i);
			}
		}
		Node p = moveNode.previousNode;
		p.nextNode = moveNode.nextNode;
		if(moveNode.nextNode==null) {
		}else
			moveNode.nextNode.previousNode = p;
		moveNode.previousNode = targetNode.previousNode;
		moveNode.nextNode = targetNode;
		if(targetNode.previousNode == null) {
		}else
			targetNode.previousNode.nextNode=moveNode;
		targetNode.previousNode = moveNode;
	}
	
	public void operB(int moveNode, int targetNode) {
//		Node moveNode = null;
//    	Node targetNode = null;
//		for (int i = 0; i < size; i++) {
//			if((Integer)this.getNode(i).data==moveData) {
//				moveNode = this.getNode(i);
//			}
//			if((Integer)this.getNode(i).data==targetData) {
//				targetNode = this.getNode(i);
//			}
//		}
//		Node p = moveNode.previousNode;
//		p.nextNode = moveNode.nextNode;
//		moveNode.nextNode.previousNode = p;
//		moveNode.previousNode = targetNode.previousNode;
//		moveNode.nextNode = targetNode;
//		targetNode.previousNode.nextNode=moveNode;
//		targetNode.previousNode = moveNode;
	}

}


////////////////////////////////////////////////////////////////////////////////////////////////


class MyLinkedList{
	//첫번째 노드를 가리키는 필드
	private Node head = null;
	private Node tail = null;
	private int size = 0;
	class Node{
		//데이터가 저장될 필드
		int data;
		//다음 노드를 가리키는 필드
		Node next;
		public Node(int input) {
			this.data = input;
			this.next = null;
		}
		//노드 내용 확인.
		public String toString() {
			return String.valueOf(this.data);
		}
	}
	
	public void addFirst(int input) {
		//노드를 생성
		Node newNode = new Node(input);
		//새로운 노드의 다음 노드로 헤드 지정
		newNode.next = head;
		head = newNode;
		size++;
		if(head.next == null)
			tail = head;
	}
	public void addLast(int input) {
		Node newNode = new Node(input);
		if(size == 0) {
			addFirst(input);
		}else {
			tail.next = newNode;
			tail = newNode;
			size ++;
		}
	}
	//중간에 추가
	Node node(int index) {
		Node x = head;
		for (int i = 0; i < index; i++) {
			x = x.next;
		}
		return x;
	}
	public void add(int k, int input){
	    // 만약 k가 0이라면 첫번째 노드에 추가하는 것이기 때문에 addFirst를 사용합니다.
	    if(k == 0){
	        addFirst(input);
	    } else {
	        Node temp1 = node(k-1);
	        // k 번째 노드를 temp2로 지정합니다.
	        Node temp2 = temp1.next;
	        // 새로운 노드를 생성합니다.
	        Node newNode = new Node(input);
	        // temp1의 다음 노드로 새로운 노드를 지정합니다.
	        temp1.next = newNode;
	        // 새로운 노드의 다음 노드로 temp2를 지정합니다.
	        newNode.next = temp2;
	        size++;
	        // 새로운 노드의 다음 노드가 없다면 새로운 노드가 마지막 노드이기 때문에 tail로 지정합니다.
	        if(newNode.next == null){
	            tail = newNode;
	        }
	    }
	}
	public String toString() {
	    // 노드가 없다면 []를 리턴합니다.
	    if(head == null){
	        return "[]";
	    }       
	    // 탐색을 시작합니다.
	    Node temp = head;
	    String str = "[";
	    // 다음 노드가 없을 때까지 반복문을 실행합니다.
	    // 마지막 노드는 다음 노드가 없기 때문에 아래의 구문은 마지막 노드는 제외됩니다.
	    while(temp.next != null){
	        str += temp.data + ",";
	        temp = temp.next;
	    }
	    // 마지막 노드를 출력결과에 포함시킵니다.
	    str += temp.data;
	    return str+"]";
	}
	
	public void operA() {
		
	}
	
	public void operB() {
		
	}
}
