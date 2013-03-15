/*
Given a list of words (string), let compound word be the 
combination of any two words in the array, check the numbers of duplicated 
words (to check if there are duplicated compound words, and if the compound 
word is the same as some word in the original list, 
it is also considered as duplicated) 
{"am", "eat", "a", "meat"} "am"+"eat"="a"+"meat" outout =1 


use a Hashtable
 */
import java.util.*;

public class CheckNumOfDuplicateWords {
	public int numOfDups(String[] words) {
		if (words.length == 0) {
			return 0;
		}
		Hashtable<String, Integer> hash = new Hashtable<String, Integer>();
		int counter = 0;
		for (int i = 0; i < words.length; i++) {
			if (!hash.containsKey(words[i])) {
				hash.put(words[i], 1);
			} else {
				int c = hash.get(words[i]);
				c++;
				hash.put(words[i], c);
			}
		}

		for (int j = 0; j < words.length; j++) {
			for (int k = 0; k < words.length; k++) {
				if (j != k) {
					String s = words[j] + words[k];
					if (!hash.containsKey(s)) {
						hash.put(s, 1);
					} else {
						int c = hash.get(s);
						c++;
						hash.put(s, c);
					}
				}
			}
		}

		for (String s : hash.keySet()) {
			int c = hash.get(s);
			if (c >= 2) {
				System.out.println("s " +s);
				counter++;
			}
		}
		return counter;

	}
	 public static void main(String[] args){
		 CheckNumOfDuplicateWords o = new CheckNumOfDuplicateWords();
		 String[] words = {"am", "eat", "a", "meat","meat"};
		 System.out.println(o.numOfDups(words));
	 }
}
