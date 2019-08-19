import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_1001 {
	static BufferedReader br;
	static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		int result = Integer.parseInt(line.split(" ")[0])-Integer.parseInt(line.split(" ")[1]);
		bw.write(String.valueOf(result)+"\n");
		br.close();
		bw.close();
	}
}
