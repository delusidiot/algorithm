package naver;

public class Solution {
	public static void main(String[] args) {
		String[] emails = {"abc.def@x.com", "abc", "abc@defx", "abc@defx.xyz"};
		System.out.println(solution(emails));
	}
	public static int solution(String[] emails){
		int answer = 0;
		String[] top = {"com", "net","org"};
		for (String e : emails) {
			boolean first = false;
			int i = 0;
			for (i = 0; i < e.length(); i++) {
				if(e.charAt(i)=='@') {
					i++;//@에서 한단계 위
					first = true;
					break;
				}
			}
			boolean second = false;
			int j = i;
			if(first) {
				for (j = i; j < e.length(); j++) {
					if(e.charAt(j)=='@') {
						break;
					}
					if(e.charAt(j)=='.') {
						j++;//.에서 한단계 위로
						second = true;
						break;
					}
				}
			}else {
				continue;
			}
			int k = 0;
			if(second&&e.length()-j==3) {
				int key = -1;
				if(e.charAt(j)=='c') key =0;
				else if(e.charAt(j)=='n') key =1;
				else if(e.charAt(j)=='o') key =2;
				j++;
				last : for (k = j; k < e.length(); k++) {
					if(key==-1) break;
					switch (key) {
					case 0: case 1: case 2:
						if(e.charAt(k)!=top[key].charAt(3-e.length()+k)) break last;
						break;

					default:
						break;
					}
				}
			}else {
				continue;
			}
			if(k==e.length()) answer++;
		}
		return answer;
	}
}
