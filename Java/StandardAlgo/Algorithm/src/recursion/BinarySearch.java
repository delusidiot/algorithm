package recursion;

public class BinarySearch {
	public static void main(String[] args) {
		String[] test = {"test","what","wow","cool"};
		String input = "wow";
		System.out.println(binarySearch(test, input, 0, test.length-1));
	}
	public static int binarySearch(String[] items, String target, int begin, int end) {
		if(begin>end)
			return -1;
		else {
			int middle = (begin+end)/2;
			int compResult = target.compareTo(items[middle]);
			if(compResult == 0)
				return middle;
			else if( compResult<0)
				return binarySearch(items, target, begin, middle-1);
			else
				return binarySearch(items, target, middle+1, end);
		}
	}
}
