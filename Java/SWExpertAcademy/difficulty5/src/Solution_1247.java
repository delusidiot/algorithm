import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//시간 초과가 안난다?
public class Solution_1247 {
	static BufferedReader br;
	static BufferedWriter bw;
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			String[] coordinates = br.readLine().split(" ");
			int companyX = Integer.parseInt(coordinates[0]);
			int companyY = Integer.parseInt(coordinates[1]);
			int homeX = Integer.parseInt(coordinates[2]);
			int homeY = Integer.parseInt(coordinates[3]);
			int[] customerX = new int[N];
			int[] customerY = new int[N];
			for (int i = 0; i < customerY.length; i++) {
				customerX[i] = Integer.parseInt(coordinates[2*i+4]);
				customerY[i] = Integer.parseInt(coordinates[2*i+5]);
			}
			min=100000000;
			boolean[] checked = new boolean[N];
			enter(companyX, companyY, customerX, customerY, homeX, homeY, checked, 0,0,0);
			
			
			
			bw.write("#"+testCase+" "+min+"\n");
			bw.flush();
		}
		br.close();
		bw.close();
	}
	public static void enter(int startX, int startY, int[] customerX, int[] customerY,int endX, int endY, boolean[] checked, int depth,int x, int y) {//x, y는 값을 누적
		if(depth == customerX.length) {
			x += Math.abs(startX-endX);
			y += Math.abs(startY-endY);
			if(min>x+y)
				min=x+y;
			return;
		}
		for (int i = 0; i < checked.length; i++) {
			if(!checked[i]) {
				x+=Math.abs(startX-customerX[i]);
				y+=Math.abs(startY-customerY[i]);
				checked[i]=true;
				enter(customerX[i], customerY[i], customerX, customerY, endX, endY, checked, depth+1,x,y);
				x-=Math.abs(startX-customerX[i]);
				y-=Math.abs(startY-customerY[i]);
				checked[i]=false;
			}
		}
	}
}
