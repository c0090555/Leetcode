public class CovertSortedListToBST {
	public TreeNode sortedListToBST(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function
		TreeNode root = constructBST(head, length(head));
		return root;

	}

	public TreeNode constructBST(ListNode head, int length) {
		if (length <= 0 || head == null) {
			return null;
		}
		if (length == 1) {
			return new TreeNode(head.val);
		}
		ListNode mid = head;
		for (int i = 1; i <= length / 2; i++) {
			mid = mid.next;
		}
		TreeNode root = new TreeNode(mid.val);
		if (length % 2 == 0) {
			root.left = constructBST(head, length / 2);
			root.right = constructBST(mid.next, length / 2 - 1);
		} else {
			root.left = constructBST(head, length / 2);
			root.right = constructBST(mid.next, length / 2);
		}

		return root;

	}

	public int length(ListNode head) {
		int counter = 0;
		while (head != null) {
			counter++;
			head = head.next;
		}
		return counter;
	}

}
