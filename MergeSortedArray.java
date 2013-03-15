//Given two sorted integer arrays A and B, merge B into A as one sorted array.
//Note:
//You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
//merge B to the end of A, if all elements in B have been merged, then done

public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (m == 0 && n > 0) {
			for (int i = 0; i < n; i++) {
				A[i] = B[i];
			}
			return;
		}
		if (n == 0 && m > 0) {
			return;
		}
		int indexA = m - 1;
		int indexB = n - 1;
		int mergeIndex = m + n - 1;
		while (indexB >= 0) {
			if (indexA < 0) {
				break;
			}
			if (B[indexB] >= A[indexA]) {
				A[mergeIndex] = B[indexB];
				indexB--;
			} else {
				A[mergeIndex] = A[indexA];
				indexA--;
			}
			mergeIndex--;
		}
		if (indexA < 0) {
			for (int i = mergeIndex; i >= 0; i--) {
				A[i] = B[indexB];
				indexB--;
			}
		}

	}
}
