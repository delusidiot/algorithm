package algorithmTest;

public class Trie {
	private TrieNode rootNode;
	
	public Trie() {
		rootNode = new TrieNode();
	}
	
	public void insert(String word) {
		TrieNode thisNode = this.rootNode;
		for (int i = 0; i < word.length(); i++) {
			thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
		}
		thisNode.setLastChar(true);
	}
	public int count(String word) {
		TrieNode thisNode = this.rootNode;
		int flag = 0;
		int lastChar = 0;
		TrieNode node = null;
		for (int i = 0; i < word.length(); i++) {
			char character = word.charAt(i);
			node = thisNode.getChildNodes().get(character);
			if(thisNode.getChildNodes().size() > 1) {
				flag = i+1;
			}
			if(i!=word.length()-1 && thisNode.isLastChar()) {
				lastChar = i+1;
			}
			if(i == word.length()-1) {
				if(node.getChildNodes().size()>0)
					flag = i+1;
				if(thisNode.isLastChar())
					flag = i+1;
			}
			thisNode = node;
		}
		if(flag==word.length())
			return flag;
		else if(flag == 0)
			return word.length();
		if(flag > lastChar) {
			return flag;
		}else {
			return lastChar;
		}
	}
	public boolean contains(String word) {
		TrieNode thisNode=this.rootNode;
		
		for (int i = 0; i < word.length(); i++) {
			char character = word.charAt(i);
			TrieNode node = thisNode.getChildNodes().get(character);
			
			if(node == null) {
				return false;
			}
			thisNode = node;
		}
		return thisNode.isLastChar();
	}
	public void delete(String word) {
		delete(this.rootNode,word,0);
	}
	private void delete(TrieNode thisNode, String word, int index) {
		char character = word.charAt(index);
		
		if(!thisNode.getChildNodes().containsKey(character)) {
			throw new Error("There is no [" + word +"]in this Trie");
		}
		TrieNode childNode = thisNode.getChildNodes().get(character);
		index++;
		
		if(index == word.length()) {
			if(!childNode.isLastChar()) {
				throw new Error("There is no [" + word +"]in this Trie");
			}
			childNode.setLastChar(false);
			if(childNode.getChildNodes().isEmpty())
				thisNode.getChildNodes().remove(character);
		}
		else {
			delete(childNode,word,index);
			if(!childNode.isLastChar() && childNode.getChildNodes().isEmpty())
				thisNode.getChildNodes().remove(character);
			
		}
		
	}
	public static void main(String[] args) {
		Trie trie = new Trie();
		//String[] words = {"go", "gone", "guild"};
		//String[] words = {"abc", "def", "ghi", "jklm"};
		//String[] words = {"word", "war", "warrior", "world"};
		//String[] words = {"abc", "abcd", "abcdef", "abcdefgh"};
//		String[] words = {"abcef", "abcd", "abcdef", "abcdeegh","abceef",
//				"bbcef", "bbcd", "bbcdef", "bbcdeegh","bbceef"};
//		String[] words = {"ab","abc","abcd","abcef","abcefg"};
		String[] words = {"aaaaa","aaaab","aaabb","aabbb","abbbb"};
		for (String w : words) {
			trie.insert(w);
		}
		for (String w : words) {
			System.out.println(trie.count(w));
		}
	}

}

