import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main_1828 {
	public static class Temperature implements Comparable<Temperature>{
		int low;
		int height;
		public Temperature(int low, int height) {
			super();
			this.low = low;
			this.height = height;
		}
		@Override
		public String toString() {
			return "Temperature [low=" + low + ", height=" + height + "]";
		}
		public int compareTo(Temperature o) {
			if(this.height==o.height)
				return this.low-o.low;
			return this.height-o.height;
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int count = 1;
		ArrayList<Temperature> list = new ArrayList();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			list.add(new Temperature(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(list);
//		for (int i = 0; i < N; i++) {
//			System.out.println(list.get(i));
//		}
		Iterator<Temperature> it = list.iterator();
		Temperature t = it.next();
//		System.out.println("start : " + t);
		while(it.hasNext()) {
			
			while(it.hasNext()) {
				Temperature t2 =it.next();
				if(t.height < t2.low) {
					t=t2;
					count++;
//					System.out.println("change : " + t);
					break;
				}
			}
		}
		
		bw.write(count+"\n");
		bw.close();
	}
}
