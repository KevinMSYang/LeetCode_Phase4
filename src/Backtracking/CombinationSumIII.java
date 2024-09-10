//Question:216
//Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
//
//Only numbers 1 through 9 are used.
//Each number is used at most once.
//Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
//
// 
//
//Example 1:
//
//Input: k = 3, n = 7
//Output: [[1,2,4]]
//Explanation:
//1 + 2 + 4 = 7
//There are no other valid combinations.
//Example 2:
//
//Input: k = 3, n = 9
//Output: [[1,2,6],[1,3,5],[2,3,4]]
//Explanation:
//1 + 2 + 6 = 9
//1 + 3 + 5 = 9
//2 + 3 + 4 = 9
//There are no other valid combinations.
//Example 3:
//
//Input: k = 4, n = 1
//Output: []
//Explanation: There are no valid combinations.
//Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.

package Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumIII {
	Set<List<Integer>> set = new HashSet<>();
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> ans = new ArrayList<>();
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		dfs(0, nums, 0, new ArrayList<>(), ans, k, n);
		return ans;
	}
	
	private void dfs(int index, int[] nums, int sum, List<Integer> path, List<List<Integer>> ans, int k, int n) {
		if (sum > n || path.size() > k) return;
		if (sum == n && path.size() == k) {
			if (!set.contains(path)) {
				set.add(new ArrayList<>(path));
				ans.add(new ArrayList<>(path));
				return;
			}
		}
		
		for (int i = index; i < nums.length; i++) {
			path.add(nums[i]);
			dfs(i+1, nums, sum + nums[i], path, ans, k, n);
			path.remove(path.size() -1);
		}
	}
}
