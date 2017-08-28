package DS5.SortedLinkList;
class Node<T> {
	T data;
	Node<T> next;
	public Node() {
		next = null;
		data = null;
	}
	public Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}
	public void setNext(Node<T> next) {
		this.next = next;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Node<T> getNext() {
		return this.next;
	}
	public T getData() {
		return this.data;
	}
}
