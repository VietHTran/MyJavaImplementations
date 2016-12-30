package Queue;

public class LightweightQueue<T> {
	private LinkedElement<T> current;
	private LinkedElement<T> tail;

	public LightweightQueue(){
		current=null;
		tail=null;
	}
	
	public T peek() {
		return current.getCurrent();
	}
	
	public boolean isEmpty() {
		return (current==null);
	}
	
	public void push(T newElement) {
		if (tail==null){
			current=new LinkedElement<T>(newElement);
			tail=current;
			return;
		}
		LinkedElement<T> holder=tail;
		tail=new LinkedElement<T>(newElement);
		holder.setNext(tail);
	}
	
	public T pop() {
		T holder=current.getCurrent();
		current=current.getNext();
		return holder;
	}
	
	private class LinkedElement<T> {
		private T current;
		private LinkedElement<T> next;
		public LinkedElement (T value) {
			setCurrent(value);
		}
		public T getCurrent() {
			return current;
		}
		public LinkedElement<T> getNext() {
			return next;
		}
		public void setNext(LinkedElement<T> value) {
			next=value;
		}
		public void setCurrent(T value) {
			current =value;
		}
	}
}
