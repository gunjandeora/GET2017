package DS8.SortingSystem;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import DS2.Queue.MyArrayList;
/*
 * In this class we are using LinkedList to perform queue operations because add
 * and remove methods of LinkedList fulfills the queue properties(FIFO)
 */
public class MyQueue {
	public MyArrayList head;
	MyQueue() {
		head = new MyArrayList();
	}
	void enqueue(int value) {
		head.add(value);
	}
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
		return (int)head.get(0);
	}
	/*
	 * Using Iterator to print elements of queue
	 */
	public String toString() {
		String temp="";
		for(int i=0;i<head.size();i++) {
			temp = temp+ head.get(i);
		}
		System.out.println(temp);
		return temp;
	}
}
