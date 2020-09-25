package kakao_2019;

import java.util.ArrayList;

public class Crain {
	
	public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList<Integer> basket = new ArrayList<>();
        for (int i = 0; i < moves.length; i++) {
			for (int j = 0; j < board[moves[i]-1].length; j++) {
				if(board[j][moves[i]-1] != 0) {
					basket.add(board[j][moves[i]-1]);
					board[j][moves[i]-1] = 0;
					break;
				}
			}
			if(basket.size()>1) {
				if(basket.get(basket.size()-1) == basket.get(basket.size()-2)) {
					basket.remove(basket.size()-1);
					basket.remove(basket.size()-1);
					answer += 2;
				}
			}
		}
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Crain c = new Crain();
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		System.out.println(c.solution(board, moves));
	}

}
