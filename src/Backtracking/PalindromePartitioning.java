//Question:131
//Given a string s, partition s such that every 
//substring
// of the partition is a 
//palindrome
//. Return all possible palindrome partitioning of s.
//
// 
//
//Example 1:
//
//Input: s = "aab"
//Output: [["a","a","b"],["aa","b"]]
//Example 2:
//
//Input: s = "a"
//Output: [["a"]]

package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        dfs(s, 0, new ArrayList<>(), ans);
        return ans;
    }
    private void dfs(String s, int index, List<String> path, List<List<String>> ans) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                path.add(s.substring(index, i + 1));
                dfs(s, i + 1, path, ans);
                path.remove(path.size() -1);
            }
        }
    }
    private boolean isPalindrome(String s, int l, int r) {
        StringBuilder sb = new StringBuilder(s.substring(l , r + 1));
        if (sb.reverse().toString().equals(s.substring(l , r + 1))) return true;
        return false;
    }
}
