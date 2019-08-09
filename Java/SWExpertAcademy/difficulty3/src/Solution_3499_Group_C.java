import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_3499_Group_C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			int cardNumber = Integer.parseInt(br.readLine());//카드갯수
			String card = br.readLine();
			String[] cards = card.split(" ");
			String result = "";
			for (int i = 0; i < cards.length/2; i++) {
				if(cards.length%2==1) {
					result = result + cards[i] +" " +cards[i+(cards.length+1)/2]+" ";
				}
				else {
					result = result + cards[i] +" " +cards[i+cards.length/2]+" ";
				}
			}
			if(cards.length%2==1) {
				result = result + cards[cards.length/2]+" ";
			}
			System.out.println("#"+testCase+" "+ result);
		}
	}
}
