
public class kakao1_2 {
	public static void main(String[] args) {
		String new_id = "abcdefghijklmn.p";
		kakao1_2 k = new kakao1_2();
		System.out.println(k.solution(new_id));
	}
	public String solution(String new_id) {
		String lowerNewId = new_id.toLowerCase();
		StringBuilder sb = new StringBuilder();
		char preChar = 'a';
		for (int i = 0; i < lowerNewId.length(); i++) {
			char character = lowerNewId.charAt(i);
			if((character>='0'&&lowerNewId.charAt(i)<='9') || (character>='a'&&lowerNewId.charAt(i)<='z') || character=='-' || character=='_' || character=='.') {
				if(character=='.' && preChar == character) {
				}else {
					sb.append(character);
				}
				preChar = character;
			}
		}
		lowerNewId = sb.toString();
		if(!lowerNewId.equals("") && lowerNewId.charAt(0)=='.') {
			lowerNewId = lowerNewId.substring(1, lowerNewId.length()-1);
		}
		if(!lowerNewId.equals("") && lowerNewId.charAt(lowerNewId.length()-1)=='.') {
			lowerNewId = lowerNewId.substring(0, lowerNewId.length()-2);
		}
		if(lowerNewId.length()==0) lowerNewId ="a";
		if(lowerNewId.length()>= 16) {
			lowerNewId = lowerNewId.substring(0, 15);
		}
		if(lowerNewId.charAt(lowerNewId.length()-1)=='.') {
			lowerNewId = lowerNewId.substring(0, lowerNewId.length()-1);
		}
		if(lowerNewId.length()<= 2) {
			while(lowerNewId.length()!=3) {
				lowerNewId = lowerNewId + lowerNewId.charAt(lowerNewId.length()-1);
			}
		}
        return lowerNewId;
    }
}
