package kakao_2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MatchingScore {

	public static void main(String[] args) {
		MatchingScore m = new MatchingScore();
		String word = "blind";
		String[] pages = {
				"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"
		};
		System.out.println(pages.length);
		System.out.println(m.solution(word, pages));
		word = "Muzi";
		String[] pages2= {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"};
		System.out.println(m.solution(word, pages2));
	}
	public int solution(String word, String[] pages) {
		word=word.toLowerCase();
        int answer = 0;
        Map<String, Scores> match = new HashMap<String, Scores>();
        for (int i = 0; i < pages.length; i++) {
        	String key = "";
        	int idx = 0;
        	while(pages[i].length()>idx) {
        		if(pages[i].charAt(idx)=='<') {
        			idx++;
        			if(key.equals("")) {
        				if(pages[i].substring(idx, idx+4).equals("meta")) {
        					idx+=5;
        					if(pages[i].substring(idx, idx+8).equals("property")) {
        						if(pages[i].substring(idx+10, idx+16).equals("og:url")) {
        							while(!pages[i].substring(idx, idx+7).equals("content")) {
                						idx++;
                					}
                					while(pages[i].charAt(idx)!='"') {
                						idx++;
                					}
                					idx++;
                					int count = 0;
                					while(pages[i].charAt(idx)!='"') {
                						count++;
                						idx++;
                					}
                					key = pages[i].substring(idx-count, idx);
                					match.put(key, new Scores());
                					match.get(key).index = i;
        						}
        						idx++;
        					}
        				}
        			}
        			else {
        				if(pages[i].substring(idx, idx+4).equals("body")) {
        					int backupIdx = idx;
        					while(!pages[i].substring(idx, idx+7).equals("</body>")) {
        						if(word.equals(pages[i].substring(idx,idx+word.length()).toLowerCase())) {
        							if((pages[i].charAt(idx+word.length()) >= 97 && pages[i].charAt(idx+word.length()) <= 122)||
    										(pages[i].charAt(idx+word.length()) >= 65 && pages[i].charAt(idx+word.length()) <= 90)) {
        								
        							}else {
        								if((pages[i].charAt(idx-1) >= 97 && pages[i].charAt(idx-1) <= 122)||
        										(pages[i].charAt(idx-1) >= 65 && pages[i].charAt(idx-1) <= 90)) {
            								
            							}else {
            								match.get(key).basic++;
            							}
        							}
        						}
        						idx++;
        					}
        					idx = backupIdx;
        				}
        				if(pages[i].charAt(idx)=='a') {
        					match.get(key).link++;
        					while(!pages[i].substring(idx, idx+4).equals("href")) {
        						idx++;
        					}
        					while(pages[i].charAt(idx)!='"') {
        						idx++;
        					}
        					idx++;
        					int count = 0;
        					while(pages[i].charAt(idx)!='"') {
        						count++;
        						idx++;
        					}
        					match.get(key).outsideLink.add(pages[i].substring(idx-count, idx));
        				}
        			}
        		}
        		idx++;
        	}
		}
        //4. 외부 링크 -> 마지막에 점수를 넣기위해 ArrayList에
        System.out.println(match);
        double[] board = new double[pages.length];
        for (Map.Entry<String, Scores> entry : match.entrySet()) {
			board[entry.getValue().index] += entry.getValue().basic;
			double out = (double)entry.getValue().basic / entry.getValue().link;
			Iterator<String> it = entry.getValue().outsideLink.iterator();
			while(it.hasNext()) {
				String s = it.next();
				if(match.get(s)!=null)
					board[match.get(s).index]+=out;
			}
		}
        System.out.println(Arrays.toString(board));
        double max = 0;
        for (int j = 0; j < board.length; j++) {
        	if(max < board[j]) {
        		max = board[j];
        		answer = j;
        	}
		}
        return answer;
    }
}
class Scores{
	int index;
	int basic;
	int link;
	ArrayList<String> outsideLink;
	public Scores() {
		outsideLink = new ArrayList<String>();
	}
	@Override
	public String toString() {
		return "Scores [index=" + index + ", basic=" + basic + ", link=" + link + ", outsideLink=" + outsideLink + "]";
	}
}
