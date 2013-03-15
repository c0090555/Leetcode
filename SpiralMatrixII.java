//Attention: the case when n is odd

public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n < 0) {
			return null;
		}
		if (n == 0) {
			return new int[0][0];
		}
		int curr = 0;// current index of the left upper corner
		int counter = 1;
		int[][] result = new int[n][n];
		while (curr < n / 2) {
			if (n == 1) {
				result[curr][curr] = counter;
				return result;
			}
			// fill the first row
			for (int i = curr; i < n - curr; i++) {
				result[curr][i] = counter;
				counter++;
			}

			// fill the last column
			for (int j = curr + 1; j < n - curr - 1; j++) {
				result[j][n - 1 - curr] = counter;
				counter++;
			}

			// fill the last row
			for (int k = n - 1 - curr; k >= curr; k--) {
				result[n - 1 - curr][k] = counter;
				counter++;
			}
			// fill the first column
			for (int l = n - 1 - curr - 1; l >= curr + 1; l--) {
				result[l][curr] = counter;
				counter++;
			}

			curr++;
		}

		if (n % 2 == 1) {// n is odd
			result[curr][curr] = counter;
		}
		return result;
	}

	public static void main(String[] args) {
		SpiralMatrixII o = new SpiralMatrixII();
		int n = 5;
		int[][] result = new int[n][n];
		result = o.generateMatrix(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}

	}

}
