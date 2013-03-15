/*
Given a string array, there is only one string occurring odd times, and all the others occur even times
find this string which occurs odd times
 
 Number them based on their serial number, then XOR all this numbers
 */
import java.util.*;

public class OddOccurenceStringFinding {
	public String oddOccur(String[] words) {
		if (words.length == 0) {
			return null;
		}
		if (words.length == 1) {
			return words[0];
		}
		Hashtable<String, Integer> hash = new Hashtable<String, Integer>();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		int serial = 0;
		int target = 0;
		for (int i = 0; i < words.length; i++) {
			if (!hash.containsKey(words[i])) {
				hash.put(words[i], serial);
				nums.add(serial);
				serial++;
			} else {
				nums.add(hash.get(words[i]));
			}
		}

		for (int j = 0; j < nums.size(); j++) {
			target = target ^ nums.get(j);
		}

		for (String k : hash.keySet()) {
			if (hash.get(k) == target) {
				return k;
			}
		}
		return null;
	}
	
	public static void main(String[] args){
		OddOccurenceStringFinding o = new OddOccurenceStringFinding();
		String[] words ={"a","a","b","b","d",};
		System.out.println(o.oddOccur(words));
	}
}
