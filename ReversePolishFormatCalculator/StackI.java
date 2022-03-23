/*
 * Property of Mitchell Jonker
 */

public interface StackI <T> {
	public void push(T aT);
	public T pop();
	public T peek();
	public void print();
	public int size();
}