//Question:46
//Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
//
//		 
//
//Example 1:
//
//Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//Example 2:
//
//Input: nums = [0,1]
//Output: [[0,1],[1,0]]
//Example 3:
//
//Input: nums = [1]
//Output: [[1]]

package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        dfs(nums, new boolean[nums.length], new ArrayList<>(), ans);
        return ans;
    }
    private void dfs(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> ans) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            System.out.println("DONE");
            return;
        }

        for (int i = 0; i < nums.length; i++) {
        	System.out.println("current i = " + i);
            if (used[i]) continue;
            used[i] = true;
            System.out.println("current used = " + used[0] + ", " + used[1] + ", " + used[2]);
            path.add(nums[i]);
            System.out.println("add " + nums[i]);
            System.out.println("call dfs");
            dfs(nums, used, path, ans);
            System.out.println("back to previous loop, now i = " +i);
            path.remove(path.size() -1);
            
            used[i] = false;
            System.out.println("backtrack used = " + used[0] + ", " + used[1] + ", " + used[2]);
        }
    }
    
    public static void main(String[] args) {
    	Permutations p = new Permutations();
    	int[] nums = {1, 2, 3};
    	p.permute(nums);
    }
}
