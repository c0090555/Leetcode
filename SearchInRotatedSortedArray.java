//no duplicates allowed
//key idea: after rotated, half of the new array is sorted
//don't use recursion cause it's too slow
//use iterative approach
//Attention: compare mid value with high value to indicate which half is sorted (to avoid the special case when there are only two elements left)
//otherwise, if we compare mid value with low value, when there are only two elements left, if A[mid]>A[low] is false,that doesn't mean right half is sorted  

public class SearchInRotatedSortedArray {
	public int search(int[] A, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A.length == 0) {
			return -1;
		}
		int start = 0;
		int end = A.length - 1;
		int mid;
		while (start <= end) {
			mid = (start + end) / 2;
			if (A[mid] == target) {
				return mid;
			}
			if (A[mid] >= A[end]) {// left part sorted
				if (target >= A[start] && target < A[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}

			} else {// right part sorted
				if (target > A[mid] && target <= A[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
			System.out.println("Start " + start);
			System.out.println("End " + end);

		}
		return -1;

	}

	public static void main(String[] args) {
		SearchInRotatedSortedArray o = new SearchInRotatedSortedArray();
		int[] A = { 5, 1, 2, 3, 4 };
		System.out.println(o.search(A, 1));
	}

}
