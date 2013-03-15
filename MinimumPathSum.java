//DP 
public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int[][] matrix = new int[grid.length][grid[0].length];
		minPathSum(grid, 0, 0, matrix);
		return matrix[grid.length - 1][grid[0].length - 1];
	}

	public void minPathSum(int[][] grid, int m, int n, int matrix[][]) {
		if (m > grid.length - 1 || n > grid[0].length - 1) {
			return;
		}
		if (m == 0 && n == 0) {
			matrix[m][n] = grid[m][n];
		} else if (m == 0 && n > 0) {
			matrix[m][n] = matrix[m][n - 1] + grid[m][n];
		} else if (n == 0 && m > 0) {
			matrix[m][n] = matrix[m - 1][n] + grid[m][n];
		} else {
			matrix[m][n] = Math.min(matrix[m][n - 1], matrix[m - 1][n])
					+ grid[m][n];
		}
		if (m < grid.length - 1) {
			minPathSum(grid, m + 1, n, matrix);
		}
		if (n < grid[0].length - 1) {
			minPathSum(grid, m, n + 1, matrix);

		}
		return;

	}
}
