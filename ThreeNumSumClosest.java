import java.util.*;

public class ThreeNumSumClosest {
	public static ArrayList<Integer> threeNumSumClosest(int[] a, int t) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Arrays.sort(a);
		int difference = Integer.MAX_VALUE;

		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1, k = a.length - 1; j < k;) {
				if (a[i] + a[j] + a[k] == t) {
					result = new ArrayList<Integer>();
					result.add(a[i]);
					result.add(a[j]);
					result.add(a[k]);
					return result;
				} else if (a[i] + a[j] + a[k] < t) {
					int temp =  t - a[i] - a[j]- a[k];
					if (temp < difference) {
						difference=temp;
						result = new ArrayList<Integer>();
						result.add(a[i]);
						result.add(a[j]);
						result.add(a[k]);
					}
					j++;
				} else {
					int temp = a[i] + a[j] + a[k] - t;
					if (temp < difference) {
						difference=temp;
						result = new ArrayList<Integer>();
						result.add(a[i]);
						result.add(a[j]);
						result.add(a[k]);
					}
					k--;
				}
			}
			System.out.println("diff: "+difference);
		}
		return result;

	}

	public static void main(String[] args) {
		int a[] = { 1, 2, -1, 0, 3, 5 };
		ArrayList<Integer> result = threeNumSumClosest(a,11);
		System.out.println(result);
	}

}
