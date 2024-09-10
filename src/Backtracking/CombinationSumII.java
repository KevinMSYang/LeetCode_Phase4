//Question:40
//Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
//
//Each number in candidates may only be used once in the combination.
//
//Note: The solution set must not contain duplicate combinations.
//
// 
//
//Example 1:
//
//Input: candidates = [10,1,2,7,6,1,5], target = 8
//Output: 
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]
//Example 2:
//
//Input: candidates = [2,5,2,1,2], target = 5
//Output: 
//[
//[1,2,2],
//[5]
//]

package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumII {
	Set<List<Integer>> set = new HashSet<>();
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(candidates);
		dfs(0, candidates, 0, new ArrayList<>(), target, ans);
		return ans;
	}
	
	private void dfs(int index, int[] candidates, int sum, List<Integer> path, int target, List<List<Integer>> ans) {
		if (sum > target) return;
		if (sum == target) {
			if (!set.contains(path)) {
				set.add(new ArrayList<>(path));
				ans.add(new ArrayList<>(path));
				return;
			}
		}
		
		for (int i = index; i < candidates.length; i++) {
			if (i > index && candidates[i] == candidates[i-1]) continue;
			path.add(candidates[i]);
			dfs(i+1, candidates, sum + candidates[i], path, target, ans);
			path.remove(path.size() -1);
		}
	}
}
