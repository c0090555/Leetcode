/*idea comes from: https://github.com/zwxxx/LeetCode/blob/825fe4c23fd108675f4e7d41d0130cb3a556ff3b/Scramble_String.cpp
Assume we have a string s1=[0..n], and we scramble at position p, then s1 is split into [0..p] and [p+1..n].
The children of [0..p] must be within[0..p] and the children of [p+1..n] must be within [p+1..n].
Hence if s2 is a scramble of s1, then it must have a point that the half before is within[0..p](or [p+1..n), and the half after
it is within [p+1..n](or [0..p])

Attention: the string doesn't have to be partitioned evenly
Recursion

 */

public class ScrambleString {
	public boolean isScramble(String s1, String s2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s1.length() != s2.length()) {
			return false;
		}
		if (s1.length() == 0) {
			return true;
		}

		if (s1.length() <= 2) {
			return haveSameContent(s1, s2);
		}
		int l = s1.length();
		for (int i = 1; i < l; i++) {
			// System.out.println("a "+haveSameContent(s1.substring(0, i),
			// s2.substring(l-i, l)));
			// System.out.println("b "+haveSameContent(s1.substring(i,
			// l),s2.substring(0, l-i)));
			if (haveSameContent(s1.substring(0, i), s1.substring(0, i))
					&& haveSameContent(s1.substring(i, l), s2.substring(i, l))) {
				// System.out.println("i "+i);
				boolean left = isScramble(s1.substring(0, i),
						s2.substring(0, i));
				boolean right = isScramble(s1.substring(i, l),
						s2.substring(i, l));
				// System.out.println(left+""+right);
				if (left && right) {
					return true;
				}
			} else if (haveSameContent(s1.substring(0, i),
					s2.substring(l - i, l))
					&& haveSameContent(s1.substring(i, l),
							s2.substring(0, l - i))) {// have to make sure two
														// substrings have the
														// same length

				// System.out.println("2i "+i);

				boolean left = isScramble(s1.substring(0, i),
						s2.substring(l - i, l));
				boolean right = isScramble(s1.substring(i, l),
						s2.substring(0, l - i));
				if (left && right) {
					return true;
				}
			}

		}
		return false;

	}

	public boolean haveSameContent(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		if (s1.length() == 0) {
			return true;
		}
		int[] content = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			content[s1.charAt(i) - 'a']++;
		}
		for (int j = 0; j < s2.length(); j++) {
			content[s2.charAt(j) - 'a']--;
			if (content[s2.charAt(j) - 'a'] < 0) {
				return false;
			}
		}
		return true;

	}

	public static void main(String[] args) {
		ScrambleString o = new ScrambleString();
		boolean r = o.isScramble("abab", "aabb");
		System.out.println(r);

	}

}
