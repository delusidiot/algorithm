package naver;

import java.util.Arrays;

public class Solution2 {
	public static void main(String[] args) {
		String[] test = {"######",">#*###","####*#","#<#>>#",">#*#*<","######"};
		System.out.println(solution(test));
	}
	public static int solution(String[] drum){
		int answer = 0;
		char[][] map = new char[drum.length][drum[0].length()];
		for (int i = 0; i < drum.length; i++) {
			map[i]=drum[i].toCharArray();
		}
		for (int i = 0; i < drum.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		for (int i = 0; i < map.length; i++) {
			int count = 0;
			int x = 0;
			int y = i;
			while(count!=2&&x<6&&y<6&&y>=0) {
				switch (map[x][y]) {
				case '*':
					count ++;
				case '#':
					x++;
					break;
				case '>':
					y++;
					break;
				case '<':
					y--;
					break;
				default:
					break;
				}
			}
			if(x==6)answer++;
		}
		return answer;
	}
}
