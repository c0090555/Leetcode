//Traverse from left top corner to bottom right corner and try to find the maximal rectangle with the fixed left top point
//The naive method take O(m^2*n^2) time complexity
//This can be improved to O(m^2*n) by doing the following optimization:
//pre-compute the consecutive 1s in the scanning direction, for example:
//Before:
//0000
//1110
//1100
//0110
//After:
//0000
//3210
//2100
//0210

public class MaximumRectangle {
	public int maximalRectangle(char[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m = matrix.length;// length
		int n = m == 0 ? 0 : matrix[0].length; // width
		int max = 0;
		// pre-compute the matrix
		int[][] newMatrix = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = n - 1; j >= 0; j--) {
				if (matrix[i][j] == '1') {
					newMatrix[i][j] = j < n - 1 ? newMatrix[i][j + 1] + 1 : 1;
				} else {
					newMatrix[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				max = Math.max(max, maxArea(newMatrix, i, j));
				// System.out.println("max: "+max);
				// System.out.println("i: "+i+"j: "+j+"max: "+max);
			}
		}
		return max;

	}

	public int maxArea(int[][] newMatrix, int lx, int ly) {
		if (lx < 0 || lx > newMatrix.length || ly < 0
				|| ly > newMatrix[0].length) {
			return -1;
		}
		int m = newMatrix.length;// length
		int area = 0;
		int rx = lx;
		int ry = ly + newMatrix[rx][ly] - 1;
		while (rx < m - 1 && newMatrix[rx][ly] >= 1) {// go down until we reach
														// the second last one
														// or we meet a '0'
			area = Math.max(area, (ry - ly + 1) * (rx - lx + 1));
			rx++;// update rx
			ry = Math.min(ry, ly + newMatrix[rx][ly] - 1);//update ry
		}
		if (newMatrix[rx][ly] >= 1)// update the last one if necessary
			area = Math.max(area, (ry - ly + 1) * (rx - lx + 1));

		return area;
	}

	public static void main(String[] args) {
		MaximumRectangle o = new MaximumRectangle();
		char[][] x = { { '1', '0', '0' }, { '1', '1', '1' } };
		System.out.println(o.maximalRectangle(x));
	}
}
