import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_16937 {
	public static BufferedReader br;
	public static BufferedWriter bw;
	public static class Sticky{
		int index;
		int R;
		int C;
		public Sticky(int idx,int r, int c) {
			super();
			index = idx;
			R = r;
			C = c;
		}
		public void swap() {
			int temp = R;
			R = C;
			C = temp;
		}
	}
	static int[] p = null;
	static int[] tr = new int[2];
	static Sticky[] sticky = null;
	static int maxSize = 0;
	static boolean[][] paper = null;
	static int H = 0;
	static int W = 0;
	static int N = 0;
	static final int CHOOSE = 2;
	public static void main(String[] args) throws IOException {//여러개 중 단 2개
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()+" ");
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());
		sticky = new Sticky[N];
		for (int i = 0; i < sticky.length; i++) {
			st = new StringTokenizer(br.readLine()+" ");
			sticky[i]= new Sticky(i,Integer.parseInt(st.nextToken()),
									Integer.parseInt(st.nextToken()));
		}
		comb(N,CHOOSE);
		bw.write(maxSize+"\n");
		bw.close();
	}
	public static void glue(boolean[][] paper,int start, int end , int xSize, int ySize) {
		for (int i = start; i < start+xSize; i++) {
			for (int j = end; j < end+ySize; j++) {
				paper[i][j]=(!paper[i][j]);
			}
		}
	}
	public static void comb(int n, int r) {
		if(r==0) {
			boolean check = false;
			int x = H-sticky[tr[0]].R;
			int y = W-sticky[tr[0]].C;
			
			if(x>=sticky[tr[1]].R && W>=sticky[tr[1]].C)
				check = true;
			if(H>=sticky[tr[1]].R && y>=sticky[tr[1]].C)
				check = true;
			
			sticky[tr[1]].swap();
			
			if(x>=sticky[tr[1]].R && W>=sticky[tr[1]].C)
				check = true;
			if(H>=sticky[tr[1]].R && y>=sticky[tr[1]].C)
				check = true;
			
			sticky[tr[1]].swap();
			sticky[tr[0]].swap();
			
			x = H-sticky[tr[0]].R;
			y = W-sticky[tr[0]].C;
			
			if(x>=sticky[tr[1]].R && W>=sticky[tr[1]].C)
				check = true;
			if(H>=sticky[tr[1]].R && y>=sticky[tr[1]].C)
				check = true;
			
			sticky[tr[1]].swap();
			
			if(x>=sticky[tr[1]].R && W>=sticky[tr[1]].C)
				check = true;
			if(H>=sticky[tr[1]].R && y>=sticky[tr[1]].C)
				check = true;
			
			int size = 0;
			
			if(check) {
				size=(sticky[tr[0]].R*sticky[tr[0]].C) + (sticky[tr[1]].R*sticky[tr[1]].C);
			}
			if(maxSize<size)
				maxSize=size;
			return;
		}else if(n<r) {
			return;
		}else {
			tr[r-1]=sticky[n-1].index;
			comb(n-1,r-1);
			comb(n-1,r);
		}
	}
}
