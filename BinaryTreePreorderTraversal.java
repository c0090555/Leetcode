import java.util.*;

public class BinaryTreePreorderTraversal {
	// recursive approach
	public ArrayList<Integer> preorderTraversalRecursive(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		preorderTraversalHelper(root, result);
		return result;

	}

	public void preorderTraversalHelper(TreeNode root, ArrayList<Integer> list) {
		if (root == null) {
			return;
		}
		list.add(root.val);
		preorderTraversalHelper(root.left, list);
		preorderTraversalHelper(root.right, list);
		return;
	}

	// iterative approach - use a stack, push right child first, then left child
	public ArrayList<Integer> preorderTraversalIterative(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		while (!s.isEmpty()) {
			TreeNode top = s.pop();
			list.add(top.val);

			if (top.right != null) {
				s.push(top.right);
			}
			if (top.left != null) {
				s.push(top.left);
			}
		}
		return list;

	}

}