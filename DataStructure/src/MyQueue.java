import java.util.LinkedList;

public class MyQueue {
	LinkedList<Object> queue = new LinkedList<Object>();

	public void push(Object object) {
		queue.add(object);
	}

	public Object pop() {
		Object object = queue.get(0);
		queue.remove(0);
		return object;
	}

	public boolean isEmpty() {
		return queue.size() == 0 ? true : false;
	}

	public int size() {
		return queue.size();
	}
}
