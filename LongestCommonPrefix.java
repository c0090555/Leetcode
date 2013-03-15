//using binary tree idea to speed up the process

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (strs.length == 0) {
			return new String();
		}
		return binary(0, strs.length - 1, strs);
	}

	public String commonPrefix(String st1, String st2) {
		if (st1.length() == 0 || st2.length() == 0) {
			return new String();
		}
		int length = Math.min(st1.length(), st2.length());
		int i = 0;
		for (i = 0; i < length; i++) {
			if (st1.charAt(i) != st2.charAt(i)) {
				break;
			}
		}
		return st1.substring(0, i);

	}

	public String binary(int s, int t, String[] strs) {
		if (s > t) {
			return null;
		}
		if (s == t) {
			return strs[s];
		}
		return commonPrefix(binary(s, (s + t) / 2, strs),
				binary((s + t) / 2 + 1, t, strs));
	}

}
