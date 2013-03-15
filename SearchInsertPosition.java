//easy
public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A.length == 0) {
			return -1;
		}
		int pos = 0;

		for (pos = 0; pos < A.length; pos++) {
			if (A[pos] == target) {
				return pos;
			}
			if (A[pos] > target) {
				break;
			}
		}

		return pos;

	}
}
