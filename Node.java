package DS1;
public class Node<T> {
	T data;
	Node<T> next;
	Node<T> previous;
	public Node() {
		data= null;
		next= null;
	}
	public Node(T data , Node<T> next){
		this.data=data;
		this.next=next;
	}
	public void setData(T data){
		this.data=data;
	}
	public T getData(){
		return this.data;
	}
	public void setNext(Node<T> next){
		this.next = next;
	}
	public Node<T> getNext(){
		return next;
	}
	public void setPrevious(Node<T> prev){
		this.previous = prev;
	}
	public Node<T> getPrevious(){
		return previous;
	}
}

