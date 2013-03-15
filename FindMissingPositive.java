/*
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.

Solution: keep swapping
 */
public class FindMissingPositive {
	public int firstMissingPositive(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A.length == 0) {// if A is empty, that means '1' is the missing
							// positive
			return 1;
		}

		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0 && (A[i] - 1 < A.length) && A[A[i] - 1] != A[i]) {
				int temp = A[A[i] - 1];
				A[A[i] - 1] = A[i];
				A[i] = temp;
				i--;//continue doing A[i]
			}
		}

		int j = 1;

		while (j <= A.length && A[j - 1] == j) {
			j++;
		}
		return j;

	}

	public static void main(String[] args) {
		FindMissingPositive o = new FindMissingPositive();
		int[] A = { 1 };
		System.out.println(o.firstMissingPositive(A));
	}
}
