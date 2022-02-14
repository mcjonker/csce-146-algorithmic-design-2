/*
 * Property of Mitchell Jonker
 */

public class DoubleDoubleLL {
	
	private class ListNode {
		
		double data;
		ListNode next;
		ListNode previous;
		
		public ListNode(double aData, ListNode aNode, ListNode bNode) { // Data, next, previous
			
			data = aData;
			next = aNode;
			previous = bNode;
			
		}
	}
	private ListNode head;
	//private ListNode next; // Can be enabled to have an existing next reference.
	private ListNode current;
	private ListNode previous;
	private ListNode tail;
	
	public DoubleDoubleLL() {
		head = current = previous = null;
	}
	public void add(double aData) {
		ListNode newNode = new ListNode(aData, null, null);
		if(head == null) {
			head = current = newNode; // if list is empty, make the new node the current, as well as the head.
			return;
		}
		ListNode temp = head;
		while(temp != null && temp.next != null) { // goes to end of list without changing current
			temp = temp.next;
		}
		temp.next = newNode;
		tail = newNode;
		newNode.previous = temp;
	}
	public void addAfterCurrent(double aData) {
		if(current == null) {
			return;
		}
		ListNode newNode = new ListNode(aData, current.next, current); // Set the current node to previous, and the next node to its next node.
		current.next = newNode; // set new node to next node.
		if(current.next == null) {
			tail = current;
		}
	}
	public void remove(double aData) {
		reset();
		while(hasAnother()) {
			if(aData == current.data) {
				removeCurrent();
			}
			gotoNext();
		}	
	}
	public void removeCurrent() {
		if(current == head) {
			head = current.next;
			current = current.next;
		}
		if(current != null && previous == null && current != head) { // if head was removed, reinstate previous and remove current.
			previous = current.previous; // artificially reinstate previous from null
			previous.next = current.next;
			current = current.next;
			return;
		}
		if(current == tail) { // if current is tail, go back one, reset tail reference, and set next to null.
			current = current.previous;
			tail = current;
			current.next = null; 
		}
	}
	public void reset() {
		current = head;
		current.next = head.next;
		current.previous = null;
	}
	public void gotoNext() {
		if(current != null) {
			current.previous = current;
			current = current.next;
		}
	}
	public void gotoPrev() {
		if(current != null) {
			current.next = current;
			current = current.previous;
			if(current == head) {
				current.previous = null;
			}
			else {
				current.previous = previous.previous;
			}
		}
	}
	public void gotoEnd() { 
		current = tail;
		current.previous = tail.previous;
		current.next = null;
	}
	public boolean hasMore() { // if there is a next, return true
		if(current != null) {
			return true;
		}
		else {
			return false;
		}
		
	}
	private boolean hasAnother() {
		return current.next != null;
	}
	
	public double getCurrent() {
		if(current == null) {
			return 0;
		}
		return current.data;
	}
	public void setCurrent(double aData) {
		if(current == null) {
			return;
		}
		current.data = aData;
	}
	public void print() {
		ListNode hold = head;
		while(hold != null) {
			System.out.println(hold.data);
			hold = hold.next;
		}
	}
	public boolean contains(double aData) {
		if(head != null) {
			ListNode hold = head;
			while(hold != null) {
				if(hold.data == aData) {
					return true;
				}
				hold = hold.next;
			}
			return false;
		}
		else {
			return false;
		}
	}
}