package DS5.SortedLinkList;
public class MyLinkList<T> {
	Node<T> start;
	int size;
	public MyLinkList() {
		start = null;
		size = 0;
	}
	public boolean isEmpty() {
		return start == null;
	}
	public int getSize() {
		return size;
	}
	public Node<T> getHead() {
		return start;
	}
	public void setHead(Node<T> head) {
		start = head;
	}
	/**
	 * This method inserts the input value in the sorted linkedlist using
	 * recursion and returns updated head node.
	 */
	public Node<T> insert(Node<T> head, T value) {
		if (head == null || (Integer) head.getData() > (Integer) value) {
			Node<T> newNode = new Node<T>();
			newNode.setData(value);
			newNode.setNext(head);
			head = newNode;
			return head;
		} else {
			head.setNext(insert(head.getNext(), value));
			return head;
		}
	}

	/* Function to display LinkedList */
	public void display() {
		System.out.print("Singly Linked List = ");
		Node<T> move = start;
		while (move != null) {
			System.out.println(move.getData());
			move = move.getNext();
		}
	}
}