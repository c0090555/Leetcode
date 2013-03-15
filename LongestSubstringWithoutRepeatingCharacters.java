//assume this string only contains letters
//maintain a stack of characters to represent current substring
//use a boolean array map to indicate whether current character is in the array or not (like using a hashtable)

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s.length() == 0) {
			return 0;
		}
		boolean[] map = new boolean[26];
		LinkedList<Character> currentSub = new LinkedList<Character>();
		int maxLen = 0;
		for (int i = 0; i < s.length(); i++) {
//			System.out.println("char " + s.charAt(i));
			if (map[s.charAt(i) - 'a']) {
				while (currentSub.peek() != s.charAt(i)) {
					map[currentSub.peek()-'a']=false;
					currentSub.poll();
				}
				currentSub.poll();
				currentSub.add(s.charAt(i));
			} else {
				currentSub.add(s.charAt(i));
				map[s.charAt(i) - 'a'] = true;
			}
			maxLen = currentSub.size() > maxLen ? currentSub.size() : maxLen;

		}
		return maxLen;

	}

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters o = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(o.lengthOfLongestSubstring("facbadebbbbbbbb"));
	}
}
