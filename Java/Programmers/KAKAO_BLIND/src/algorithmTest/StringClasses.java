package algorithmTest;

import java.util.StringTokenizer;

public class StringClasses {

	public static void main(String[] args) {
		String s = "100 100 200 200 300";
		StringTokenizer st = new StringTokenizer(s);
		while(st.hasMoreElements()) {
			System.out.println(st.nextToken());
		}
	}

}
