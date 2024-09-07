//Question:17
//Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
//
//A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
//
//
// 
//
//Example 1:
//
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
//Example 2:
//
//Input: digits = ""
//Output: []
//Example 3:
//
//Input: digits = "2"
//Output: ["a","b","c"]

package Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.swing.text.html.HTMLDocument.Iterator;

public class LetterCombinationsOfAPhoneNumber {
	Map<Character, String> map = new HashMap<>() {{
		put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
	}};
	char[] arr;
	List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
    	if (digits.length() == 0) return res;
    	this.arr = digits.toCharArray();
    	Stack<Character> stack = new Stack<>();
    	helper(stack, 0);
    	return res;
    }
    private void helper(Stack<Character> stack, int index) {
    	if (index == arr.length) {
    		res.add(convertStackToString(stack));
    		return;
    	}
    	
    	String curStr = map.get(arr[index]);
    	for (char c : curStr.toCharArray()) {
    		stack.add(c);
    		helper(stack, index +1);
    		stack.pop();
    	}
    }
    
    private String convertStackToString(Stack<Character> stack) {
    	Iterator it = stack.iterator();
    	StringBuilder sb = new StringBuilder();
    	while (it.hasNext()) {
    		sb.append(it.next());
    	}
    	return sb.toString();
    }
}
