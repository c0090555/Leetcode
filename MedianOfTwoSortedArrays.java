public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int A[], int B[]) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m = A.length;
		int n = B.length;
		if (m == 0 && n == 0) {
			return 0;
		}
		int i = 0;
		int j = 0;
		int s = (m + n) / 2;
		System.out.println(s);
		int m1 = -1;
		int m2 = -1;
		while (s >= 0) {
			int a = (i < m) ? A[i] : Integer.MAX_VALUE;
			int b = (j < n) ? B[j] : Integer.MAX_VALUE;
			m1 = m2;
			if (a < b) {
				m2 = a;
				i++;
			} else {
				m2 = b;
				j++;
			}
			s--;

		}
		if ((m + n) % 2 == 0) {
			return (m1 + m2) / 2.0;
		}
		return m2;
	}

	public static void main(String[] args) {
		MedianOfTwoSortedArrays o = new MedianOfTwoSortedArrays();
		int[] A = {};
		int[] B = {};
		System.out.println(o.findMedianSortedArrays(A, B));
	}

}
