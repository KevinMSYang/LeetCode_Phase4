//Question:200
//Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
//
//An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
//
// 
//
//Example 1:
//
//Input: grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//Output: 1
//Example 2:
//
//Input: grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//Output: 3

package Search;


public class NumberOfIslands {
	final char LAND = '1';
	final char WATER = '0';
	boolean[][] visited;
	char[][] grid;
	
	public int numIslands(char[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		this.visited = new boolean[m][n];
		this.grid = grid;
		int counter = 0;
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == WATER || visited[i][j]) continue;
				
				counter++;
				dfs(i, j);
			}
		}
		return counter;
    }
	
	private void dfs(int row, int col) {
		if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return;
		if (visited[row][col]) return;
		if (grid[row][col] == WATER) return;
		
		visited[row][col] = true;
		
		dfs(row-1, col);
		dfs(row+1, col);
		dfs(row, col-1);
		dfs(row, col+1)
	}
}
