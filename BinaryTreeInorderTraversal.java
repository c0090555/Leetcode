import java.util.*;

public class BinaryTreeInorderTraversal {
	// recursive approach
	public ArrayList<Integer> inorderTraversalRecursive(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		inorderTraversalHelper(root, list);
		return list;

	}

	public void inorderTraversalHelper(TreeNode root, ArrayList<Integer> list) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			list.add(root.val);
			return;
		}
		inorderTraversalHelper(root.left, list);
		list.add(root.val);
		inorderTraversalHelper(root.right, list);
		return;
	}

	// iterative approach
	// idea comes
	// from:http://www.leetcode.com/2010/04/binary-search-tree-in-order-traversal.html
	/*
	 * use a current pointer in addition of a stack.
	 * 
	 * First, the current pointer is initialized to the root. Keep traversing to
	 * its left child while pushing visited nodes onto the stack. When you reach
	 * a NULL node (ie, you’ve reached a leaf node), you would pop off an
	 * element from the stack and set it to current. Now is the time to print
	 * current’s value. Then, current is set to its right child and repeat the
	 * process again. When the stack is empty, this means you’re done printing.
	 */

	public ArrayList<Integer> inorderTraversalIterative(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode curr = root;
		TreeNode top;
		s.push(root);
		while (!s.isEmpty()) {
			top = s.peek();
			if (top != null) {
				s.push(top.left);
			} else {
				s.pop();
				if (s.isEmpty()) {
					return list;
				}
				curr = s.peek();
				list.add(curr.val);
				s.pop();
				s.push(curr.right);

			}

		}
		return list;

	}
}
