//pay attention to special case: it contains only one repeating number, e.g. {1,1};{1,1,1}
public class RemoveDuplicatesFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}
		ListNode saveHead = head;
		ListNode runner = head;

		while (runner.next != null) {
			if (runner.val != runner.next.val && runner.val != saveHead.val) {
				head.next = new ListNode(runner.val);
				head = head.next;
			}
			runner = runner.next;
		}
		if (runner.val != saveHead.val) {
			head.next = new ListNode(runner.val);
			head = head.next;
			head.next = null;
		} else {
			head.next = null;
		}
		return saveHead;

	}
}
