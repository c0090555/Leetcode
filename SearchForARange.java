//similar with BS, the only difference is when we find the target, we don't return the position immediately
//we try to expand the range based on the center of this position

//Internal Error

public class SearchForARange {
	public int[] searchRange(int[] A, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A.length == 0) {
			return new int[] { -1, -1 };
		}

		int[] range = new int[2];
		int start = 0;
		int end = A.length - 1;
		int mid;
		int left = -1;
		int right = -1;

		while (start <= end) {
			System.out.println("start " + start);
			System.out.println("end " + end);
			mid = (start + end) / 2;
			if (A[mid] == target) {
				left = mid;
				right = mid;
				for (int j = mid - 1; j >= 0; j--) {
					if (A[j] != target) {
						left = j + 1;
						break;
					}
				}
				for (int k = mid + 1; k < A.length; k++) {
					if (A[k] != target) {
						right = k - 1;
						break;
					}
				}
				break;
			} else if (target > A[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}

		}
		range[0] = left;
		range[1] = right;
		return range;

	}

	public static void main(String[] args) {
		SearchForARange o = new SearchForARange();
		int[] a = { 1, 2, 2, 3, 4, 4, 4, 5 };
		System.out.println(o.searchRange(a, 4)[0] + ", "
				+ o.searchRange(a, 4)[1]);
	}
}
