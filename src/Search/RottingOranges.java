//Question:994
//You are given an m x n grid where each cell can have one of three values:
//
//0 representing an empty cell,
//1 representing a fresh orange, or
//2 representing a rotten orange.
//Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
//
//Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
//
// 
//
//Example 1:
//
//
//Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
//Output: 4
//Example 2:
//
//Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
//Output: -1
//Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
//Example 3:
//
//Input: grid = [[0,2]]
//Output: 0
//Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.

package Search;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOranges {
	public int orangesRotting(int[][] grid) {
		Queue<int[]> q = new ArrayDeque<>();
		
		int freshOranges = 0;
		int ROWS = grid.length;
		int COLS = grid[0].length;
		
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				if (grid[i][j] == 2) {
					q.add(new int[] {i, j});
				}
				else if (grid[i][j] == 1) {
					freshOranges++;
				}
			}
		}
		
		q.add(new int[] {-1, -1});
		int time = -1;
		int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		
		while (!q.isEmpty()) {
			int[] arr = q.poll();
			int row = arr[0];
			int col = arr[1];
			if (row == -1) {
				time++;
				if (!q.isEmpty()) {
					q.add(new int[] {-1, -1});
				}
			}
			else {
				for (int[] d : directions) {
					int neighborRow = row + d[0];
					int neighborCol = col + d[1];
					if (neighborRow >= 0 && neighborRow < ROWS && 
						neighborCol >= 0 && neighborCol < COLS) {
						if (grid[neighborRow][neighborCol] == 1) {
							grid[neighborRow][neighborCol] = 2;
							q.add(new int[] {neighborRow, neighborCol});
							freshOranges--;
						}
					}
				}
			}
		}
		return freshOranges == 0 ? time : -1;
	}
}
