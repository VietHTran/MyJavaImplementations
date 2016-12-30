package LinkedList;

public class LinkedList<T> {
	private T current;
	private LinkedList<T> next;
	public LinkedList (T value) {
		setCurrent(value);
	}
	public T getCurrent() {
		return current;
	}
	public LinkedList<T> getNext() {
		return next;
	}
	public void setNext(LinkedList<T> value) {
		next=value;
	}
	public void setCurrent(T value) {
		current =value;
	}
}
