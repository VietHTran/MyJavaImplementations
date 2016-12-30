package Queue;
import LinkedList.*;
public class LightweightQueue<T> {
	private LinkedList<T> current;
	private LinkedList<T> tail;

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
			current=new LinkedList<T>(newElement);
			tail=current;
			return;
		}
		LinkedList<T> holder=tail;
		tail=new LinkedList<T>(newElement);
		holder.setNext(tail);
	}
	
	public T pop() {
		T holder=current.getCurrent();
		current=current.getNext();
		return holder;
	}
}
