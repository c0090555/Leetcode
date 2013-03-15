public class ImplementstrStr {
	public String strStr(String haystack, String needle) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (needle.length() == 0)
			return haystack;
		if (haystack.length() < needle.length())
			return null;
		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			if (haystack.substring(i).startsWith(needle)) {
				return haystack.substring(i);
			}

		}
		return null;

	}

}
