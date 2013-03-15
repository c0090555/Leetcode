//swap value of nodes instead of swapping nodes
public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}
		ListNode saveHead = head;
		while (head != null) {
			if (head.next == null) {// the last node
				return saveHead;
			}
			int temp = head.val;
			head.val = head.next.val;
			head.next.val = temp;
			head = head.next.next;

		}
		return saveHead;

	}

	public static void main(String[] args) {
		SwapNodesInPairs o = new SwapNodesInPairs();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		// head.next.next=new ListNode(3);

		head = o.swapPairs(head);
		System.out.println(head.val);
		System.out.println(head.next.val);
		// System.out.println(head.next.next.val);

	}

}
