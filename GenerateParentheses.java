import java.util.*;
//use recursion
//use +1 & -1 to simulate stack operation
//sum+1 means inserting a left parenthese
//sum-1 means inserting a right parenthese
//sum should be always >=0

public class GenerateParentheses {

	public ArrayList<String> generateParenthesis(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> result = new ArrayList<String>();
		generateParenthesis(n, n, 0, "", result);
		return result;

	}

	public void generateParenthesis(int left, int right, int sum, String s,
			ArrayList<String> result) {
		if (left == 0 && right == 0 && sum == 0) {
			result.add(s);
			return;
		}
		if (left < 0 || right < 0 || sum < 0) {
			return;
		}
		generateParenthesis(left - 1, right, sum + 1, s + "(", result);
		if (sum > 0) {
			generateParenthesis(left, right - 1, sum - 1, s + ")", result);

		}

	}

}
