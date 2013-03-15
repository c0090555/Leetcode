public class PopulatingNextRightPointersInEachNodeII{
	public void connect(TreeLinkNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null) {
			return;
		}
		root.next = null;
		connectBFS(root);
	}

	public void connectBFS(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		TreeLinkNode newHead = null;// new head for next level
		while (root != null) {
			if (root.left != null) {
				root.left.next = getNextSibling(root, true);
				if (newHead == null) {
					newHead = root.left;
				}
			}
			if (root.right != null) {
				root.right.next = getNextSibling(root, false);
				if (newHead == null) {
					newHead = root.right;
				}
			}
			root = root.next;
		}
		connectBFS(newHead);

	}

	// DFS has problem... cannot be used here directly
	// public void connectDFS(TreeLinkNode root) {
	// if (root == null) {
	// return;
	// }
	// if (root.left != null) {
	// root.left.next= getNextSibling(root, true);
	// }
	// if (root.right != null) {
	// root.right.next = getNextSibling(root, false);
	// }
	// connectDFS(root.left);
	// connectDFS(root.right);
	// }

	public TreeLinkNode getNextSibling(TreeLinkNode curNode, boolean isLeft) {
		if (curNode == null) {
			return null;
		}
		if (isLeft == true) {// if we are looking for a sibling of a left child
			if (curNode.right != null) {
				return curNode.right;
			}
		}
		while ((curNode = curNode.next) != null) {
			if (curNode.left != null) {
				return curNode.left;
			}
			if (curNode.right != null) {
				return curNode.right;
			}
		}
		return null;

	}
}
