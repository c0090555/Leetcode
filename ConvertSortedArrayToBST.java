import java.util.Arrays;

//Convert a sorted array(ascending order) to a height balanced BST

public class ConvertSortedArrayToBST {
	public TreeNode sortedArrayToBST(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (num.length == 0) {
			return null;
		}
		if (num.length == 1) {
			return new TreeNode(num[0]);
		}
		int mid = (num.length - 1) / 2;
		TreeNode root = new TreeNode(num[mid]);
		if (mid >= 1) {
			root.left = sortedArrayToBST(Arrays.copyOfRange(num, 0, mid));
		} else {
			root.left = null;
		}
		if (num.length - 1 - mid - 1 >= 0) {
			root.right = sortedArrayToBST(Arrays.copyOfRange(num, mid + 1,
					num.length));
		} else {
			root.right = null;
		}

		return root;
	}
}
