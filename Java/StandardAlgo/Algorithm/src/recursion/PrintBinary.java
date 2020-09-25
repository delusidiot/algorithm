package recursion;

public class PrintBinary {

	public static void main(String[] args) {
		DecaToBinary(4);
	}
	public static void DecaToBinary(int n) {
		if(n<2) System.out.print(n);
		else {
			DecaToBinary(n/2);
			System.out.print(n%2);
		}
	}
}
