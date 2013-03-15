//idea: find the first row whose first element is bigger than target
//Attention: matrix may have only one row

public class SearchA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		if (matrix.length == 1) {
			return searchRow(matrix[0], target);
		}
		int row = 0;
		for (row = 0; row < matrix.length; row++) {
			if (matrix[row][0] == target) {
				return true;
			} else if (matrix[row][0] > target) {
				break;
			}
		}
		if (row == 0) {
			return false;
		} else {
			row--;
			return searchRow(matrix[row], target);
		}

	}

	public boolean searchRow(int[] row, int target) {
		if (row.length == 0) {
			return false;
		}
		int start = 0;
		int end = row.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;

			if (row[mid] == target) {
				return true;
			} else if (row[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return false;

	}
}
