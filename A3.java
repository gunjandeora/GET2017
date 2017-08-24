package DS1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Scanner;
class SinglyLinkedList {
	private static final Integer BASE_VALUE=0;
	Node<Integer> start, currentNode;
	/* creating the SinglyLinkedList
	*/
	void createSinglyLinkedList() {
		start = new Node<Integer>();
		currentNode = null;
	}
	// always return start Node
	Node<Integer> getStartNode(){
		return start;
	}
	
	void setStartNode(Node<Integer> newStart){
		this.start = newStart;
	}
	
	Node<Integer> getLastNode(){
		currentNode = getStartNode().getNext();
		while (currentNode != null) {
			currentNode = currentNode.next;
		}
		return currentNode;
	}
	/* data to be added to list
	*/
	public void add(Integer data) {
		Node<Integer> newNode = new Node<Integer>();
		newNode.setData(data);
		if (getStartNode().next == null) {
			getStartNode().next = newNode;
		} else
			currentNode = getStartNode().next;
			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}
			currentNode.next = newNode;
		}
	/**
	 * method to traverse the whole list and display list items
	 */
	public void traverse() {
		currentNode = getStartNode().getNext();
		System.out.println("link list : ");
		while (currentNode != null) {
			System.out.println(currentNode.getData());
			currentNode = currentNode.next;
		}
	}
	/* removes node with particular data value
	 */
	public boolean removeDataItem(Integer dataItem) {
		Node<Integer> previous = new Node<Integer>();
		currentNode = getStartNode().next;
		if (currentNode.getData() == dataItem) {
			getStartNode().next = currentNode.next;
			return true;
		} else {
			while (currentNode != null) {
				if (currentNode.getData() == dataItem) {
					previous.next = currentNode.next;
					return true;
				}
				previous = currentNode;
				currentNode = currentNode.next;
			}
		}
		throw new NoSuchElementException();
	}
	/* 
	 * removes data item on index given
	 */
	boolean removeItemOnIndex(Integer index) {
		Node<Integer> previous = new Node<Integer>();
		currentNode = start.next;
		Integer incrementor = BASE_VALUE;
		if (index == BASE_VALUE) {
			start.next = currentNode.next;
			return true;
		} else {
			while (currentNode != null) {
				if (index == incrementor) {	
					previous.next = currentNode.next;
					return true;
				}
				previous = currentNode;
				currentNode = currentNode.next;
				incrementor++;
			}
		}
		throw new IndexOutOfBoundsException();
	}
	/* 
	 * returns data value on a particular location
	 */
	public Integer getItem(Integer index) { 
		Integer incrementor = BASE_VALUE;
		currentNode = start.next;
		while (incrementor < index) {
			currentNode = currentNode.next;
			incrementor++;
			if (currentNode == null) {
				throw new IndexOutOfBoundsException();
			}
		}
		return currentNode.getData();
	}
	/* 
	 * add node at a particular location
	 */
	public boolean addAtlocation(Integer position, Integer data) {
		Integer incrementor = BASE_VALUE;
		Node newNode = new Node();
		newNode.setData(data);
		if (position == BASE_VALUE) {
			newNode.next = start.next;
			start.next = newNode;
			return true;
		} else {
			currentNode = getStartNode().next;
			while (incrementor < position - 1) {
				currentNode = currentNode.next;
				if (currentNode == null) {
					throw new IndexOutOfBoundsException();
				}
				incrementor++;
			}
			newNode.next = currentNode.next;
			currentNode.next = newNode;
			return true;
		}
	}
	/*
	 * reverse the linked list
	 */
	public void reverseList() {
		if (start.next == null) {
			return;
		} else {
			currentNode = start.next;
			Node firstPointer = new Node();
			Node secondPointer = new Node();
			while (currentNode != null) {				
				secondPointer = firstPointer;
				firstPointer = currentNode;
				currentNode = currentNode.next;
				firstPointer.next = secondPointer;
			}
			start.next = firstPointer;
			secondPointer.next.next=null;
		}
	}
	/*
	 * returns size of the linked list
	 */
	public int getSize() {
		int size = 0;
		currentNode = start.next;
		while (currentNode != null) {
			size++;
			currentNode = currentNode.next;
		}
		return size;
	}
	/* 
	 * sorting the linkedList
	 */
	void sort (){
		QuickSortSingleLinkedList q= new QuickSortSingleLinkedList();
		setStartNode(q.quickSort(start, getLastNode()));
	}
}