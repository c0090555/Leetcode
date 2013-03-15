/*
 * Reverse a LinkedList without any extra space
 Solution:
 http://analgorithmaday.blogspot.com/2011/03/reverse-linked-listusing-recursion.html
 
 Use recursion and consider the last two ListNodes
 
 */

public class ReverseALinkedList {
	// recursive version -  start fro the second last ListNode
	public ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode result = reverse(head.next);
		head.next.next = head;// start from the second last ListNode
		head.next = null;
		return result;

	}

	// iterative version - record previous node
	public ListNode reverseIter(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode curr = head;
		ListNode prev = null;
		while (curr != null) {
			ListNode temp = curr;
			curr = curr.next;
			temp.next = prev;
			prev = temp;
		}
		return prev;
		

	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		ReverseALinkedList o = new ReverseALinkedList();

		ListNode newHead = o.reverseIter(head);
		System.out.println("start");
		while (newHead != null) {
			System.out.println(newHead.val);
			newHead = newHead.next;
		}
	}
}
