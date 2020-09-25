package kakao_2020;

public class StringComp {
	public int solution(String s) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= s.length()/2; i++) {
        	int counter = 1;
        	String now = s.substring(0,i);
        	String next = s.substring(0,i);
        	StringBuilder sb = new StringBuilder();
			for (int j = 0; j <= s.length()/i; j++) {
				int start = j * i;
				int end = i *(j+1) > s.length() ? s.length() : i*(j+1);
				now = next;
				next = s.substring(start,end);
				
				if(now.equals(next)){
					counter ++;
				}else {
					if(counter>1) {
						sb.append(counter);
						sb.append(now);
					}else {
						sb.append(now);
					}
				}
			}
			if(counter>1) {
				sb.append(counter);
				sb.append(next);
			}else {
				sb.append(next);
			}
			min = Math.min(min, sb.length()); 
		}
        return min;
    }
	public static void main(String[] args) {
		StringComp sc = new StringComp();
		String s = "aabbaccc";
		System.out.println(sc.solution(s));
		s="ababcdcdababcdcd";
		System.out.println(sc.solution(s));
		s = "abcabcdede";
		System.out.println(sc.solution(s));
		s = "abcabcabcabcdededededede";
		System.out.println(sc.solution(s));
		s = "xababcdcdababcdcd";
		System.out.println(sc.solution(s));
		

	}

}
