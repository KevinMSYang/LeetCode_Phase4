//Question:78
//Given an integer array nums of unique elements, return all possible 
//subsets
// (the power set).
//
//The solution set must not contain duplicate subsets. Return the solution in any order.
//
// 
//
//Example 1:
//
//Input: nums = [1,2,3]
//Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//Example 2:
//
//Input: nums = [0]
//Output: [[],[0]]

package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0, nums, new ArrayList<>(), ans);
        return ans;
    }
    private void dfs(int index, int[] nums, List<Integer> path, List<List<Integer>> ans) {
    	ans.add(new ArrayList<>(path));
    	System.out.println(path);
    	for (int i = index; i < nums.length; i++) {
    		System.out.println("current i " +i);
    		System.out.println("add " + nums[i]);
    		path.add(nums[i]);
    		dfs(i+1, nums, path, ans);
    		System.out.println("back dfs");
    		path.remove(path.size() -1);
    		System.out.println("backtrack " + path);
    	}
    }
    
    public static void main(String[] args) {
    	Subsets ss = new Subsets();
    	int[] nums = {1, 2, 3};
    	ss.subsets(nums);
    }
}
