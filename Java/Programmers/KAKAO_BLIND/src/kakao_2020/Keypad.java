package kakao_2020;

import java.util.HashMap;
import java.util.Map;

public class Keypad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		Keypad k = new Keypad();
		System.out.println(k.solution(numbers, hand));
	}
	public String solution(int[] numbers, String hand) {
		// 1 2 3
		// 4 5 6 
		// 7 8 9
		// * 0 #
		StringBuilder answer = new StringBuilder();
		Map<Integer, Coordinate> map = new HashMap<Integer, Coordinate>();
		for (int i = 0; i < 12; i++) {
			if(i != 10) {
				map.put(i+1, new Coordinate(i%3, i/3));
			}else {
				map.put(0, new Coordinate(i%3, i/3));
			}
		}
		int lefthand = 10; // *
		int righthand = 12; //#
		for (int i = 0; i < numbers.length; i++) {
			switch (numbers[i]) {
			case 1:
			case 4:
			case 7:
				lefthand = numbers[i];
				answer.append("L");
				break;
			case 3:
			case 6:
			case 9:
				righthand = numbers[i];
				answer.append("R");
				break;
			default:
				Coordinate now = map.get(numbers[i]);
				Coordinate preLeft = map.get(lefthand);
				Coordinate preRight = map.get(righthand);
				int leftDist = Math.abs(now.x-preLeft.x) + Math.abs(now.y - preLeft.y);
				int rightDist = Math.abs(now.x-preRight.x) + Math.abs(now.y - preRight.y);
				if(leftDist < rightDist) {
					lefthand = numbers[i];
					answer.append("L");
				}else if(leftDist > rightDist) {
					righthand = numbers[i];
					answer.append("R");
				}else {
					switch (hand) {
					case "left":
						lefthand = numbers[i];
						answer.append("L");
						break;
					case "right":
						righthand = numbers[i];
						answer.append("R");
						break;
					default:
						break;
					}
					break;
				}
			}
		}
		return answer.toString();
	}
}
class Coordinate{
	int x;
	int y;
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "Coordinate [x=" + x + ", y=" + y + "]";
	}
}
