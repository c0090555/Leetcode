//idea comes from:https://github.com/zwxxx/LeetCode/blob/825fe4c23fd108675f4e7d41d0130cb3a556ff3b/Permutation_Sequence.cpp
//For set [1,2,3,...,n], there are a total of n! unique permutations.
//Then we know there are n!/n=(n-1)! permutations start with 1, n!/n=(n-1)!
//permutations start with 2, etc.
//To get the kth permutation, We start by locating the digit from left
//to right.
//For n = 9, there are 362880 unique permutations.
//1 - 40320 starts with 1
//40321 - 80640 starts with 2
//80641 - 120960 starts with 3

//another idea is to do "find the next permutation" operation k-1 times
import java.util.*;

public class PermutationSequence {
	public String getPermutation(int n, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (k > factorial(n) || k <= 0 || n <= 0) {
			return new String();
		}
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> num = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			num.add(i);
		}
		System.out.println("size" + num.size());

		int[] factor = new int[n];// store factorial result to speed up
		for (int i = 0; i <= n - 1; i++) {
			factor[i] = factorial(i);
		}

		// determine the permutation digit by digit
		for (int i = 0; i < n; i++) {
			int f = factor[n - i - 1];
			int j = 0;
			while (j * f < k) {
				j++;
			}
			j--;
			k -= j * f;
			sb.append(String.valueOf(num.get(j)));
			num.remove(j);

		}
		return sb.toString();

	}

	public int factorial(int n) {
		if (n < 0) {
			return -1;
		}
		int result = 1;
		if (n == 0) {
			return 1;
		} else {
			for (int i = 1; i <= n; i++) {
				result = result * i;
			}
			return result;
		}

	}

	public static void main(String[] args) {
		PermutationSequence o = new PermutationSequence();
		System.out.println(o.getPermutation(9, 214267));
	}

}
