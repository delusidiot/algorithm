package kakao_2020;

import java.util.Arrays;

public class OuterWall {
	static int min;
	public static void main(String[] args) {
		OuterWall o = new OuterWall();
		int n = 12;
		int[] weak = {1, 5, 6, 10};
		int[] dist = {1, 2, 3, 4};
		System.out.println(o.solution(n, weak, dist));
	}
	public int solution(int n, int[] weak, int[] dist) {
		min = Integer.MAX_VALUE;
		Arrays.sort(dist);
		if(dist[dist.length-1]>=n) return 1;
		boolean[] visit = new boolean[weak.length];
        DFS(1, n, weak, dist, visit);
        
        return min==Integer.MAX_VALUE?-1:min;
    }
	public void DFS(int idx, int n, int[] weak, int[] dist, boolean[] visit) {
		if(idx >= min) return;
		if(idx == dist.length) {
			return;
		}
		if(check(visit)) {
			min = min < idx ? min : idx; 
			return;
		}
		for (int i = 0; i < weak.length; i++) {
			if(visit[i]) continue;
			int start = 0, end = 0;
			int count = 0;
			int index = i;
			while(weak[i] != weak[(index + 1) % n]) {// 시계
				index++;
				if((index+1)/n>0) {
					
				}
				else {
					
				}
				if(count < dist[dist.length-idx]) {
					break;
				}
				visit[(index + 1) % n] = true;
			}
			DFS(idx+1, n, weak, dist, visit); 
			for (int j = 0; j < weak.length; j++) {// 시계
				
			}
		}
	}
	public boolean check(boolean[] visit) {
		boolean result = true;
		for (int i = 0; i < visit.length; i++) {
			if(visit[i]) result =false;
		}
		return result;
	}
}
