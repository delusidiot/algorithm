import java.util.LinkedList;

public class TestClass {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(2,100);
		while (!list.isEmpty()) {
			System.out.print(list.poll()+" ");
		}
		System.out.println();
		
	}

}
