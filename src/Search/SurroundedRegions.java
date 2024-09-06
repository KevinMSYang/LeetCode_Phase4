//Question:130
//You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:
//
//Connect: A cell is connected to adjacent cells horizontally or vertically.
//Region: To form a region connect every 'O' cell.
//Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
//A surrounded region is captured by replacing all 'O's with 'X's in the input matrix board.
//
// 
//
//Example 1:
//
//Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
//
//Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//
//Explanation:
//
//
//In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.
//
//Example 2:
//
//Input: board = [["X"]]
//
//Output: [["X"]]



package Search;

public class SurroundedRegions {
	public void solve(char[][] board) {
		if (board.length == 0) return;
		int m = board.length;
		int n = board[0].length;
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i * j == 0 || i == m -1 || j == n -1) {
					dfs(board, i, j);
				}
			}
		}
		
		for (char[] row : board) {
			for (int i = 0; i < row.length; i++) {
				if (row[i] == '*') {
					row[i] = 'O';
				}
				else if (row[i] == 'O') {
					row[i] = 'X';
				}
			}
		}
	}
	
	private void dfs(char[][] board, int row, int col) {
		if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return;
		if (board[row][col] != 'O') return;
		
		board[row][col] = '*';
		dfs(board, row +1, col);
		dfs(board, row -1, col);
		dfs(board, row, col +1);
		dfs(board, row, col -1);
	}
}
