/*
 * Property of Mitchell Jonker
 */

public interface QueueI <T> {
	public void enqueue(T tD);
	public T dequeue();
	public T peek();
	public void print();
}