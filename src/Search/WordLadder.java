//Question:127
//A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
//
//Every adjacent pair of words differs by a single letter.
//Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
//sk == endWord
//Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
//
// 
//
//Example 1:
//
//Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
//Output: 5
//Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
//Example 2:
//
//Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
//Output: 0
//Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.

package Search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	Set<String> set;
	Queue<String> q = new LinkedList<>();
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		set = new HashSet<>(wordList);
		if (!set.contains(endWord)) return 0;
		
		int count = 1;
		q.add(beginWord);
		
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String str = q.poll();
				if (str.equals(endWord)) return count;
				visitConnectNode(str);
			}
			count++;
		}
		return 0;
	}
	private void visitConnectNode(String str) {
		char[] charArr = str.toCharArray();
		for (int i = 0; i < charArr.length; i++) {
			char temp = charArr[i];
			for (char c = 'a'; c <= 'z'; c++) {
				charArr[i] = c;
				String newStr = new String(charArr);
				if (set.contains(newStr)) {
					set.remove(newStr);
					q.add(newStr);
				}
			}
			charArr[i] = temp;
		}
	}
}
