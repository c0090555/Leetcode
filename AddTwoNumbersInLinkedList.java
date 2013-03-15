class ListNode {
	int val;
	ListNode next;

	ListNode(int v) {
		val = v;
		next = null;
	}
}

public class AddTwoNumbersInLinkedList {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		int value = 0;
		ListNode head;
		ListNode temp;
		ListNode node;
		if (l1 == null || l2 == null) {
			return null;
		}
		value = l1.val + l2.val;
		head = new ListNode(value % 10);
		node = head;
		carry = value / 10;
		l1 = l1.next;
		l2 = l2.next;

		while (l1 != null || l2 != null) {
			value = 0;
			if (l1 != null) {
				value += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				value += l2.val;
				l2 = l2.next;
			}
			value += carry;
			carry = value / 10;
			temp = new ListNode(value % 10);
			node.next = temp;
			node = node.next;
		}
		if(carry != 0){
			temp = new ListNode(carry);
			node.next = temp;
		}
		
		return head;
	}
	public void printListNode(ListNode head){
		while(head!=null){
			System.out.print(head.val+"=>");
			head = head.next;
		}
	}
	
	public static void main(String[] args){
		AddTwoNumbersInLinkedList o = new AddTwoNumbersInLinkedList();
		ListNode l1 = new ListNode(1);
		ListNode head = l1;
		for(int i = 2;i<5;i++){
			ListNode l = new ListNode(i);
			l1.next = l;
			l1=l1.next;
		}
		o.printListNode(head);
		System.out.println();
		ListNode l2 = new ListNode(1);
		ListNode head2 = l2;
		for(int i = 2;i<4;i++){
			ListNode l22 = new ListNode(i);
			l2.next = l22;
			l2=l2.next;
		}
		o.printListNode(head2);
		System.out.println();

		ListNode result = o.addTwoNumbers(head, head2);
		o.printListNode(result);
		
	}

}
