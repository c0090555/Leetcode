//char[][] must be 9*9 since it's a Sudoku board
//You may assume that there will be only one unique solution
//similar with N Queen problem, DFS
//idea comes from:https://github.com/anson627/leetcode/blob/master/SudokuSolver/SudokuSolver.cpp

//basic idea is 

import java.util.*;

public class SudokuSolver {
	public void solveSudoku(char[][] board) {
		// Start typing your Java solution below
		// DO NOT write main() function
		solveSudokuRecursion(board, 0, 0);
	}

	public boolean solveSudokuRecursion(char[][] board, int row, int col) {
		Pair res = getNextEmpty(board, row, col);
		if (res == null) {// boundary case
			return true;
		}
		ArrayList<Character> possible = new ArrayList<Character>();
		possible = getPossibleValues(board, res.row, res.col);
		if (possible.size() == 0) {// no valid possible solutions available
			return false;
		}
		for (int i = 0; i < possible.size(); i++) {// try all possible solutions
			board[res.row][res.col] = possible.get(i);
			if (solveSudokuRecursion(board, res.row, res.col))
				return true;
			board[res.row][res.col] = '.';
		}
		return false;
	}

	public Pair getNextEmpty(char[][] board, int row, int col) {
		while (row <= 8 && col <= 8) {
			if (board[row][col] == '.') {
				return new Pair(row, col);
			}
			row = (col == 8) ? row + 1 : row;
			col = (col == 8) ? 0 : col + 1;
		}
		return null;
	}

	public ArrayList<Character> getPossibleValues(char[][] board, int row,
			int col) {
		boolean[] s = new boolean[10];
		ArrayList<Character> possible = new ArrayList<Character>();
		for (int i = 0; i < 9; i++) {
			if (board[i][col] != '.') {// check row
				s[board[i][col] - '0'] = true;
			}
			if (board[row][i] != '.') {// check column
				// System.out.println("row " + row);
				// System.out.println("col " + col);
				// System.out.println("i "+i);
				// System.out.println("value " + board[row][i]);
				//
				// System.out.println("value " + (board[row][i] - '0'));
				s[board[row][i] - '0'] = true;
			}
			char c = board[row / 3 * 3 + i / 3][col / 3 * 3 + i % 3];// *check
																		// its
																		// own
																		// 3*3
																		// square
			if (c != '.') {
				s[c - '0'] = true;
			}

		}
		for (int j = 1; j <= 9; j++) {
			if (!s[j]) {
				possible.add((char) (j + '0'));
				// System.out.println((char) (j + '0'));
			}
		}
		return possible;

	}

	class Pair {
		int row, col;

		Pair(int r, int c) {
			row = r;
			col = c;
		}
	}

	public static void main(String[] args) {
		SudokuSolver o = new SudokuSolver();
		char[][] b = { { '.', '.', '9', '7', '4', '8', '.', '.', '.' },
				{ '7', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '.', '2', '.', '1', '.', '9', '.', '.', '.' },
				{ '.', '.', '7', '.', '.', '.', '2', '4', '.' },
				{ '.', '6', '4', '.', '1', '.', '5', '9', '.' },
				{ '.', '9', '8', '.', '.', '.', '3', '.', '.' },
				{ '.', '.', '.', '8', '.', '3', '.', '2', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '6' },
				{ '.', '.', '.', '2', '7', '5', '9', '.', '.' } };
		o.solveSudoku(b);
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				System.out.print(b[i][j]);
			}
			System.out.println();
		}
	}
}
// ["..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."]