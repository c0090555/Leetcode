//solve it recursively
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null) {
			return true;
		}
		return isSymmetricHelper(root.left, root.right);

	}

	public boolean isSymmetricHelper(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if ((left == null && right != null) || (right == null && left != null)) {
			return false;
		}
		return (left.val == right.val)
				&& isSymmetricHelper(left.left, right.right)
				&& isSymmetricHelper(left.right, right.left);

	}

}
