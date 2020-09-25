
public class kakao1 {
	public static void main(String[] args) {
		String new_id = "=.=";
		kakao1 k = new kakao1();
		System.out.println(k.solution(new_id));
	}
	public String solution(String new_id) {
		String lowerNewId = new_id.toLowerCase();
		StringBuilder sb = new StringBuilder();
		char preChar = 'a';
		for (int i = 0; i < lowerNewId.length(); i++) {
			char character = lowerNewId.charAt(i);
			if((character>='0'&&lowerNewId.charAt(i)<='9') || (character>='a'&&lowerNewId.charAt(i)<='z') || character=='-' || character=='_' || character=='.') {
				if(sb.length()==0) {
					if(character=='.') {
						
					}else {
						sb.append(character);
					}
				}
				else {
					if(character=='.' && preChar == character) {
						
					}else {
						sb.append(character);
					}
				}
				preChar = character;
			}
		}
		if(sb.length() > 0 && sb.charAt(sb.length()-1)=='.') {
			sb.deleteCharAt(sb.length()-1);
		}
		if(sb.length() == 0) {
			sb.append("a");
		}
		if(sb.length() <= 2) {
			while(sb.length()!=3) {
				sb.append(sb.charAt(sb.length()-1));
			}
		}
		if(sb.length() >= 16) sb = new StringBuilder(sb.substring(0,15));
		if(sb.charAt(sb.length()-1)=='.') {
			sb.deleteCharAt(sb.length()-1);
		}
        return sb.toString();
    }
}
