import java.util.*;

public class CountAndSay {
	Hashtable<Integer, String> sequenceHash = new Hashtable<Integer, String>();

	public String countAndSay(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n == 1)
			return "1";
		if (n == 2)
			return "11";
		if (n == 3)
			return "21";
		if (n == 4)
			return "1211";
		if (sequenceHash.containsKey(n)) {
			return sequenceHash.get(n);
		}
		sequenceHash.put(n, rotate(countAndSay(n - 1), 2 * (n - 4))
				+ countAndSay(n - 2));
		return rotate(countAndSay(n - 1), 2 * (n - 4)) + countAndSay(n - 2);

	}

	public String rotate(String str, int d) {
		if (d < 0) {
			return null;
		}
		return str.substring(str.length() - d % str.length())
				+ str.substring(0, str.length() - d % str.length());
	}

}
