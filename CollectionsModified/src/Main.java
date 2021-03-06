import Map.*;
import Stack.*;
import Queue.*;
public class Main {

	public static void main(String[] args) {
		LightweightQueue<String> queue = new LightweightQueue<String>();
		queue.push("takamura");
		queue.push("was");
		queue.push("here");
		do {
			String holder=queue.peek();
			queue.pop();
			System.out.println(holder);
		} while (!queue.isEmpty());
		System.out.println();
		LightweightStack<String> stack = new LightweightStack<String>();
		stack.push("pines");
		stack.push("filbrick");
		stack.push("stanford");
		do {
			String holder=stack.peek();
			stack.pop();
			System.out.println(holder);
		} while (!stack.isEmpty());
	}
}
