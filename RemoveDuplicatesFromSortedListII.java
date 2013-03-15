//The key is to try to find the first unique node and pay attention to the ending part
public class RemoveDuplicatesFromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}
		ListNode saveHead;
		ListNode runner;
		boolean duplicate = false;

		// try to find the first unique node
		while (head.next != null) {
			if (head.val == head.next.val) {
				duplicate = true;
			} else {
				if (!duplicate) {
					break;
				} else {
					duplicate = false;
				}

			}
			head = head.next;

		}
		if (head.next == null) {
			if (!duplicate) {
				return head;
			} else {
				return null;// all nodes are duplicate nodes
			}
		} else {
			saveHead = head;
			runner = head;
		}

		while (runner.next != null) {
			if (runner.val == runner.next.val) {
				duplicate = true;
			} else {
				if (!duplicate && runner.val != saveHead.val) {
					head.next = new ListNode(runner.val);
					head = head.next;
				}
				duplicate = false;
			}
			runner = runner.next;
		}

		if (!duplicate) {
			head.next = new ListNode(runner.val);
			head = head.next;
			head.next = null;
		} else {
			head.next = null;
		}
		return saveHead;
	}

	public static void main(String[] args) {
		RemoveDuplicatesFromSortedListII o = new RemoveDuplicatesFromSortedListII();
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = null;
		// System.out.println("head" + head.val);
		System.out.println(o.deleteDuplicates(head).val);

	}
}
