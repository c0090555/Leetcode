import java.util.*;

public class ValidParentheses {
	public boolean isValid(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s.length() == 0 || s.length() % 2 == 1) {
			return false;
		}
		int sum = 0;
		char target;
		Stack<Character> k = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '{' || c == '[') {
				sum++;
				k.push(c);
			} else {
				sum--;
				if (sum < 0 || k.isEmpty()) {
					return false;
				}
				switch (c) {
				case ')':
					target = '(';
					break;
				case '}':
					target = '{';
					break;
				case ']':
					target = '[';
					break;
				default:
					return false;
				}
				if (k.peek() != target) {
					return false;
				} else {
					k.pop();
				}

			}
		}
		if (sum == 0) {
			return true;
		} else {
			return false;
		}
	}
}
