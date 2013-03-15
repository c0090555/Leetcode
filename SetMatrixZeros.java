//idea comes from: https://github.com/anson627/leetcode/blob/master/SetMatrixZeroes.cpp
//spread zeros to the first row and the first column
//Attention: after setting fristRow and firstCol, start scanning from the second row and the second column

public class SetMatrixZeros {
	public void setZeroes(int[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m = matrix.length;
		int n = matrix[0].length;
		if (m == 0 || n == 0) {
			return;
		}
		boolean firstRow = false;/* indicate whether the first row is all zeros */
		boolean firstCol = false;/*
								 * indicate whether the first column is all
								 * zeros
								 */
		for (int i = 0; i < n; i++) {
			if (matrix[0][i] == 0) {
				firstRow = true;
				break;
			}
		}
		for (int j = 0; j < m; j++) {
			if (matrix[j][0] == 0) {
				firstCol = true;
				break;
			}
		}

		for (int j = 0; j < m; j++) {
			for (int i = 0; i < n; i++) {
				if (matrix[j][i] == 0) {// spread zeros to the first row and the
										// first column
					matrix[0][i] = 0;
					matrix[j][0] = 0;
				}
			}
		}

		for (int j = 1; j < m; j++) {
			for (int i = 1; i < n; i++) {
				if (matrix[j][0] == 0 || matrix[0][i] == 0) {
					matrix[j][i] = 0;
				}
			}
		}

		if (firstRow) {
			for (int i = 1; i < n; i++) {
				matrix[0][i] = 0;
			}
		}
		if (firstCol) {
			for (int j = 1; j < m; j++) {
				matrix[j][0] = 0;
			}
		}

	}
}
