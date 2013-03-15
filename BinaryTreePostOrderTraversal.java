import java.util.*;

public class BinaryTreePostOrderTraversal {
	// recursive approach
	public ArrayList<Integer> postorderTraversalRecursive(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		postorderTraversalHelper(root, list);
		return list;

	}

	public void postorderTraversalHelper(TreeNode root, ArrayList<Integer> list) {
		if (root == null) {
			return;
		}
		postorderTraversalHelper(root.left, list);
		postorderTraversalHelper(root.right, list);
		list.add(root.val);
		return;
	}

	// iterative approach
	// idea comes from:
	// http://www.leetcode.com/2010/10/binary-tree-post-order-traversal.html
	public ArrayList<Integer> postorderTraversalIterative(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode prev = null;// previous visited Node
		s.push(root);
		while (!s.isEmpty()) {
			TreeNode top = s.peek();
			// traversing down the tree
			if (prev == null || prev.left == top || prev.right == top) {
				if (top.left != null) {// traverse left to the bottom
					s.push(top.left);
				} else if (top.right != null) {
					s.push(top.right);
				} else {
					s.pop();
					list.add(top.val);
				}
			}
			// traversing up the tree from the left side
			else if (top.left == prev) {
				if (top.right != null) {
					s.push(top.right);
				} else {
					s.pop();
					list.add(top.val);
				}
			}
			// traversing up from the right side
			else if (top.right == prev) {
				s.pop();
				list.add(top.val);
			}
			prev = top; //update prev
		}
		return list;

	}
}