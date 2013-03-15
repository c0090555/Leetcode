//only the previous line will affect the value of current line

import java.util.*;

public class PascalTriangleII {
	public ArrayList<Integer> getRow(int rowIndex) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> currentLine = new ArrayList<Integer>();
		ArrayList<Integer> prevLine = new ArrayList<Integer>();

		if (rowIndex < 0) {
			return new ArrayList<Integer>();
		} else if (rowIndex == 0) {
			currentLine.add(1);
			return currentLine;
		} else {
			prevLine.add(1);// line 1
			for (int i = 1; i <= rowIndex; i++) {
				currentLine = new ArrayList<Integer>();
				currentLine.add(1);
				for (int j = 1; j <= i - 1; j++) {
					int currentElement = prevLine.get(j - 1) + prevLine.get(j);
					currentLine.add(currentElement);
				}
				currentLine.add(1);
				prevLine = currentLine;
			}
			return currentLine;
		}

	}

	public static void main(String[] args) {
		PascalTriangleII o = new PascalTriangleII();
		System.out.println(o.getRow(1));
	}
}
