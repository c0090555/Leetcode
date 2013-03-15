//user recursion, pay attention to the boundary cases
import java.util.*;

public class SpiralMatrix {
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (matrix.length == 0 || matrix[0].length == 0) {
			return new ArrayList<Integer>();
		}
		ArrayList<Integer> result = new ArrayList<Integer>();
		spiralOrderRecursion(matrix, 0, matrix.length - 1, 0,
				matrix[0].length - 1, result);
		return result;
	}

	public void spiralOrderRecursion(int[][] matrix, int startRow, int endRow,
			int startCol, int endCol, ArrayList<Integer> result) {
		if (startRow > endRow || startCol > endCol) {
			return;
		}

		if (startRow == endRow && startCol == endCol) {// only one element
			result.add(matrix[startRow][startCol]);
			return;
		} else if (startRow == endRow) {// only one row

			for (int i = startCol; i <= endCol; i++) {
				result.add(matrix[startRow][i]);
			}
			return;
		} else if (startCol == endCol) {// only one column
			for (int j = startRow; j <= endRow; j++) {
				result.add(matrix[j][startCol]);
			}
			return;
		}

		// add elements on startRow
		for (int i = startCol; i <= endCol; i++) {
			result.add(matrix[startRow][i]);
		}
		// add elements on endCol
		for (int j = startRow + 1; j <= endRow - 1; j++) {
			result.add(matrix[j][endCol]);
		}
		// add elements on endRow
		for (int k = endCol; k >= startCol; k--) {
			result.add(matrix[endRow][k]);
		}
		// add elements on startCol
		for (int l = endRow - 1; l >= startRow + 1; l--) {
			result.add(matrix[l][startCol]);
		}
		spiralOrderRecursion(matrix, startRow + 1, endRow - 1, startCol + 1,
				endCol - 1, result);

	}

	public static void main(String[] args) {
		SpiralMatrix o = new SpiralMatrix();
		int[][] matrix = { { 2, 3 } };
		ArrayList<Integer> result = new ArrayList<Integer>();
		result = o.spiralOrder(matrix);
		System.out.println(result.size());

	}
}
