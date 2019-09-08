import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2999 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int R = 1;
		int C = 0;
		for (int i = 1; i <= input.length(); i++) {
			if(input.length()%i==0) {
				R=i;
				C=input.length()/R;
				if(R>=C) {
					int temp;
					temp =C ;
					C =R;
					R =temp;
					break;
				}
			}
		}
		char[] charactor = input.toCharArray();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(charactor[j*R+i]);
			}
		}
		System.out.println();
	}
}
