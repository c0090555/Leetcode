/*// Valid Number
// Validate if a given string is numeric.
//
// Some examples:
// "0" => true
// " 0.1 " => true
// "abc" => false
// "1 a" => false
// "2e10" => true
// Note: It is intended for the problem statement to be ambiguous. You should
// gather all requirements up front before implementing one.
 * 
 */
//idea comes from: https://github.com/anson627/leetcode/blob/master/ValidNumber/ValidNumber.cpp
//trim the leading and trailing white spaces first

public class ValidNumber {
	public boolean isNumber(String s) {
		if (s.length() == 0) {
			return false;
		}

		// trim leading and trailing white spaces
		int h = 0;
		int t = 0;
		char c = s.charAt(0);
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (c == ' ') {
				h++;
			} else {
				break;
			}

		}
		if (h == s.length()) {
			return false;
		}
		for (int j = s.length() - 1; j >= h; j--) {
			c = s.charAt(j);
			if (c == ' ') {
				t++;
			} else {
				break;
			}
		}

		// skip leading '+'/'-'
		if (s.charAt(h) == '+' || s.charAt(h) == '-') {
			h++;
		}
		boolean num = false; // is a digit
		boolean dot = false; // is a dot
		boolean e = false; // is a e

		for (int k = h; k <= s.length() - 1 - t; k++) {
			c = s.charAt(k);
			if (c - '0' >= 0 && c - '0' <= 9) {
				num = true;
			} else if (c == '.') {
				if (e || dot) {
					return false;
				}
				dot = true;
			} else if (c == 'e') {
				if (e || !num) {
					return false;
				}
				e = true;
				num = false;
			} else if (c == '+' || c == '-') {
				if (s.charAt(k - 1) != 'e') {
					return false;
				}
			} else {
				return false;
			}

		}
		return num;

	}

	public static void main(String[] args) {
		String s = "+";
		ValidNumber o = new ValidNumber();
		System.out.println(o.isNumber(s));
	}

}
