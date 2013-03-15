//DP
//idea comes from:http://blog.unieagle.net/2012/10/31/leetcode%E9%A2%98%E7%9B%AE%EF%BC%9Atriangle%EF%BC%8C%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92/
//do this using only O(n) extra space, where n is the total number of rows in the triangle. 

import java.util.*;

public class Triangle {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int rows = triangle.size();
		if (rows == 0) {
			return 0;
		}

		int[] minSum = new int[rows];
		for (int i = 0; i < rows; i++) {
			int[] temp = new int[rows];
			ArrayList<Integer> level = triangle.get(i);
			if (level.size() != i + 1) {
				return -1;// input error
			}
			// first element
			temp[0] = level.get(0) + ((i > 0) ? minSum[0] : 0);
			// middle elements
			for (int j = 1; j < i; j++) {
				temp[j] = Math.min(minSum[j - 1], minSum[j]) + level.get(j);
			}
			// last element
			temp[i] = level.get(i) + ((i > 0) ? minSum[i - 1] : 0);

			minSum = temp;// update minSum
			// System.out.println("minSum "+minSum[0]+" "+minSum[1]+" "+minSum[2]);
		}

		// scan minSum and find the smallest value
		int min = Integer.MAX_VALUE;
		for (int k = 0; k < rows; k++) {
			min = Math.min(min, minSum[k]);
		}
		return min;

	}

	public static void main(String[] args) {
		Triangle o = new Triangle();
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		a.add(-1);
		triangle.add(a);
		a = new ArrayList<Integer>();
		a.add(2);
		a.add(3);
		triangle.add(a);
		a = new ArrayList<Integer>();
		a.add(1);
		a.add(-1);
		a.add(-3);
		triangle.add(a);
		// System.out.println(triangle);
		System.out.println(o.minimumTotal(triangle));

	}

}
