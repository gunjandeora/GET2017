package DS5.QueueImplementation;
import java.awt.List;
import java.util.Iterator;
import java.util.LinkedList;
/**
 * In this class we are using LinkedList to perform queue operations because add
 * and remove methods of LinkedList fulfills the queue properties(FIFO)
 */
public class MyQueue {
	public MyLinkList<Integer> head;
	int size;
	MyQueue() {
		head = new MyLinkList<Integer>();
		size=0;
	}
	// to add element in queue
	boolean enqueue(int value) {
		if   (head.insertAtLoc(value, size)) {
			size++;
			return true;
		}
		else {
			return false;
		}
	}
	// to remove element from the queue
	int dequeue() {
		size--;
		return head.deleteAtLoc(size);
	}
	// get size of Myqueue
	int getSize() {
		return size;
	}
	boolean clear() {
		head.clearList();
		return true;
	}
	int getFront() {
		return head.getStart().getData();
	}
	/**
	 * Using Iterator to print elements of queue
	 */
	public String toString() {
		MyNode<Integer> node = head.getStart();	
		//Iterator<Integer> iterator = head.iterator();
		while (node.getLink()!=null) {
			System.out.println(node.getData());
		}
		return "";
	}
}
