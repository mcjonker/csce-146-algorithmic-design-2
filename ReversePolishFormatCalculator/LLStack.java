/*
 * Property of Mitchell Jonker
 */

public class LLStack<T> implements StackI<T> {

	
	private class ListNode {
		T data;
		ListNode next;
		public ListNode(T aData, ListNode aLink) {
			data = aData;
			next = aLink;
		}
	}
	private ListNode head;
	public LLStack() {
		head = null;
	}
	public void push(T aT) {
		ListNode newNode = new ListNode(aT, head);
		head = newNode;
	}
	public T pop() {
		if(head == null) {
			return null;
		}
		T send = head.data;
		head = head.next;
		return send;
	}
	public T peek() {
		if(head == null) {
			return null;
		}
		return head.data;
	}
	public void print() {
		for(ListNode temp = head; temp != null; temp = temp.next) {
			System.out.println(temp.data);
		}
	}
	public int size() {
		int size = 0;
		for(ListNode temp = head; temp != null; temp = temp.next) {
			size++;
		}
		return size;
	}

}
