package Stack;

import LinkedList.*;
//Implement a stack using linked list instead of vector in order to reduce the memory needed
public class LightweightStack<T> {
	private LinkedList<T> current;
	
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
		LinkedList<T> holder=null;
		if (current!=null) holder=current;
		current=new LinkedList<T>(newElement);
		current.setNext(holder);
	}
	
	public T pop() {
		T holder=current.getCurrent();
		current=current.getNext();
		return holder;
	}
}
