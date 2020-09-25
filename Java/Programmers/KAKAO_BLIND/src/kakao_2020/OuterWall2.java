package kakao_2020;

import java.util.Arrays;

public class OuterWall2 {
	static int min;
	public static void main(String[] args) {
		OuterWall2 o = new OuterWall2();
		int n = 12;
		int[] weak = {1, 5, 7, 10};
		int[] dist = {1, 1, 1, 1};
		System.out.println(o.solution(n, weak, dist));
		int[] weak2 = {1, 3, 4, 9, 10};
		int[] dist2 = {3, 5, 7};
		System.out.println(o.solution(n, weak2, dist2));
	}
	public int solution(int n, int[] weak, int[] dist) {
		min = Integer.MAX_VALUE;
		Arrays.sort(dist);
		boolean[] visit = new boolean[n];
        DFS(0, n, weak, dist, visit);
        return min==Integer.MAX_VALUE?-1:min;
    }
	public void DFS(int idx, int n, int[] weak, int[] dist, boolean[] visit) {
		if(idx >= min) return;
		if(check(visit, weak)) {
			min = min < idx ? min : idx; 
			return;
		}
		if(idx == dist.length) {
			return;
		}
		for (int i = 0; i < weak.length; i++) {
			if(visit[weak[i]]) continue;
			boolean[] visitClone = visit.clone();
			for (int j = 0; j < dist[dist.length - idx - 1] + 1; j++) {
				visitClone[(weak[i]+j)%n] = true;
			}
			DFS(idx+1, n, weak, dist, visitClone);
		}
	}
	public boolean check(boolean[] visit, int[] weak) {
		boolean result = true;
		for (int i = 0; i < weak.length; i++) {
			if(!visit[weak[i]]) {
				result =false;
				break;
			}
		}
		return result;
	}
}
