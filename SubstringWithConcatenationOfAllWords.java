//iterative search
import java.util.*;

public class SubstringWithConcatenationOfAllWords {
	public ArrayList<Integer> findSubstring(String S, String[] L) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (S.length() == 0 || L.length == 0
				|| L[0].length() * L.length > S.length()) {
			return new ArrayList<Integer>();
		}
		ArrayList<Integer> result = new ArrayList<Integer>();
		Hashtable<String, Integer> hash = new Hashtable<String, Integer>();
		for (int i = 0; i < L.length; i++) {
			if (!hash.containsKey(L[i])) {
				hash.put(L[i], 1);
			} else {
				int counter = hash.get(L[i]);
				counter++;
				hash.put(L[i], counter);
			}
		}
		System.out.println(hash);

		int len = L[0].length();

		for (int j = 0; j <= S.length() - L[0].length() * L.length; j++) {
			boolean found = true;
			Hashtable<String, Integer> foundHash = new Hashtable<String, Integer>();
			for (int k = 0; k < L.length; k++) {
				int startIndex = j + k * len;
				String str = S.substring(startIndex, startIndex + len);
				System.out.println(str);
				System.out.println("k" + k);
				if (!hash.containsKey(str)) {
					found = false;
					break;
				} else {
					if (!foundHash.containsKey(str)) {
						foundHash.put(str, 1);
					} else {
						int counter = foundHash.get(str);
						counter++;
						foundHash.put(str, counter);
					}
					int targetNum = hash.get(str);
					int foundNum = foundHash.get(str);
					// System.out.println("targetNum"+targetNum);
					// System.out.println("foundNum"+foundNum);
					if (foundNum > targetNum) {
						found = false;
						break;
					}
				}
			}
			if (found) {
				// System.out.println("j " + j);
				result.add(j);
			}

		}
		return result;

	}

	public static void main(String[] args) {
		SubstringWithConcatenationOfAllWords o = new SubstringWithConcatenationOfAllWords();
		String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
		String[] l = { "fooo", "barr", "wing", "ding", "wing" };
		System.out.println(o.findSubstring(s, l));
	}
}
