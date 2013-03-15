//DFS
//use sol[] to indicate the column numbers of the solution(row by row)

import java.util.*;
//DFS
public class NQueens {
	public ArrayList<String[]> solveNQueens(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n <= 0) {
			return new ArrayList<String[]>();
		}
		ArrayList<String[]> result = new ArrayList<String[]>();
		int[] sol = new int[n];// indicate the column numbers of possible
								// solutions(row by row)
		placeQueen(sol, 0, result);
		return result;
	}

	public void placeQueen(int[] sol, int row, ArrayList<String[]> result) {
		int n = sol.length;
		if (row == n) {// finish placing all n queens, so print the result
			String[] valid = transform(sol);
			result.add(valid);
			return;

		}

		for (int i = 0; i < n; i++) {// try to find a valid column for row
			if (feasible(sol, row, i)) {
				sol[row] = i;
				placeQueen(sol, row + 1, result);
			}
		}
	}

	public boolean feasible(int[] sol, int row, int col) {
		for (int i = 0; i < row; i++) {
			if (sol[i] == col) {// check column
				return false;
			}
			if (row - i == Math.abs(col - sol[i])) {// check diagonal
				return false;
			}
		}
		return true;

	}

	public String[] transform(int[] sol) {
		String[] validResult = new String[sol.length];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < sol.length; i++) {
			sb = new StringBuilder();
			for (int j = 0; j < sol.length; j++) {
				if (j == sol[i]) {
					sb.append("Q");

				} else {
					sb.append(".");
				}
			}
			validResult[i] = sb.toString();

		}
		return validResult;
	}

}
