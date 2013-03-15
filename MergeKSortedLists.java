//we use the number of null ListNodes in the ArrayList lists to indicate whether we have finished the merge
import java.util.*;

//class ListNode {
//	int val;
//	ListNode next;
//
//	ListNode(int x) {
//		val = x;
//		next = null;
//	}
//}

public class MergeKSortedLists {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		// Start typing your Java solution below
		// DO NOT{ write main() function
		int countNull = getNullListNumber(lists);
		// System.out.println("countNull" + countNull);
		System.out.println("size" + lists.size());

		if (countNull == lists.size()) {
			return null;
		}
		if (lists.size() == 0) {
			return null;
		}
		int min = Integer.MAX_VALUE;
		int minLocation = 0;
		for (int i = 0; i < lists.size(); i++) {
			ListNode n = lists.get(i);
			if (n != null) {
				if (n.val < min) {
					min = n.val;
					minLocation = i;
				}
			} else {
				countNull++;
			}
		}
		ListNode minNode = lists.get(minLocation);
		// System.out.println("minLocation" + minLocation);
		minNode = minNode.next;
		if (minNode == null) {
			countNull++;
		}
		lists.set(minLocation, minNode);
		// System.out.println("minLoca" + minLocation);
		//
		// System.out.println("countNull2" + countNull);

		ListNode start = new ListNode(min);
		ListNode current = start;

		while (countNull < lists.size()) {
			// System.out.println("countNull3" + countNull);

			min = Integer.MAX_VALUE;
			minLocation = 0;
			for (int i = 0; i < lists.size(); i++) {
				ListNode n = lists.get(i);
				if (n != null) {
					if (n.val < min) {
						min = n.val;
						minLocation = i;
					}
				} else {
					countNull++;
				}
			}
			minNode = lists.get(minLocation);
			minNode = minNode.next;
			if (minNode == null) {
				countNull++;
			}
			lists.set(minLocation, minNode);
			ListNode newNode = new ListNode(min);
			current.next = newNode;
			current = newNode;

		}
		// System.out.println("min" + min);

		return start;

	}

	public int getNullListNumber(ArrayList<ListNode> lists) {
		int count = 0;
		for (int i = 0; i < lists.size(); i++) {
			if (lists.get(i) == null) {
				count++;
			}
		}
		return count;

	}

	public static void main(String[] args) {
		MergeKSortedLists o = new MergeKSortedLists();
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ArrayList<ListNode> result = new ArrayList<ListNode>();
		result.add(a);
		result.add(b);
		System.out.println(o.mergeKLists(result).next.next);
	}
}
