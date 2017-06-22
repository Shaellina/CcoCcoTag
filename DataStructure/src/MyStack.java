import java.util.Vector;

public class MyStack {

	Vector<Object> stack = new Vector<Object>();

	public void push(Object object) {
		stack.add(object);
	}

	public Object pop() {
		Object object = stack.get(stack.size() - 1);
		stack.remove(stack.size() - 1);
		return object;
	}

	public boolean isEmpty() {
		return stack.size() == 0 ? true : false;
	}

	public int size() {
		return stack.size();
	}
}
