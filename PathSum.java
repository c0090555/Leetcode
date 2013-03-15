public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		// Start typing your Java solution below
		// DO NOT write main() function
		PartialSum ps = new PartialSum(0);
		return hasPathSum(root, ps, sum);

	}

	public boolean hasPathSum(TreeNode root, PartialSum ps, int sum) {
		if (root == null) {
			return false;
		}
		ps = new PartialSum(ps.val + root.val);
		if (root.left == null && root.right == null) {

			if (ps.val == sum) {
				return true;
			} else {
				return false;
			}
		}
		return hasPathSum(root.left, ps, sum)
				|| hasPathSum(root.right, ps, sum);

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
		root.right = new TreeNode(-3);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(-2);
		root.left.left.left = new TreeNode(-1);
		PathSum o = new PathSum();
		System.out.println(o.hasPathSum(root, -3));
	}
}
