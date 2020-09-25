package kakao_2020;

import java.util.*;

public class RoadBuilder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = {{0,0,0,0,0,0,0,0},
		                 {0,1,1,1,1,1,1,0},
		                 {0,1,1,1,1,0,0,0},
		                 {0,0,1,1,1,0,1,1},
		                 {1,0,0,1,1,0,0,0},
		                 {1,1,0,1,1,1,1,0},
		                 {1,1,0,0,0,0,0,0},
		                 {1,1,1,1,1,1,1,0}};
		RoadBuilder r = new RoadBuilder();
		System.out.println(r.solution(board));
		for (int i = 0; i < board.length; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
	}
	static int dx[] = {0, 0, -1, 1};
	static int dy[] = {1, -1, 0, 0};
	
    public int solution(int[][] board) {
        int answer = bfs(board.length, 0, 0, 0, -1, board);
        return answer;
    }   
    public int bfs(int n, int x, int y, int cost, int dir, int[][] board) {
    	int min = Integer.MAX_VALUE;
    	Queue<Road> q = new LinkedList<Road>();
    	q.add(new Road(x, y, cost, dir));
    	board[x][y] = 1;
    	while(!q.isEmpty()) {
    		Road temp = q.poll();
    		if(temp.x == n - 1 && temp.y == n - 1) {
    			min = Math.min(min, temp.cost);
    			continue;
    		}
    		for(int i = 0; i < 4; i++) {
    			int nx = temp.x + dx[i];
    			int ny = temp.y + dy[i];
    			if(nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] != 1) {
    				int ncost = 0;
    				// 새로운 지점의 비용구하기.
    				if(temp.dir == -1 || temp.dir == i) {
    					ncost = temp.cost + 100;
    				}else if(temp.dir != i){
    					ncost = temp.cost + 600;
    				}
    				if(board[nx][ny] == 0) {
    					board[nx][ny] = ncost;
    					q.add(new Road(nx, ny, ncost, i));
    				}else if(board[nx][ny] >= ncost) {
    					board[nx][ny] = ncost;
    					q.add(new Road(nx, ny, ncost, i));
    				}
    			}
    		}
    	}
    	return min;
    }
}
class Road{
	int x, y, cost, dir;
	public Road(int x, int y, int cost, int dir) {
		this.x = x;
		this.y = y;
		this.cost = cost;
		this.dir = dir;
	}
}
