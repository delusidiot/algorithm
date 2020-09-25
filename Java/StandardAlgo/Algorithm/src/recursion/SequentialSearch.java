package recursion;

import javax.naming.directory.SearchControls;

public class SequentialSearch {

	public static void main(String[] args) {
		int[] test =  {1,2,3,4,5};
		int target = 5;
		System.out.println(search(test, 0, test.length-1, target));
		System.out.println(search2(test, 0, test.length-1, target));
	}

	public static int search(int[] data, int begin, int end, int target) {
		if(begin>end)return -1;
		else if( target == data[begin]) {
			return begin;
		}
		else return search(data, begin+1, end, target);
	}
	public static int search2(int[] data, int begin, int end, int target) {
		if(begin>end)return -1;
		else {
			int middle = (begin + end)/2;
			if( data[middle]==target) return middle;
			int index = search2(data, begin, middle-1, target);
			if(index != -1)
				return index;
			else
				return search2(data, middle+1, end, target);
		}
	}
}
