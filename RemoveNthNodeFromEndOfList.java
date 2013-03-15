//assume n is always valid
//use fast-slow runner strategy
//pay attention to delete the first node

public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode saveHead = head;
		ListNode fast = head;
		for (int i = 1; i <= n; i++) {
			fast = fast.next;
		}
		if (fast == null) {
			saveHead = saveHead.next;
			return saveHead;
		}
		while (fast.next != null) {
			head = head.next;
			fast = fast.next;
		}
		if (head.next != null) {
			head.next = head.next.next;
		} else {
			head.next = null;
		}

		return saveHead;
	}
}
