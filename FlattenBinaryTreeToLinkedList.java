import java.util.*;

public class FlattenBinaryTreeToLinkedList {
	public void flatten(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null) {
			return;
		}
		LinkedList<Integer> l = new LinkedList<Integer>();
		flattenToLinkedList(root, l);
		l.remove(0);// get rid of the first element in the LinkedList(i.e. root)

		if (!l.isEmpty()) {
			TreeNode temp = new TreeNode(l.remove(0));
			root.left = null;
			root.right = temp;

			while (!l.isEmpty()) {
				temp.left = null;
				temp.right = new TreeNode(l.remove(0));
				temp = temp.right;
			}
		}

		// System.out.print(root.val +"_");
		// System.out.print(root.right.left +"_");
		// System.out.print(root.right.right.val +"_");
		//
		//
		return;
	}

	public void flattenToLinkedList(TreeNode root, LinkedList<Integer> n) {
		if (root == null) {
			return;
		}
		n.add(root.val);
		// System.out.println(root.val);
		if (root.left != null) {
			flattenToLinkedList(root.left, n);
		}
		if (root.right != null) {
			flattenToLinkedList(root.right, n);
		}
		return;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		FlattenBinaryTreeToLinkedList o = new FlattenBinaryTreeToLinkedList();
		o.flatten(root);
		System.out.print(root.val + "_");
		System.out.print(root.left + "_");
		System.out.print(root.right + "_");

	}

}
