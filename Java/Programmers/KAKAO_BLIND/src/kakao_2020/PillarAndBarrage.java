package kakao_2020;

import java.util.ArrayList;
import java.util.Arrays;

public class PillarAndBarrage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PillarAndBarrage pab = new PillarAndBarrage();
		int n = 5;
		int[][] build_frame = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
		int[][] result = pab.solution(n, build_frame);
		for (int i = 0; i < result.length; i++) {
			System.out.println(Arrays.toString(result[i]) +":"+i);
		}
		int[][] build_frame2 = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};
		int[][] result2 = pab.solution(n, build_frame2);
		for (int i = 0; i < result2.length; i++) {
			System.out.println(Arrays.toString(result2[i]) +":"+i);
		}
		System.out.println();

	}
	public int[][] solution(int n, int[][] build_frame) {
		boolean[][] pillar = new boolean[n+1][n+1]; // x, y
		boolean[][] barrage = new boolean[n+1][n+1]; // x, y
		for (int i = 0; i < build_frame.length; i++) {
			switch (build_frame[i][2]) {
			case 0:// pillar
				System.out.println("pillar");
				switch (build_frame[i][3]) {
				case 0:// delete
					System.out.println("delete");
					if(build_frame[i][1] < n) {
						if(build_frame[i][0] > 0) {
							if(barrage[build_frame[i][0]-1][build_frame[i][1]+1]) {// left barrage
								if(pillar[build_frame[i][0]-1][build_frame[i][1]] || barrage[build_frame[i][0]-1][build_frame[i][1]]) {
									pillar[build_frame[i][0]][build_frame[i][1]] = false;
								}
							}
						}
						if(barrage[build_frame[i][0]][build_frame[i][1]+1]) {// right barrage
							if(pillar[build_frame[i][0]+1][build_frame[i][1]]) {
								pillar[build_frame[i][0]][build_frame[i][1]] = false;
							}else if(build_frame[i][0] < n && barrage[build_frame[i][0]+1][build_frame[i][1]+1]) {
								pillar[build_frame[i][0]][build_frame[i][1]] = false;
							}
						}
					}else if(build_frame[i][1] == n) {
						if(build_frame[i][0] > 0) {
							if(barrage[build_frame[i][0]-1][build_frame[i][1]+1]) {// left barrage
								if(barrage[build_frame[i][0]-1][build_frame[i][1]]) {
									pillar[build_frame[i][0]][build_frame[i][1]] = false;
								}
							}
						}
						if(barrage[build_frame[i][0]][build_frame[i][1]+1]) {// right barrage
							if(build_frame[i][0] < n && barrage[build_frame[i][0]+1][build_frame[i][1]+1]) {
								pillar[build_frame[i][0]][build_frame[i][1]] = false;
							}
						}
					}
					break;
				case 1:// insert
					System.out.println("insert");
					if(build_frame[i][1] == 0) { //floor
						pillar[build_frame[i][0]][build_frame[i][1]] = true;
					}
					else if(pillar[build_frame[i][0]][build_frame[i][1]-1]) { // pillar
						pillar[build_frame[i][0]][build_frame[i][1]] = true;
					}
					else if(barrage[build_frame[i][0]-1][build_frame[i][1]] || barrage[build_frame[i][0]][build_frame[i][1]] ) { //barrage
						pillar[build_frame[i][0]][build_frame[i][1]] = true;
					}
					break;
				default:
					break;
				}
				break;
			case 1:// barrage
				System.out.println("barrage");
				switch (build_frame[i][3]) {
				case 0:// delete
					System.out.println("delete");
					if(!pillar[build_frame[i][0]][build_frame[i][1]] || !pillar[build_frame[i][0]+1][build_frame[i][1]]) { // pillar
						if(build_frame[i][0] > 0 && barrage[build_frame[i][0]-1][build_frame[i][1]] && pillar[build_frame[i][0]-1][build_frame[i][1]]) { // pillar
							barrage[build_frame[i][0]][build_frame[i][1]] = false;
						}else if(build_frame[i][0] < n-1 && barrage[build_frame[i][0]+1][build_frame[i][1]] && pillar[build_frame[i][0]+2][build_frame[i][1]]) { // pillar
							barrage[build_frame[i][0]][build_frame[i][1]] = false;
						}
					}
					break;
				case 1:// insert
					System.out.println("insert");
					if(build_frame[i][1] == 0) continue;
					if(pillar[build_frame[i][0]][build_frame[i][1]-1]) {// left pillar
						barrage[build_frame[i][0]][build_frame[i][1]] = true;
					}
					else if(build_frame[i][0] < n + 1  && pillar[build_frame[i][0]+1][build_frame[i][1]-1]) {// right pillar
						barrage[build_frame[i][0]][build_frame[i][1]] = true;
					}
					else if(build_frame[i][0] < n + 1 && barrage[build_frame[i][0]-1][build_frame[i][1]] && barrage[build_frame[i][0]+1][build_frame[i][1]]) {
						barrage[build_frame[i][0]][build_frame[i][1]] = true;
					}
					break;
				default:
					break;
				}
				break;
			default:
				break;
			}
		}
        
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				int[] coordinate = new int[3];
				if(pillar[i][j]) {
					coordinate[0] = i;
					coordinate[1] = j;
					coordinate[2] = 0;
					list.add(coordinate);
				}
				if(barrage[i][j]) {
					coordinate[0] = i;
					coordinate[1] = j;
					coordinate[2] = 1;
					list.add(coordinate);
				}
			}
		}
        int[][] answer = new int[list.size()][3];
        int i = 0;
        for (int[] is : list) {
        	answer[i] = is;
			i++;
		}
        return answer;
    }
	boolean check(boolean[][] pillar, boolean[][] barrage, int x, int y) {
		boolean result = true;
		
		return result;
	}
}