import java.util.*;

public class CombinationSum2 {
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> comb = new ArrayList<Integer>();
		Arrays.sort(num);
		solve(result, comb, num, 0, target);
		return result;
	}

	public void solve(ArrayList<ArrayList<Integer>> result,
			ArrayList<Integer> comb, int[] num, int start, int target) {
		if (target == 0) {
			result.add((ArrayList<Integer>)comb.clone());//Need to use clone method here
			return;
		}
		if (start == num.length || target < 0) {
			return;
		}

		int prev = -1;
		for (int i = start; i < num.length; i++) {
			if (num[i] != prev) {
				comb.add(num[i]);
				solve(result, comb, num, i + 1, target - num[i]);
				comb.remove(comb.size() - 1);
				prev = num[i];
			}
		}

	}
}
