//use a long value to save the result in order
//Attention: -Integer.MIN_VALUE=-2147483648

//Internal Error


public class StringToIntegerATOI {
	public int atoi(String str) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (str.length() == 0) {
			return 0;
		}
		long sum = 0;
		int i = 0;
		boolean start = false;
		char c;
		boolean pos = true;
		while (i < str.length()) {
			if (str.charAt(i) != ' ') {
				start = true;
				break;
			}
			i++;
		}
		System.out.println("i1" + i);
		if (start) {
			c = str.charAt(i);
			if (c - '0' >= 0 && c - '0' <= 9) {
				sum += c - '0';
			} else if (c == '+') {
				pos = true;
			} else if (c == '-') {
				pos = false;
			} else {
				return 0;
			}
			i++;

		} else {
			return 0;
		}
		for (int j = i; j < str.length(); j++) {
			c = str.charAt(j);

			if (c - '0' >= 0 && c - '0' <= 9) {
				sum *= 10;
				sum += c - '0';

			} else {
				break;
			}
			if (sum > Integer.MAX_VALUE && pos == true) {
				return Integer.MAX_VALUE;
			} else if (sum > 2147483648.0 && pos == false) {
				return Integer.MIN_VALUE;
			}

		}

		if (pos) {
			return (int) sum;
		} else {
			return -(int) sum;
		}
	}

	public static void main(String[] args) {
		StringToIntegerATOI o = new StringToIntegerATOI();
		System.out.println(o.atoi("-12"));
	}
}
