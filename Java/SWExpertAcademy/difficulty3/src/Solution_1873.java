import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_1873 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine()+" ");
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			char[][] map = new char[H][W];
			for (int i = 0; i < H; i++) {
				map[i]=br.readLine().toCharArray();
			}
			int tankX = 0;
			int tankY = 0;
			t:for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(map[i][j]=='^'||map[i][j]=='v'||map[i][j]=='<'||map[i][j]=='>') {
						tankX=i;
						tankY=j;
						break t;
					}
				}
			}
			int N = Integer.parseInt(br.readLine());
			char[] order = br.readLine().toCharArray();
			
			
			for (int i = 0; i < order.length; i++) {
				switch(order[i]) {
				case 'U':
					if(tankX>0&&map[tankX-1][tankY]=='.') {
						map[tankX][tankY]='.';
						tankX--;
						map[tankX][tankY]='^';
					}else {
						map[tankX][tankY]='^';
					}
					break;
				case 'D':
					if(tankX<H-1&&map[tankX+1][tankY]=='.') {
						map[tankX][tankY]='.';
						tankX++;
						map[tankX][tankY]='v';
					}else {
						map[tankX][tankY]='v';
					}
					break;
				case 'L':
					if(tankY>0&&map[tankX][tankY-1]=='.') {
						map[tankX][tankY]='.';
						tankY--;
						map[tankX][tankY]='<';
					}else {
						map[tankX][tankY]='<';
					}
					break;
				case 'R':
					if(tankY<W-1&&map[tankX][tankY+1]=='.') {
						map[tankX][tankY]='.';
						tankY++;
						map[tankX][tankY]='>';
					}else {
						map[tankX][tankY]='>';
					}
					break;
				case 'S':
					switch (map[tankX][tankY]) {
					case '^': //x--
						for (int j = tankX-1; j >= 0; j--) {
							if(map[j][tankY]=='#')
								break;
							if(map[j][tankY]=='*') {
								map[j][tankY]='.';
								break;
							}
						}
						break;
					case 'v': //x++
						for (int j = tankX+1; j < H; j++) {
							if(map[j][tankY]=='#')
								break;
							if(map[j][tankY]=='*') {
								map[j][tankY]='.';
								break;
							}
						}

						break;
					case '<': //y--
						for (int j = tankY-1; j >= 0; j--) {
							if(map[tankX][j]=='#')
								break;
							if(map[tankX][j]=='*') {
								map[tankX][j]='.';
								break;
							}
						}

						break;
					case '>': //y++
						for (int j = tankY+1; j < W; j++) {
							if(map[tankX][j]=='#')
								break;
							if(map[tankX][j]=='*') {
								map[tankX][j]='.';
								break;
							}
						}
						break;

					default:
						break;
					}
					break;
				default:
					break;
				}
//				System.out.println("*"+i);
//				for (int j = 0; j < H; j++) {
//					
//					System.out.println(Arrays.toString(map[j]));
//				}
//				System.out.println();
			}
			
			
			bw.write("#"+testCase+" ");
			for (int j = 0; j < H; j++) {
				for (int j2 = 0; j2 < W; j2++) {
					bw.write(map[j][j2]);
				}
				bw.write("\n");
			}
			bw.flush();
		}
		bw.close();
	}
}
