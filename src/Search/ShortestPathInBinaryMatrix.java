//Question:1091
//Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.
//
//A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
//
//All the visited cells of the path are 0.
//All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
//The length of a clear path is the number of visited cells of this path.
//
// 
//
//Example 1:
//
//
//Input: grid = [[0,1],[1,0]]
//Output: 2
//Example 2:
//
//
//Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
//Output: 4
//Example 3:
//
//Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
//Output: -1

package Search;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
	public int shortestPathBinaryMatrix(int[][] grid) {
		int n = grid.length;
		if (grid[0][0] == 0 && n == 1) return 1;
		if (grid[0][0] != 0 || grid[n-1][n-1] != 0) return -1;
		
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] seen = new boolean[n][n];
		int[][] direction = {{-1, -1}, {1, 1}, {-1, 0}, {1, 0}, {0, 1}, {0, -1}, {-1, 1}, {1, -1}};
		
		int ans = 0;
		q.add(new int[] {0,0});
		seen[0][0] = true;
		
		while (!q.isEmpty()) {
			ans++;
			for (int size = q.size(); size > 0; size--) {
				int[] cord = q.remove();
				int curRow = cord[0];
				int curCol = cord[1];
				for (int[] dir : direction) {
					int x = dir[0] + curRow;
					int y = dir[1] + curCol;
					if (x < 0 || x >= n || y < 0 || y >= n) continue;
					if (grid[x][y] != 0 || seen[x][y]) continue;
					if (x == n-1 && y == n-1) return ans+1;
					q.add(new int[] {x, y});
					seen[x][y] = true;
				}
			}
		}
		return -1;
	}
}
