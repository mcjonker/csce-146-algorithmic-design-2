/*
 * Property of Mitchell Jonker
 */

public class GeneralLinkedList  <T> {
	
	private class ListNode {
		
		T data;
		ListNode next;
		
		public ListNode(T aD, ListNode aN) { // data, next (linked node)
			
			data = aD;
			next = aN;
		}
	}
	
	private ListNode head;
	private ListNode current;
	private ListNode previous;
	
	public GeneralLinkedList() {
		
		head = current = previous = null;
	}
	
	public void add(T aD) { // Add node to end of list.
		
		ListNode newNode = new ListNode(aD, null);
		
		if(head == null) { // initialize the list
			head = current = newNode;
			return;
		}
		ListNode temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
	}
	
	public void addAfterCurrent(T aD) {
		if(current == null) {
			return;
		}
		ListNode newNode = new ListNode(aD, current.next);
		current.next = newNode;
	}
	
	public T getCurrent() {
		if(current == null) {
			return null;
		}
		return current.data;
	}
	
	public void setCurrent(T aD) {
		if(aD == null || current == null) {
			return;
		}
		current.data = aD;
	}
	
	public void removeCurrent() {
		if(current == head) {
			head = head.next;
			current = head;
		}
		else {
			previous.next = current.next;
			current = current.next;
		}
	}
	
	public void gotoNext() {
		if(current == null) {
			return;
		}
		previous = current;
		current = current.next;
	}
	
	public boolean hasMore() { // returns current is not null
		
		return current != null;
	}
	
	public boolean hasAnother() { // returns next is not null
		
		return current.next != null;
	}
	
	public void reset() {
		current = head;
		previous = null;
	}
	
	public void empty() {
		head = current = previous = null;
		//current.next = null;
	}
	
	public void print() {
		ListNode print = head;
		while(print != null) {
			System.out.println(print.data);
			print = print.next;
		}
	}
}