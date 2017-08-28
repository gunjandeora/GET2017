package DS5.QueueImplementation;
import java.awt.List;
import java.util.Iterator;
import java.util.LinkedList;
/**
 * In this class we are using LinkedList to perform queue operations because add
 * and remove methods of LinkedList fulfills the queue properties(FIFO)
 */
public class MyQueue {
	public LinkedList<Integer> head;
	MyQueue() {
		head = new LinkedList<Integer>();
	}
	// to add element in queue
	boolean enqueue(int value) {
		if(head.add(value)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	// to remove element from the queue
	int dequeue() {
		return head.remove(0);
	}
	int size() {
		return head.size();
	}
	boolean clear() {
		head.clear();
		return true;
	}
	int getFront() {
		return head.get(0);
	}
	/**
	 * Using Iterator to print elements of queue
	 */
	public String toString() {
		Iterator<Integer> iterator = head.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		return "";
	}

}
