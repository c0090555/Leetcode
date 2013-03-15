//Pascal's Triangle example:
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//DP

import java.util.*;

public class PascalTriangle {
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		generate(numRows, result);
		return result;
	}

	public void generate(int numRows, ArrayList<ArrayList<Integer>> result) {
		ArrayList<Integer> level = new ArrayList<Integer>();
		ArrayList<Integer> prevLevel;
		if (numRows <= 0) {
			return;
		}
		if (numRows == 1) {
			// level 1
			level.add(1);
			result.add(level);
		} else if (numRows == 2) {
			// level 1
			level.add(1);
			result.add(level);
			// level 2
			level = new ArrayList<Integer>();
			level.add(1);
			level.add(1);
			result.add(level);
		}
		// for level>=3
		else {
			// level 1
			level.add(1);
			result.add(level);
			// level 2
			level = new ArrayList<Integer>();
			level.add(1);
			level.add(1);
			result.add(level);
			for (int i = 2; i <= numRows - 1; i++) {
				level = new ArrayList<Integer>();
				prevLevel = result.get(i - 1);
				level.add(1);
				for (int j = 1; j <= i - 1; j++) {
					int currentElement = prevLevel.get(j - 1)
							+ prevLevel.get(j);
					level.add(currentElement);
				}
				level.add(1);
				result.add(level);
			}
		}
		return;

	}

	public static void main(String[] args) {
		PascalTriangle o = new PascalTriangle();
		System.out.println(o.generate(10));
	}
}
