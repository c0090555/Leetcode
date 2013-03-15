//Given two numbers represented as strings, return multiplication of the numbers as a string.
//Note: The numbers can be arbitrarily large and are non-negative.
//We create another two help methods reverse and add 

public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		num1 = reverse(num1);
		num2 = reverse(num2);
		StringBuilder[] cum = new StringBuilder[10];// cum saves the multiple
													// times of num1
		cum[0] = new StringBuilder("0");
		StringBuilder factor = new StringBuilder();
		StringBuilder result = new StringBuilder();
		StringBuilder num1Sb = new StringBuilder(num1);
//		System.out.println("size" + num1Sb.length());
		for (int i = 1; i < 10; i++) {// initializaiton of cum
			cum[i] = add(cum[i - 1], num1Sb);
		}

		for (int i = 0; i < num2.length(); i++) {
			factor = new StringBuilder();
			if (num2.charAt(i) == '0') {// if this digit of num2 is '0', just
										// skip it
				continue;
			} else {

				for (int j = 0; j < i; j++) {
					factor.append("0");
				}
				factor.append(cum[num2.charAt(i) - '0']);

			}
			result = add(result, factor);
		}
		return reverse(result.toString());
	}

	public String reverse(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}

	public StringBuilder add(StringBuilder num1, StringBuilder num2) {
		if (num1.length() == 0 && num2.length() > 0) {
			return num2;
		}
		if (num2.length() == 0 && num1.length() > 0) {
			return num1;
		}
		int sum = 0;
		int carry = 0;
		StringBuilder sb = new StringBuilder();
		int i = 0;
		for (i = 0; i < num1.length() && i < num2.length(); i++) {
			sum = (num1.charAt(i) - '0') + (num2.charAt(i) - '0') + carry;
			carry = sum / 10;
			sum = sum % 10;
			sb.append(String.valueOf(sum));
		}
		if (i < num2.length()) {// if num2 is longer than num1
			num1 = num2;
		}
		for (; i < num1.length(); i++) {
			sum = num1.charAt(i) - '0' + carry;
			carry = sum / 10;
			sum = sum % 10;
			sb.append(String.valueOf(sum));
		}
		if (carry > 0) {
			sb.append(String.valueOf(carry));
		}
		return sb;

	}

	public static void main(String[] args) {
		MultiplyStrings o = new MultiplyStrings();
		System.out.println(o.multiply("5", "1"));
	}
}
