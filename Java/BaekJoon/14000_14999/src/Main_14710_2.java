import java.util.Scanner;

public class Main_14710_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int W = sc.nextInt();
		int startIdx = 0;
		int checkPoint = 0;
		int max = 0;
		int maxIdx= 0;
		int height = 0;
		int[] map = new int[W];
		for(int i = 0; i<W;i++) {
			map[i]=sc.nextInt();
		}
		
		int result = 0;
		while(checkPoint<W-1) {
			startIdx = checkPoint;
			max = 0;
			maxIdx = 0;
			height = map[startIdx];
			checkPoint = startIdx+1;
			while(checkPoint<W && map[checkPoint]<height) {
				
				if(max<map[checkPoint]) {
					max=map[checkPoint];
					maxIdx=checkPoint;
				}
				if(checkPoint==W-1) {
					checkPoint=maxIdx;
					height=max;
					break;
				}
				checkPoint++;
			}
			while(startIdx<checkPoint-1) {
				startIdx++;
				result+=height-map[startIdx];
			}
			if(startIdx==W-2) {
				checkPoint++;
				break;
			}
			
		}
		System.out.println(result);

	}

}
