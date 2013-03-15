import java.util.*;

public class PathSumII {
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> level = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		PartialSum ps = new PartialSum(0);
		pathSum(root, ps, result, level, sum);
		return result;
	}

	@SuppressWarnings("unchecked")
	public void pathSum(TreeNode root, PartialSum ps,
			ArrayList<ArrayList<Integer>> result, ArrayList<Integer> level,
			int sum) {
		if (root == null){
			return;
		}
		ArrayList<Integer> newLevel = (ArrayList<Integer>) level.clone();
		newLevel.add(root.val);
		ps = new PartialSum(ps.val + root.val);
		if (root.left == null && root.right == null) {
			if (ps.val == sum) {
				result.add(newLevel);
			}
			return;
		}
		pathSum(root.left, ps, result, newLevel, sum);
		pathSum(root.right, ps, result, newLevel, sum);

		return;

	}

	class PartialSum {
		int val;

		PartialSum(int v) {
			val = v;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(-2);
		root.right = new TreeNode(3);

		PathSumII o = new PathSumII();
		System.out.println(o.pathSum(root, -1).get(0));
	}
}
