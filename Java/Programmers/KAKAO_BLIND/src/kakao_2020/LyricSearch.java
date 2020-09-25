package kakao_2020;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LyricSearch {
	public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        Trie forwardTrie = new Trie();
        Trie backwardTrie = new Trie();
        int[] length = new int[100001];
        for (String word : words) {
        	forwardTrie.frontinsert(word);
        	backwardTrie.backinsert(word);
        	length[word.length()]++;
		}
        int i = 0;
        for (String query : queries) {
        	if(query.charAt(0)!='?')
        		answer[i] = forwardTrie.search(query);
        	else if((query.charAt(query.length()-1)!='?'))
        		answer[i] = backwardTrie.backSearch(query);
        	else {
        		answer[i] = length[query.length()];
        	}
			i++;
		}
        return answer;
    }
	public static void main(String[] args) {
		String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao","aaaaaaa","asldjfqwei"};
		String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?", "?????", "front","a?"};
		LyricSearch l = new LyricSearch();
		System.out.println(Arrays.toString(l.solution(words, queries)));
	}

}
class Trie{
	private TrieNode rootNode = null;
	public Trie() {
		rootNode = new TrieNode();
	}
	public void insert(TrieNode thisNode, String word, int i) {
		if(thisNode.getWordCounter().get(word.length())==null) {
			thisNode.getWordCounter().put(word.length(), 1);
		}
		else {
			thisNode.getWordCounter().computeIfPresent(word.length(), (Integer key, Integer value)-> ++value);
		}
		
		thisNode = thisNode.getChildNode().computeIfAbsent(word.charAt(i),c-> new TrieNode());
	}
	public void frontinsert (String word) {
		TrieNode thisNode = this.rootNode;
		for (int i = 0; i < word.length(); i++) {
			if(thisNode.getWordCounter().get(word.length())==null) {
				thisNode.getWordCounter().put(word.length(), 1);
			}
			else {
				thisNode.getWordCounter().computeIfPresent(word.length(), (Integer key, Integer value)-> ++value);
			}
			
			thisNode = thisNode.getChildNode().computeIfAbsent(word.charAt(i),c-> new TrieNode());
		}
		thisNode.setLastChar(true);
	}
	public void backinsert (String word) {
		TrieNode thisNode = this.rootNode;
		for (int i = word.length()-1; i >= 0; i--) {
			if(thisNode.getWordCounter().get(word.length())==null) {
				thisNode.getWordCounter().put(word.length(), 1);
			}
			else {
				thisNode.getWordCounter().computeIfPresent(word.length(), (Integer key, Integer value)-> ++value);
			}
			thisNode = thisNode.getChildNode().computeIfAbsent(word.charAt(i),c-> new TrieNode());
		}
		thisNode.setLastChar(true);
	}//[3, 2, 4, 1, 0]
	public int search(String query) {
		TrieNode thisNode = this.rootNode;
		int counter = 0;
		for (int i = 0; i < query.length(); i++) {
			if(query.charAt(i)=='?') {
				if(thisNode.getWordCounter().get(query.length()) == null) {
					return 0;
				}
				return thisNode.getWordCounter().get(query.length());
			}
			if(thisNode == null) {
				return 0;
			}
			counter = thisNode.getWordCounter().get(query.length())==null? 0 : thisNode.getWordCounter().get(query.length());
			thisNode = thisNode.getChildNode().get(query.charAt(i));
		}
		return counter;
	}
	public int backSearch(String query) {
		TrieNode thisNode = this.rootNode;
		int counter = 0;
		for (int i = query.length()-1; i >= 0; i--) {
			if(query.charAt(i)=='?') {
				if(thisNode.getWordCounter().get(query.length()) == null) {
					return 0;
				}
				return thisNode.getWordCounter().get(query.length());
			}
			if(thisNode == null) return 0;
			counter = thisNode.getWordCounter().get(query.length())==null? 0 : thisNode.getWordCounter().get(query.length());
			thisNode = thisNode.getChildNode().get(query.charAt(i));
		}
		return counter;
	}
}
class TrieNode{
	private Map<Character, TrieNode> childNode = null;
	private Map<Integer, Integer> wordCounter = null;
	private boolean isLastChar;
	
	public TrieNode() {
		this.childNode = new HashMap<Character, TrieNode>();
		this.wordCounter = new HashMap<Integer, Integer>();
	}
	public Map<Character, TrieNode> getChildNode() {
		return this.childNode;
	}
	public Map<Integer, Integer> getWordCounter() {
		return wordCounter;
	}
	public void setWordCounter(Map<Integer, Integer> wordCounter) {
		this.wordCounter = wordCounter;
	}
	public boolean isLastChar() {
		return this.isLastChar;
	}
	public void setLastChar(boolean isLastChar) {
		this.isLastChar = isLastChar;
	}
}
