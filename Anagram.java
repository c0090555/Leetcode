import java.util.*;

public class Anagram {
	public ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> result = new ArrayList<String>();
		HashMap<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();
		LinkedList<String> l = new LinkedList<String>();
		for (String s : strs) {
			String si = inorderString(s);
			if (!map.containsKey(si)) {
				l = new LinkedList<String>();

			} else {
				l = map.get(si);
			}
			l.push(s);
			map.put(si, l);
			System.out.println("si"+si+" l "+l);
		}

		System.out.println("key:"+map.keySet());
		for (String si : map.keySet()) {
			System.out.println("si "+si);
			l = map.get(si);
			if (l.size() > 1) {
				for (String s : l) {
					result.add(s);
				}
			}
		}
		return result;

	}

	public String inorderString(String str) {
		char[] ch = str.toCharArray();//string => char array
		Arrays.sort(ch);
		System.out.println("ch:"+ch.toString());
		return new String(ch);//char array => string
	}

	public static void main(String[] args) {
		ArrayList<String> result;
		String[] st = { "abc", "bca", "a", "bb", "ac", "ca", "" };
		Anagram a = new Anagram();
		result = a.anagrams(st);
		System.out.println(result);
	}

}
