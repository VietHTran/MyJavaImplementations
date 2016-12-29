package Stack;

//Implement a stack using linked list instead of vector in order to reduce the memory needed
public class LightweightStack<T> {
	private LinkedElement<T> current;
	
	public LightweightStack(){
		current=null;
	}
	
	public T peek() {
		return current.getCurrent();
	}
	
	public boolean isEmpty() {
		return (current==null);
	}
	
	public void push(T newElement) {
		LinkedElement<T> holder=null;
		if (current!=null) holder=current;
		current=new LinkedElement<T>(newElement);
		current.setNext(holder);
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
