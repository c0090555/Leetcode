public class IntegerToRoman {
	public String intToRoman(int num) {
		StringBuilder roman = new StringBuilder();
		String[] ones = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII",
				"IX" };
		String[] tens = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX",
				"XC" };
		String[] hundreds = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC",
				"DCCC", "CM" };
		String[] thousands = { "", "M", "MM", "MMM" };
		if (num >= 4000 || num <= 0) {
			return null;
		}

		roman.append(thousands[num / 1000]);
		num = num % 1000;
		roman.append(hundreds[num / 100]);
		num = num % 100;
		roman.append(tens[num / 10]);
		num = num % 10;
		roman.append(ones[num]);
		return roman.toString();
	}
}