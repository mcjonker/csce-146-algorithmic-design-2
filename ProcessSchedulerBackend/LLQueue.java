/*
 * Property of Mitchell Jonker
 */

public class LLQueue <T> implements QueueI<T> {
	
	private class ListNode {
		
		T data;
		ListNode next;
		
		public ListNode(T aDT, ListNode aL) { // Data, node link
			data = aDT;
			next = aL;
		}
	}
	private ListNode head;
	private ListNode tail;
	
	public void enqueue(T tD) {
		
		ListNode tempNode = new ListNode(tD, null);
		if(head == null) {
			head = tail = tempNode;
			return;
		}
		tail.next = tempNode;
		tail = tail.next;
	}
	public T dequeue() {
		
		if(head == null) {
			return null;
		}
		T deq = head.data;
		head = head.next;
		return deq;
	}
	public T peek() { // return data at front of the queue (the head)
		
		if(head == null) {
			return null;
		}
		return head.data;
	}
	public void print() {
		ListNode temp = head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
}
