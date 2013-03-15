import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> currentLevelValue = new ArrayList<Integer>();
		Stack<TreeNode> currentLevelTree = new Stack<TreeNode>();
		Stack<TreeNode> nextLevelTree = new Stack<TreeNode>();
		int level = 0;
		if (root == null)
			return result;
		currentLevelTree.push(root);
		while (!currentLevelTree.isEmpty() || !nextLevelTree.isEmpty()) {
			level++;
			currentLevelValue = new ArrayList<Integer>();
			while (!currentLevelTree.isEmpty()) {
				TreeNode currentNode = currentLevelTree.pop();
				currentLevelValue.add(currentNode.val);
				if (level % 2 != 0) {
					if (currentNode.left != null) {
						nextLevelTree.push(currentNode.left);
					}
					if (currentNode.right != null) {
						nextLevelTree.push(currentNode.right);
					}
				} else {
					if (currentNode.right != null) {
						nextLevelTree.push(currentNode.right);
					}
					if (currentNode.left != null) {
						nextLevelTree.push(currentNode.left);
					}
				}
			}
			result.add(currentLevelValue);
			currentLevelTree = nextLevelTree;
			nextLevelTree = new Stack<TreeNode>();

		}
		return result;

	}

}
