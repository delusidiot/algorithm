package recursion;

public class StringLength {

	public static void main(String[] args) {
		System.out.println(stringLength("test"));
	}
	public static int stringLength(String str) {
		if(str.equals(""))
			return 0;
		else
			return 1+stringLength(str.substring(1));
	}
}
