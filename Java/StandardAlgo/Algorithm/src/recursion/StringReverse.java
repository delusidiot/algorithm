package recursion;

public class StringReverse {
	public static void main(String[] args) {
		reverse("say good bye");
	}
	public static void reverse(String str) {
		if(str.length()==0)return;
		else {
			reverse(str.substring(1));
			System.out.print(str.charAt(0));
		}
	}
}
