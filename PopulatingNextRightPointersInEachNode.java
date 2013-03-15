import java.util.*;

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int v) {
		val = v;
	}
}

public class PopulatingNextRightPointersInEachNode {
	public void connect(TreeLinkNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (root == null) {
			return;
		}
		root.next = null;
		connectBFS(root);
		connectDFS(root);
	}

	// BFS: travel level by level, from left to right
	public void connectBFS(TreeLinkNode root) {
		if (root == null | root.left == null | root.right == null) {
			return;
		}
		TreeLinkNode current = root;
		while (current != null) {
			if (current.left != null) {
				current.left.next = current.right;
			}
			if (current.right != null) {
				current.right.next = (current.next == null) ? null
						: current.next.left;
			}
			current = current.next;
		}
		connectBFS(root.left);

	}

	// DFS: travel from root
	public void connectDFS(TreeLinkNode root) {
		if (root == null | root.left == null | root.right == null) {
			return;
		}
		root.left.next = root.right;
		root.right.next = (root.next == null) ? null : root.next.left;
		connectDFS(root.left);
		connectDFS(root.right);

	}

}
