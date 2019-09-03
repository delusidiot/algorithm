import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_8983 {
	public static BufferedReader br;
	public static BufferedWriter bw;
	public static class Animal implements Comparable<Animal>{
		int x;
		int y;
		public Animal(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		public int compareTo(Animal o) {
			if(this.x==o.x)return this.y-o.y;
			return this.x-o.x;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.x+" "+this.y;
		}
	}
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int M = 0;
		int N = 0;
		int L = 0;
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		M = Integer.parseInt(st.nextToken());// 발사대 수
		N = Integer.parseInt(st.nextToken());// 동물의 수
		L = Integer.parseInt(st.nextToken());// 사거리
		int[] launchPad2 = new int[M];
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < M; i++) {
			int idx = Integer.parseInt(st.nextToken());
			launchPad2[i] = idx;
		}
		Arrays.sort(launchPad2);
		Animal[] animal = new Animal[N];
		for (int i = 0; i < animal.length; i++) {
			st = new StringTokenizer(br.readLine()," ");
			animal[i]=new Animal(Integer.parseInt(st.nextToken()),
								  Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(animal);
		int count = 0;
		for (int i = 0; i < animal.length; i++) {
			int stand = animal[i].x;
			int idx =0;
			while(idx<launchPad2.length&&stand>launchPad2[idx]) {
				idx++;
			}
			if(L>=Math.abs(launchPad2[idx]-animal[i].x)+animal[i].y) {
				count++;
			}else {
				while(idx>0&&stand<=launchPad2[idx]) {
					idx--;
				}
				if(L>=Math.abs(animal[i].x-launchPad2[idx])+animal[i].y) {
					count++;
				}
			}
		}
		bw.write((count)+"\n");
		br.close();
		bw.close();
	}
}
