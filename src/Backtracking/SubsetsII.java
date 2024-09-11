//Question:90
//Given an integer array nums that may contain duplicates, return all possible 
//subsets
// (the power set).
//
//The solution set must not contain duplicate subsets. Return the solution in any order.
//
// 
//
//Example 1:
//
//Input: nums = [1,2,2]
//Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
//Example 2:
//
//Input: nums = [0]
//Output: [[],[0]]

package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetsII {
	Set<List<Integer>> set = new HashSet<>();
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(nums);
		dfs(0, nums, new ArrayList<>(), ans);
		return ans;
	}
	private void dfs(int index, int[] nums, List<Integer> path, List<List<Integer>> ans) {
		if (!set.contains(path)) {
			set.add(new ArrayList<>(path));
			ans.add(new ArrayList<>(path));
		}
		
		for (int i = index; i < nums.length; i++) {
			path.add(nums[i]);
			dfs(i + 1, nums, path, ans);
			path.remove(path.size() -1);
		}
	}
}
