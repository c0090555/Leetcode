//calculate the length first, then do it part by part

public class ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null || k < 0) {
			return null;
		}
		if (k == 0 || k == 1) {
			return head;
		}
		int l = calculateLength(head);
		int repeat = l / k;
		if (repeat == 0) {
			return head;
		}
		ListNode currNode = head;
		ListNode partTail = null;
		ListNode partHead = null;
		ListNode copy;
		ListNode saveHead = head;
		ListNode prevTail = head;

		for (int i = 0; i < repeat; i++) {
			for (int j = 0; j < k; j++) {
				if (j == 0) {
					partTail = new ListNode(currNode.val);
					partHead = partTail;
				} else {
					copy = new ListNode(currNode.val);
					copy.next = partHead;
					partHead = copy;
				}
				if (j != k - 1) {
					currNode = currNode.next;
				}
			}
			if (i == 0) {
				saveHead = partHead;

			} else {
				prevTail.next = partHead;
			}
			prevTail = partTail;
			currNode = currNode.next;
		}
		prevTail.next = currNode;

		return saveHead;

	}

	public int calculateLength(ListNode head) {
		int counter = 0;
		while (head != null) {
			counter++;
			head = head.next;
		}
		return counter;
	}

	public static void main(String[] args) {
		ReverseNodesInKGroup o = new ReverseNodesInKGroup();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		ListNode result = o.reverseKGroup(head, 5);
		System.out.println(result.val);
		System.out.println(result.next.val);
		System.out.println(result.next.next.val);
		System.out.println(result.next.next.next.val);
		System.out.println(result.next.next.next.next.val);

	}
}
