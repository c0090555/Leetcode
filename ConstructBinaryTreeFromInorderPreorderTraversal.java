import java.util.*;

public class ConstructBinaryTreeFromInorderPreorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (inorder.length != preorder.length) {
			return null;
		}
		if (inorder.length == 0 || preorder.length == 0) {
			return null;
		}
		Hashtable<Integer, Integer> indexHash = new Hashtable<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			indexHash.put(inorder[i], i);
		}

		TreeNode root = buildTree(inorder, preorder, 0, inorder.length - 1, 0,
				preorder.length - 1, 0, indexHash);
		return root;
	}

	public TreeNode buildTree(int[] inorder, int[] preorder, int inStart,
			int inEnd, int preStart, int preEnd, int offset,
			Hashtable<Integer, Integer> indexHash) {
		if (inStart > inEnd || inStart < 0 || inEnd >= inorder.length
				|| preStart > preEnd || preStart < 0
				|| preEnd >= preorder.length) {
			return null;
		}
		if (inStart == inEnd) {
			return new TreeNode(inorder[inStart]);
		}
		if (preStart == preEnd) {
			return new TreeNode(preorder[preStart]);
		}

		TreeNode root = new TreeNode(preorder[preStart]);
		int rootInorderIndex = indexHash.get(preorder[preStart]);
		int leftNum = rootInorderIndex - offset;
		int rightNum = inEnd - inStart - leftNum;
		root.left = buildTree(inorder, preorder, inStart,
				inStart + leftNum - 1, preStart + 1, preStart + leftNum,
				offset, indexHash);
		root.right = buildTree(inorder, preorder, rootInorderIndex + 1,
				rootInorderIndex + rightNum, preStart + leftNum + 1, preStart
						+ leftNum + 1 + rightNum - 1, offset + leftNum + 1,
				indexHash);
		return root;
	}
}
