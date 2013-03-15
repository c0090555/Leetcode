// http://en.wikipedia.org/wiki/Permutation
//Find the largest index k such that a[k] < a[k + 1]. If no such index exists, the permutation is the last permutation.
//Find the largest index l such that a[k] < a[l]. Since k + 1 is such an index, l is well defined and satisfies k < l.
//Swap a[k] with a[l].
//Reverse the sequence from a[k + 1] up to and including the final element a[n].
//

public class NextPermutation {
	public void nextPermutation(int[] num) {
		boolean found = false;
		int k = 0;
		int l = 0;

		if (num.length == 0 || num.length == 1) {
			return;
		}
		for (int i = num.length - 2; i >= 0; i--) {
			if (num[i] < num[i + 1]) {
				found = true;
				k = i;
				break;
			}
		}

		if (found == false) {// not found, the permutation is the last one,so
								// the next permutation is the reverse of it
			for (int i = 0; i < num.length / 2; i++) {
				swap(num, i, num.length - 1 - i);
			}
			return;
		}

		for (int i = num.length - 1; i > k; i--) {
			if (num[i] > num[k]) {
				l = i;
				break;
			}
		}

		swap(num, k, l);
		System.out.println(num[0]);
		reverse(num, k + 1, num.length - 1);
		return;

	}

	public void swap(int[] num, int m, int n) {
		int temp = num[m];
		num[m] = num[n];
		num[n] = temp;
	}

	public void reverse(int[] num, int m, int n) {

		int len = n - m + 1;
		for (int i = 1; i <= len / 2; i++) {
			swap(num, m + i - 1, n - i + 1);
		}

	}

	public static void main(String[] args) {
		NextPermutation o = new NextPermutation();
		int[] a = { 2, 2, 7, 5, 4, 3, 2, 2, 1 };
		o.nextPermutation(a);
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i]);

	}

}
