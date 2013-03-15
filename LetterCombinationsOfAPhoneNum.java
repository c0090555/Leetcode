//recursion
import java.util.*;

public class LetterCombinationsOfAPhoneNum {
	private ArrayList<String> result = new ArrayList<String>();
	private String[] letters = new String[10];

	public ArrayList<String> letterCombinations(String digits) {
		result = new ArrayList<String>();
		letters[0] = " ";
		letters[1] = "";
		letters[2] = "abc";
		letters[3] = "def";
		letters[4] = "ghi";
		letters[5] = "jkl";
		letters[6] = "mno";
		letters[7] = "pqrs";
		letters[8] = "tuv";
		letters[9] = "wxyz";
		String st = "";
		letterCombinationsRecursion(digits, 0, st);
		return result;
	}

	public void letterCombinationsRecursion(String digits, int n, String st) {
		if (n >= digits.length()) {
			result.add(st);
			return;
		}
		for (int i = 0; i < letters[digits.charAt(n) - '0'].length(); i++) {
			letterCombinationsRecursion(digits, n + 1,
					st + letters[digits.charAt(n) - '0'].charAt(i));
		}

	}

	public static void main(String[] args) {
		LetterCombinationsOfAPhoneNum o = new LetterCombinationsOfAPhoneNum();
		String s = "23";
		System.out.println(o.letterCombinations(s));

	}
}
