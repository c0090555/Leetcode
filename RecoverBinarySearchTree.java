/*if swap two neighbor nodes,then there are two nodes which don't meet the BST requirement,
 * otherwise, there are three nodes which don't meet the BST requirement
 * We use an ArrayList to save these nodes and swap the first and last element in the ArrayList
 */

import java.util.*;

public class RecoverBinarySearchTree {
	public void recoverTree(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null) {
			return;
		}
		ArrayList<TreeNode> unsort = new ArrayList<TreeNode>();
		recoverTreeHelper(root, unsort);
		swap(unsort.get(0), unsort.get(unsort.size() - 1));
	}

	public void recoverTreeHelper(TreeNode root, ArrayList<TreeNode> unsort) {
		if (root == null) {
			return;
		}
		if (!isBSTNode(root)) {
			unsort.add(root);
			System.out.println("unsort " + root.val);
			if (unsort.size() == 3) {
				return;
			}
		}
		recoverTreeHelper(root.left, unsort);
		recoverTreeHelper(root.right, unsort);
		return;
	}

	public boolean isBSTNode(TreeNode root) {
		if (root == null) {
			return true;
		}
		int leftVal = Integer.MIN_VALUE;
		int rightVal = Integer.MAX_VALUE;
		if (root.left != null) {
			leftVal = root.left.val;
		}
		if (root.right != null) {
			rightVal = root.right.val;
		}
		return (root.val <= rightVal) && (root.val >= leftVal);

	}

	public void swap(TreeNode a, TreeNode b) {
		int temp = a.val;
		a.val = b.val;
		b.val = temp;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(8);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(6);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(11);
		root.left.left.left = new TreeNode(1);
		root.left.left.right = new TreeNode(4);
		root.left.right.right = new TreeNode(7);
		RecoverBinarySearchTree o = new RecoverBinarySearchTree();
		o.recoverTree(root);
		System.out.println(root.val);
		System.out.println(root.left.val);
		System.out.println(root.right.val);
		System.out.println(root.left.left.val);
		System.out.println(root.left.right.val);
		System.out.println(root.right.left.val);
		System.out.println(root.right.right.val);
		System.out.println(root.left.left.left.val);
		System.out.println(root.left.left.right.val);
		System.out.println(root.left.right.right.val);

	}

}