//DP
import java.util.*;

public class RestoreIPAddresses {
	// solution 1
	public ArrayList<String> restoreIpAddresses(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s.length() == 0) {
			return new ArrayList<String>();
		}
		ArrayList<String> result = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		restoreIpAddressesHelper(s, 0, sb, result, 0);
		return result;
	}

	public void restoreIpAddressesHelper(String s, int index, StringBuilder sb,
			ArrayList<String> result, int counter) {
		// StringBuilder sbLocal = new StringBuilder();
		if (counter > 4) {// to speed up
			return;
		}
		if (index >= s.length()) {
			if (counter == 4) {
				sb.deleteCharAt(sb.length() - 1);// delete '.'
				result.add(sb.toString());
			}
			return;
		}
		if (index <= s.length() - 1) {
			if (isValidIPAddress(s.substring(index, index + 1))) {

				StringBuilder sbLocal = copySB(sb);

				sbLocal.append(s.substring(index, index + 1) + ".");
				restoreIpAddressesHelper(s, index + 1, sbLocal, result,
						counter + 1);
			} else {
				return;
			}
		}
		if (index <= s.length() - 2) {
			if (isValidIPAddress(s.substring(index, index + 2))) {

				StringBuilder sbLocal = copySB(sb);

				sbLocal.append(s.substring(index, index + 2) + ".");
				restoreIpAddressesHelper(s, index + 2, sbLocal, result,
						counter + 1);
			} else {
				return;
			}
		}
		if (index <= s.length() - 3) {
			if (isValidIPAddress(s.substring(index, index + 3))) {
				StringBuilder sbLocal = copySB(sb);
				sbLocal.append(s.substring(index, index + 3) + ".");
				restoreIpAddressesHelper(s, index + 3, sbLocal, result,
						counter + 1);
			} else {
				return;
			}
		}
		return;

	}

	public boolean isValidIPAddress(String s) {
		if (s.length() == 0 || s.length() > 3
				|| (s.charAt(0) == '0' && s.length() != 1)) {
			return false;
		}
		int value = Integer.parseInt(s);
		return value >= 0 && value <= 255;
	}

	public StringBuilder copySB(StringBuilder sb) {
		StringBuilder newsb = new StringBuilder();
		for (int i = 0; i < sb.length(); i++) {
			newsb.append(sb.charAt(i));
		}
		return newsb;
	}

	// solution2
	public ArrayList<String> restoreIpAddresses2(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> result = new ArrayList<String>();
		if (s.length() < 4 || s.length() > 16) {
			return result;
		}
		for (int i = 1; i <= s.length(); i++) {
			if (!isValid(s, 0, i)) {
				break;
			}

			for (int j = i + 1; j <= s.length(); j++) {
				if (!isValid(s, i, j)) {
					break;
				}

				for (int k = j + 1; k <= s.length(); k++) {

					if ((!isValid(s, j, k)) || (!isValid(s, k, s.length()))) {
						continue;
					}
					result.add(s.substring(0, i) + "." + s.substring(i, j)
							+ "." + s.substring(j, k) + "." + s.substring(k));

				}

			}
		}
		return result;

	}

	public boolean isValid(String st, int start, int end) {
		if (start >= end || start < 0 || end > st.length() || st.length() < 4
				|| st.length() > 12) {
			return false;
		}
		if (end - start > 3 || (end - start >= 2 && st.charAt(start) == '0')) {
			return false;
		}
		int num = Integer.parseInt(st.substring(start, end));
		if (num < 0 || num > 255) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		RestoreIPAddresses o = new RestoreIPAddresses();
		System.out.println(o.restoreIpAddresses("19216811"));
	}

}
