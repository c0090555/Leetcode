/*
 Examples:
 nRows==1:
 12345
 nRows==2:
 135     differences: 2
 246			      2
 nRows==3:
 1 5 9     4 4
 246810    2 4 4 2
 3 7 11    4 4
 nRows==4:
 1  7     13  6 6 
 2 68   1214  4 2 4 2
 35 9 11  15  2 4 2 4 
 4  10    16  6 6
 nRows==5:
 1   9       17   8 8
 2  810    1618   6 2 6 2
 3 7 11   15 19   4 4 4 4
 46  12 14   20   2 6 2 6
 5   13      21   8 8
 
 
 
 */

public class ZigZagConversion {
	public String convert(String s, int nRows) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (s.length() == 0 || nRows == 1 || nRows >= s.length()) {
			return s;
		}
		if (nRows == 0) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		String[] result = new String[nRows];
		int oddDiff = 0;// difference at odd position
		int evenDiff = 0;
		int maxDiff = (nRows - 1) * 2;
		for (int i = 0; i <= nRows - 1; i++) {
			sb = new StringBuilder();
			int startPos = i;
			int k = 0;
			if (i == 0 || i == nRows - 1) {
				oddDiff = maxDiff;
				evenDiff = maxDiff;
			} else {
				oddDiff = 2 * i;
				evenDiff = maxDiff - oddDiff;
			}
			while (startPos <= s.length() - 1) {
				sb.append(s.charAt(startPos));
				if (k % 2 == 0) {
					startPos += evenDiff;
				} else {
					startPos += oddDiff;
				}
				k++;
			}
			result[i] = sb.toString();

		}
		sb = new StringBuilder();
		for (int i = 0; i < result.length; i++) {
			sb.append(result[i]);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		ZigZagConversion o = new ZigZagConversion();
		String s = "PAYPALISHIRING";
		int nRows = 2;
		System.out.println(o.convert(s, nRows));
	}
}
