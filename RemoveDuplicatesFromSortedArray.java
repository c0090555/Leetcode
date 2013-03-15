//pay attention to the ending part
import java.util.*;

public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A.length == 0) {
			return 0;
		}
		if (A.length == 1) {
			return 1;
		}
		int counter = 0;
		for (int i = 1; i <= A.length - 1; i++) {
			if (A[i] != A[i - 1]) {
				A[counter] = A[i - 1];
				counter++;
			}
		}
		A[counter] = A[A.length - 1];
		counter++;
		A = Arrays.copyOf(A, counter);
		return counter;
	}
}
