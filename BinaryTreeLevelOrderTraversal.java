import java.util.*;

//class TreeNode implements Cloneable {
//	int val;
//	TreeNode left;
//	TreeNode right;
//
//	TreeNode(int v) {
//		val = v;
//	}
//	public Object clone() {
//		try {
//			return super.clone();
//		} catch (Exception e) {
//			return null;
//		}
//	}
//}

public class BinaryTreeLevelOrderTraversal {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> currentLevel = new ArrayList<Integer>();
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		LinkedList<TreeNode> next = new LinkedList<TreeNode>();
		if (root == null) {
			return result;
		}
		current.add(root);
		while (current.size() != 0 || next.size() != 0) {
			currentLevel = new ArrayList<Integer>();
			while (current.size() != 0) {
				TreeNode current_element = current.remove();
				if (current_element.left != null) {
					next.add(current_element.left);
				}
				if (current_element.right != null) {
					next.add(current_element.right);
				}
				currentLevel.add(current_element.val);
			}
			result.add(currentLevel);
			current = next;
			next = new LinkedList<TreeNode>();

		}
		return result;
	}

}
