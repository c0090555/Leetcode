/*
Key idea: use recursion and a global static variable maxSoFar to record the current maximum value
For each node: we will get the leftMax and rightMax for its left subtree and right subtree, if any of them >0,
add it to current node value, then update maxSoFar

Go to upper level with the selection of correct path(left or right or nothing)



 */
public class BinaryTreeMaximumSum {
	public static int maxSoFar = 0;

	public static int maxPathSum(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null) {
			return 0;
		}
		maxSoFar = root.val;
		maxPathSumHelper(root);
		return maxSoFar;
	}

	public static int maxPathSumHelper(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftMax = maxPathSumHelper(root.left);
		int rightMax = maxPathSumHelper(root.right);
		int maxPath = root.val;
		if (leftMax > 0) {
			maxPath += leftMax;
		}
		if (rightMax > 0) {
			maxPath += rightMax;
		}
		if (maxPath > maxSoFar) {
			maxSoFar = maxPath;
		}
		int result = root.val;

		return Math.max(result, result + Math.max(leftMax, rightMax));

	}
}
