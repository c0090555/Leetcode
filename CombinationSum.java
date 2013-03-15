import java.util.*;

public class CombinationSum {
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
			int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int[] index = new int[10000];
		index[0] = 0;
		Arrays.sort(candidates);
		int sum = 0;
		solve(result, sum, candidates, index, target, 0);
		return result;
	}

	public void solve(ArrayList<ArrayList<Integer>> result, int sum,
			int[] candidates, int[] index, int target, int n) {
		if (sum == target) {
			addSum(result, candidates, index, n);
		} else if (sum > target) {
			return;
		} else {
			for (int i = index[n]; i < candidates.length; i++) {
				index[n + 1] = i;
				solve(result, sum + candidates[i], candidates, index, target,
						n + 1);
			}
		}

	}

	public void addSum(ArrayList<ArrayList<Integer>> result, int[] candidates,
			int[] index, int n) {
		ArrayList<Integer> comb = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			comb.add(candidates[index[i]]);
		}
		result.add(comb);
	}

}
