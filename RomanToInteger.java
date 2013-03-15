
import java.util.*;

public class RomanToInteger {
	public int romanToInt(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s.length() == 0) {
			return 0;
		}
		Hashtable<Character, Integer> hash = new Hashtable<Character, Integer>();
		hash.put('I', 1);
		hash.put('V', 5);
		hash.put('X', 10);
		hash.put('L', 50);
		hash.put('C', 100);
		hash.put('D', 500);
		hash.put('M', 1000);
		if (s.length() == 1) {
			return hash.get(s.charAt(0));
		}
		int sum = 0;
		int i = 0;
		while (i < s.length() - 1) {
			if (hash.get(s.charAt(i)) < hash.get(s.charAt(i + 1))) {
				sum += hash.get(s.charAt(i + 1)) - hash.get(s.charAt(i));
				i += 2;
			} else {
				sum += hash.get(s.charAt(i));
				i++;
			}
		}
		if (hash.get(s.charAt(s.length() - 2)) >= hash
				.get(s.charAt(s.length() - 1))) {
			sum += hash.get(s.charAt(s.length() - 1));
		}

		return sum;

	}
}
