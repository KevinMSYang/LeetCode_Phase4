//Question:22
//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//
//
//Example 1:
//
//Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]
//Example 2:
//
//Input: n = 1
//Output: ["()"]

package Backtracking;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
	List<String> list = new LinkedList<>();
	
    public List<String> generateParenthesis(int n) {
        helper(new StringBuilder(), 0, n);
        return list;
    }
    private void helper(StringBuilder sb, int close, int open) {
    	if (close == 0 && open == 0) {
    		list.add(sb.toString());
    		return;
    	}
    	
    	if (open > 0) {
    		sb.append('(');
    		helper(sb, close+1, open-1);
    		sb.setLength(sb.length()-1);
    	}
    	
    	if (close > 0) {
    		sb.append(')');
    		helper(sb, close-1, open);
    		sb.setLength(sb.length()-1);
    	}
    }
}
