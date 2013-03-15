//design a one-pass algorithm using only constant space
//use three pointers low,mid,high, which are pointing to '0', '1' and '2' separately

public class SortColors {
	public void sortColors(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A.length == 0) {
			return;
		}
		int low = 0;
		int mid = 0;
		int high = A.length - 1;

		while (mid <= high) {
			if (A[mid] == 0) {
				A[mid] = A[low];
				A[low] = 0;
				low++;
				mid++;
			} else if (A[mid] == 1) {
				mid++;
			} else if (A[mid] == 2) {// Attention: we don't need to increment
										// mid here since A[mid] may be zero
										// after swapping A[mid] and A[high]
				A[mid] = A[high];
				A[high] = 2;
				high--;
			}

		}

	}
}
