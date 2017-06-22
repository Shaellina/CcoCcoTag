
public class MyLinkedList {

	Node head, tail;
	int size = -1;

	private void addFirstNode() {
		Node newNode = new Node();
		newNode.next = tail;
	}

	private void addNode() {
		Node newNode = new Node();
		tail.next = newNode;
		newNode.next = tail;
	}

	public void add() {
		if (size == -1) {
			addFirstNode();
		} else {
			addNode();
		}
		size++;
	}

	public void remove() {
		
	}

	public boolean isEmpty() {
		return size == -1 ? true : false;
	}

}

class Node {
	Object object;
	Node next;
}