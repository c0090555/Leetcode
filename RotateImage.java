public class RotateImage {
	public void rotate(int[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int length = matrix[0].length;
		for (int i = 0; i < length / 2; i++) {
			int first = i;
			int last = length - 1 - i;
			for (int j = first; j < last; j++) {/*
												 * Here j!=last, otherwise the
												 * image will be rotated by 180'
												 */
				int offset = j - first;
				int top = matrix[first][j];

				// left->top
				matrix[first][j] = matrix[last - offset][first];
				// bottom->left
				matrix[last - offset][first] = matrix[last][last - offset];
				// right->bottom
				matrix[last][last - offset] = matrix[j][last];
				// top->right
				matrix[j][last] = top;

			}

		}
		return;

	}
}
