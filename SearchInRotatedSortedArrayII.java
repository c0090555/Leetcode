//if duplicates allowed, then binary search may not work
//worst case time complexity: O(n)
public class SearchInRotatedSortedArrayII {
	public boolean search(int[] A, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A.length == 0) {
			return false;
		}

		int start = 0;
		int end = A.length - 1;
		int mid;
		while (start <= end) {
			mid = (start + end) / 2;
			if (target == A[mid]) {
				return true;
			}
			if (A[mid] == A[end]) {
				for (int i = start; i <= end; i++) {
					if (A[i] == target) {
						return true;
					}
				}
				return false;

			} else if (A[mid] > A[end]) {// left part sorted
				if (target >= A[start] && target < A[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}

			} else {
				if (target > A[mid] && target <= A[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
			System.out.println("start " + start);
			System.out.println("end " + end);

		}
		return false;

	}

	public boolean search2(int[] A, int target) {
		int start = 0;
		int end = A.length - 1;
		int mid;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (A[mid] == target) {
				return true;
			}
			if (A[start] == A[mid]) {
				if (A[mid] == A[end]) {
					for (int i = start + 1; i <= end - 1; i++) {
						if (A[i] == target) {
							return true;
						}
					}
					return false;

				} else if (A[mid] < A[end]) {// right part sorted
					if (target > A[mid] && target <= A[end]) {
						start = mid + 1;
					} else {
						return false;
					}
				} else {// left part all duplicate
					start = mid + 1;
				}
			} else if (A[start] < A[mid]) {// left part sorted
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

		}
		return false;
	}

	public static void main(String[] args) {
		SearchInRotatedSortedArrayII o = new SearchInRotatedSortedArrayII();
		int[] A = { 1, 1, 3, 1 };
		int target = 3;
		System.out.println(o.search2(A, target));
	}
}
