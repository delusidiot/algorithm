import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main_11656 {
	static BufferedReader br;
	static BufferedWriter bw;
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = br.readLine();
		String[] suffix = new String[line.length()];
		for (int i = 0; i < line.length(); i++) {
			suffix[i]=line.substring(i);
		}
		Arrays.sort(suffix);
		for (int i = 0; i < line.length(); i++) {
			bw.write(suffix[i]+"\n");
			bw.flush();
		}
		br.close();
		bw.close();
	}
}
