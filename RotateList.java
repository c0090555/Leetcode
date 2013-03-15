//use slow-fast runner strategy

//Internal Error when run leetcode OJ


public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null) {
			return null;
		}
		int l = calculateLength(head);
		if (n % l == 0) {
			return head;
		}
		if (n > l) {
			n = n % l;
		}

		ListNode slow = head;
		ListNode fast = head;
		ListNode saveHead = head;
		for (int i = 0; i < n; i++) {
			if (fast == null) {
				return null;
			}
			fast = fast.next;
		}

		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}

		head = slow.next;
		fast.next = saveHead;
		slow.next = null;
		System.out.println("head " + head.val);

		return head;

	}

	public int calculateLength(ListNode head) {
		if (head == null) {
			return 0;
		}
		int counter = 0;
		while (head != null) {
			counter++;
			head = head.next;
		}
		return counter;
	}

	public static void main(String[] args) {
		RotateList o = new RotateList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);

		head = o.rotateRight(head, 1);

		System.out.println(head.next.next);

	}

}
