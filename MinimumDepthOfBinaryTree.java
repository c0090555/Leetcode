//The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
//for tree like this:
//   1
//  /
// 2
//we can think the right height of node 1 is Integer.MAX_VALUE

public class MinimumDepthOfBinaryTree {
	public int minDepth(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {// reach the leaf
			return 1;
		}
		int leftHeight = Integer.MAX_VALUE;
		int rightHeight = Integer.MAX_VALUE;
		int height = 0;
		if (root.left != null) {
			leftHeight = minDepth(root.left) + 1;
		}
		if (root.right != null) {
			rightHeight = minDepth(root.right) + 1;
		}
		height = Math.min(leftHeight, rightHeight);
		return height;
	}

}
