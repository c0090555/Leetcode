public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null) {
			return null;
		}
		ListNode smallHead = new ListNode(0);
		ListNode largeHead = new ListNode(0);
		ListNode smallRun = smallHead;
		ListNode largeRun = largeHead;

		while (head != null) {
			if (head.val < x) {
				ListNode temp = new ListNode(head.val);
				smallRun.next = temp;
				smallRun = smallRun.next;
			} else {
				ListNode temp = new ListNode(head.val);
				largeRun.next = temp;
				largeRun = largeRun.next;
			}
			head = head.next;

		}

		if (smallHead.next == null) {
			return largeHead.next;
		}

		smallRun.next = largeHead.next;
		return smallHead.next;
	}
}
