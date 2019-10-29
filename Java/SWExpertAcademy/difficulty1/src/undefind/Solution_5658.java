package undefind;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class Solution_5658 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			sc.nextLine();
			LinkedList<Character> chars = new LinkedList<>();
			String line = sc.nextLine();
			for (int i = 0; i < N; i++) {
				chars.add(line.charAt(i));
			}
			int slice = N/4;
			Set<String> set = new HashSet<>();
			for (int i = 0; i < slice; i++) {
				for (int j = 0; j < 4; j++) {
					StringBuffer sb = new StringBuffer();
					for (int k = 0; k < slice; k++) {
						sb.append(chars.get((j*slice)+k));
					}
					set.add(sb.toString());
				}
				char temp = chars.pop();
				chars.add(temp);
			}
			PriorityQueue<String> pq = new PriorityQueue<>();
			Iterator<String> it = set.iterator();
			
			while(it.hasNext()) {
				pq.add(it.next());
			}
			while(pq.size()!=K) {
				pq.poll();
			}
			System.out.println("#"+testCase+" "+hexToInt(pq.poll()));
		}
	}
	public static long hexToInt(String hex) {
		long result = 0;
		long h = 1;
		for (int i = hex.length()-1; i >=0 ; i--) {
			if(hex.charAt(i)<='9') {
				result+=((hex.charAt(i)-'0')*h);
			}else {
				result+=((hex.charAt(i)-'A'+10)*h);
			}
			h*=16;
		}
		return result;
	}
}
