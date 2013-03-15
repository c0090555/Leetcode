import java.util.ArrayList;

public class NQueensII {

	public int totalNQueens(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n <= 0) {
			return 0;
		}
		ArrayList<Integer> result = new ArrayList<Integer>();
		int[] sol = new int[n];// indicate the column numbers of possible
								// solutions(row by row)
		placeQueen(sol, 0, result);
		return result.size();
	}

	public void placeQueen(int[] sol, int row, ArrayList<Integer> result) {
		int n = sol.length;
		if (row == n) {// finish placing all n queens, so print the result
			result.add(1);
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
}
