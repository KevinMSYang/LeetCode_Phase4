//Question:47
//Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
//
//		 
//
//Example 1:
//
//Input: nums = [1,1,2]
//Output:
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
//Example 2:
//
//Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

package Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII {
	Set<List<Integer>> set = new HashSet<>();
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		dfs(nums, new boolean[nums.length], new ArrayList<>(), ans);
		return ans;
	}
	
	private void dfs(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> ans) {
		if (path.size() == nums.length) {
			if (set.contains(path)) {
				set.add(new ArrayList<>(path));
				ans.add(new ArrayList<>(path));
			}
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (used[i]) continue;
			
			used[i] = true;
			path.add(nums[i]);
			dfs(nums, used, path, ans);
			path.remove(path.size() -1);
			used[i] = false;
		}
	}
}
