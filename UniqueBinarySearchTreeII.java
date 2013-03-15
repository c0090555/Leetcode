//use recursion
import java.util.*;

public class UniqueBinarySearchTreeII {
	public ArrayList<TreeNode> generateTrees(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n == 0) {
			ArrayList<TreeNode> res = new ArrayList<TreeNode>();
			res.add(null);
			return res;
		}
		return generateTrees(1, n);
	}

	public ArrayList<TreeNode> generateTrees(int low, int upper) {
		ArrayList<TreeNode> res = new ArrayList<TreeNode>();
		if (low > upper) {
			res.add(null);
			return res;
		}

		for (int k = low; k <= upper; k++) {
			ArrayList<TreeNode> leftTree = generateTrees(low, k - 1);
			ArrayList<TreeNode> rightTree = generateTrees(k + 1, upper);
			for (int i = 0; i < leftTree.size(); i++) {
				for (int j = 0; j < rightTree.size(); j++) {
					TreeNode root = new TreeNode(k);
					root.left = leftTree.get(i);
					root.right = rightTree.get(j);
					res.add(root);

				}
			}

		}
		return res;

	}

}
