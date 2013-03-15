/*create a new LinkedList, for the ListNode in [m,n] range, insert them before its tail, just like stack
else, insert them after the tail
Assume m,n are valid (1<=m<n<=length of LinkedList)
 Pay attention to the special case: m == 1
 */


public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null || m > n || m <= 0 | n <= 0) {
			return null;
		}
		if (m == n) {
			return head;
		}
		ListNode copy;
		ListNode saveHead = head;
		ListNode rtail = null;// tail of reverse part
		ListNode saveRtail = rtail;
		ListNode saveEnd;
		int i;
		if (m > 1) {
			for (i = 1; i <= m - 2; i++) {
				head = head.next;
			}
			// save the end of the first (m-1) nodes
			saveEnd = head;
			System.out.println("saveHead" + saveHead.val);
			System.out.println("head" + head.val);

			for (i = m; i <= n; i++) {
				head = head.next;
				copy = new ListNode(head.val);
				if (i == m) {
					saveRtail = copy;
				}
				copy.next = rtail;
				rtail = copy;
			}
			System.out.println("rtail" + rtail.val);
			// connect the first part with the reverse part

			head = head.next;
			saveRtail.next = head;
			saveEnd.next = rtail;
			return saveHead;
		} else {
			for (i = 1; i <= n; i++) {
				copy = new ListNode(head.val);
				if (i == 1) {
					saveRtail = copy;
				}
				copy.next = rtail;
				rtail = copy;
				head = head.next;
			}
			saveRtail.next = head;
			return rtail;

		}

	}

	public static void main(String[] args) {
		ReverseLinkedListII o = new ReverseLinkedListII();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		ListNode result = o.reverseBetween(head, 4, 5);
		System.out.println(result.val);
		System.out.println(result.next.val);
		System.out.println(result.next.next.val);
		System.out.println(result.next.next.next.val);
		System.out.println(result.next.next.next.next.val);

	}

}
