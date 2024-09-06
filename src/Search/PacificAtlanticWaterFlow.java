//Question:417
//There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
//
//The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
//
//The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.
//
//Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
//
// 
//
//Example 1:
//
//
//Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
//Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
//Explanation: The following cells can flow to the Pacific and Atlantic oceans, as shown below:
//[0,4]: [0,4] -> Pacific Ocean 
//       [0,4] -> Atlantic Ocean
//[1,3]: [1,3] -> [0,3] -> Pacific Ocean 
//       [1,3] -> [1,4] -> Atlantic Ocean
//[1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean 
//       [1,4] -> Atlantic Ocean
//[2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean 
//       [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
//[3,0]: [3,0] -> Pacific Ocean 
//       [3,0] -> [4,0] -> Atlantic Ocean
//[3,1]: [3,1] -> [3,0] -> Pacific Ocean 
//       [3,1] -> [4,1] -> Atlantic Ocean
//[4,0]: [4,0] -> Pacific Ocean 
//       [4,0] -> Atlantic Ocean
//Note that there are other possible paths for these cells to flow to the Pacific and Atlantic oceans.
//Example 2:
//
//Input: heights = [[1]]
//Output: [[0,0]]
//Explanation: The water can flow from the only cell to the Pacific and Atlantic oceans.

package Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		int m = heights.length;
		int n = heights[0].length;
		List<List<Integer>> list = new ArrayList<>();
		boolean[][] seenP = new boolean[m][n];
		boolean[][] seenA = new boolean[m][n];
		
		for (int i = 0; i < m; i++) {
			dfs(heights, i, 0, 0, seenP);
			dfs(heights, i, n-1, 0, seenA);
		}
		for (int j = 0; j < n; j++) {
			dfs(heights, 0, j, 0, seenP);
			dfs(heights, m-1, j, 0, seenA);
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (seenA[i][j] && seenP[i][j]) {
					list.add(new ArrayList<>(Arrays.asList(i, j)));
				}
			}
		}
		return list;
	}
	
	private void dfs(int[][] heights, int row, int col, int h, boolean[][] seen) {
		if (row < 0 || row >= heights.length || col < 0 || col >= heights[0].length) return;
		if (seen[row][col] || heights[row][col] < h) return;
		
		seen[row][col] = true;
        dfs(heights, row+1, col, heights[row][col], seen);
        dfs(heights, row-1, col, heights[row][col], seen);
        dfs(heights, row, col+1, heights[row][col], seen);
        dfs(heights, row, col-1, heights[row][col], seen);
	}
}
