import java.util.*;

public class SumRootToLeafNumbers {
	public static int finalSum = 0;
	public Hashtable<TreeNode, Integer> hash = new Hashtable<TreeNode, Integer>();

	public int sumNumbers(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		finalSum = 0;
		hash = new Hashtable<TreeNode, Integer>();
		PartialSum ps = new PartialSum(0);
		dfs(root, ps);
		return finalSum;

	}

	public void dfs(TreeNode n, PartialSum ps) {
		if (n == null) {
			return;
		}
		if (n.left == null && n.right == null) {
			int sum = ps.sum * 10 + n.val;
			finalSum += sum;
			return;
		}
		int currentSum = ps.sum * 10 + n.val;
		if (!hash.containsKey(n)) {
			hash.put(n, currentSum);
		}
		if (n.left != null) {
			dfs(n.left, new PartialSum(currentSum));
		}
		if (n.right != null) {
			dfs(n.right, new PartialSum(currentSum));
		}

	}

}

// public static void main

class PartialSum {
	public int sum;

	PartialSum(int s) {
		sum = s;
	}
}
