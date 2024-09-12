//Question:79
//Given an m x n grid of characters board and a string word, return true if word exists in the grid.
//
//The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
//
// 
//
//Example 1:
//
//
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
//Output: true
//Example 2:
//
//
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
//Output: true
//Example 3:
//
//
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
//Output: false

package Backtracking;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (dfs(board, word, i, j, 0)) return true;
			}
		}
		return false;
	}
	private boolean dfs(char[][] board, String word, int row, int col, int index) {
		if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
		if (board[row][col] != word.charAt(index) || board[row][col] == '*') return false;
		if (index == word.length() -1) return true;
		
		char temp = board[row][col];
		board[row][col] = '*';
		boolean isExist = dfs(board, word, row + 1, col, index + 1) ||
					      dfs(board, word, row - 1, col, index + 1) ||
					      dfs(board, word, row, col + 1, index + 1) ||
					      dfs(board, word, row, col - 1, index + 1);
		
		board[row][col] = temp;
		return isExist;
	}
}
