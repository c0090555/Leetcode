//easy

public class RemoveElement {
	public int removeElement(int[] A, int elem) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A.length == 0) {
			return 0;
		}
		int counter = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] != elem) {
				A[counter] = A[i];
				counter++;
			}
		}
		return counter;

	}
}
