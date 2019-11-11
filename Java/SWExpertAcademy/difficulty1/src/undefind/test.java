package undefind;

import java.util.HashSet;
import java.util.Set;

public class test {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(3);
		set2.add(4);
		set2.add(2);
		set2.add(3);
		System.out.println(set.retainAll(set2));
		System.out.println(set);
	}
	
}
