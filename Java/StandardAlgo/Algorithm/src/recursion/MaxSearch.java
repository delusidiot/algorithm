package recursion;

public class MaxSearch {
	public static void main(String[] args) {
		int[] arr = {5,2,1,3};
		System.out.println(maxSearcher1(arr, 0, arr.length-1));
		System.out.println(maxSearcher2(arr, 0, arr.length-1));
	}
	public static int maxSearcher1(int[] data, int begin, int end) {
		if(begin == end)
			return data[begin];
		else return Math.max(data[begin], maxSearcher1(data, begin+1, end));
	}
	public static int maxSearcher2(int[] data, int begin, int end) {
		if(begin == end)
			return data[begin];
		else {
			int middle = (begin + end)/2;
			int max1 = maxSearcher2(data, begin, middle);
			int max2 = maxSearcher2(data, middle+1, end);
			return Math.max(max1, max2);
		}
	}
}
