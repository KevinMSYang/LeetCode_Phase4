//Question:39
//Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
//
//The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the 
//frequency
// of at least one of the chosen numbers is different.
//
//The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
//
// 
//
//Example 1:
//
//Input: candidates = [2,3,6,7], target = 7
//Output: [[2,2,3],[7]]
//Explanation:
//2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
//7 is a candidate, and 7 = 7.
//These are the only two combinations.
//Example 2:
//
//Input: candidates = [2,3,5], target = 8
//Output: [[2,2,2,2],[2,3,3],[3,5]]
//Example 3:
//
//Input: candidates = [2], target = 1
//Output: []

package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	int tar;
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(candidates);
		tar = target;
		dfs(0, candidates, 0, new ArrayList<>(), ans);
		return ans;
	}
	private void dfs(int index, int[] candidates, int sum, List<Integer> path, List<List<Integer>> ans) {
		if (sum > tar) {
			System.out.println("over target " + path);
			return;
		}
		if (sum == tar) {
			ans.add(new ArrayList<>(path));
			System.out.println(path);
			return;
		}
		
		for (int i = index; i < candidates.length; i++) {
			System.out.println("current i " + i);
			System.out.println("add " + candidates[i]);
			path.add(candidates[i]);
			dfs(index, candidates, sum + candidates[i], path, ans);
			System.out.println("backtrack i " + i);
			path.remove(path.size() -1);
			System.out.println("backtrack path " + path);
		}
	}
	
	public static void main(String[] args) {
		CombinationSum cs = new CombinationSum();
		int[] arr = {2, 3,6, 7};
		int target = 7;
		cs.combinationSum(arr, target);
	}
}
