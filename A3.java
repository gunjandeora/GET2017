package DS1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Scanner;
class Node {
	Integer value; 
	Node next;
}
class SinglyLinkedList {
	private static final Integer BASE_VALUE = 0;
	Node start = new Node();
	Node currentNode = null;
	//data to be added to list
	public void add(Integer data) {
		Node newNode = new Node();
		newNode.value = data;
		if (start.next == null) {
			start.next = newNode;
		} else
			currentNode = start.next;
			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}
			currentNode.next = newNode;
		}
	/**
	 * method to traverse the whole list and display list items
	 */
	public void traverse() {
		currentNode = start.next;
		System.out.println("link list : ");
		while (currentNode != null) {
			System.out.println(currentNode.value);
			currentNode = currentNode.next;
		}
	}
	public boolean removeDataItem(Integer dataItem) {
		Node previous = new Node();
		currentNode = start.next;
		if (currentNode.value == dataItem) {
			start.next = currentNode.next;
			return true;
		} else {
			while (currentNode != null) {
				if (currentNode.value == dataItem) {
					previous.next = currentNode.next;
					return true;
				}
				previous = currentNode;
				currentNode = currentNode.next;
			}
		}
		throw new NoSuchElementException();
	}
	boolean removeItemOnIndex(Integer index) {
		Node previous = new Node();
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
		return currentNode.value;
	}
	public boolean addAtlocation(Integer position, Integer data) {

		Integer incrementor = BASE_VALUE;
		Node newNode = new Node();
		newNode.value = data;
		if (position == BASE_VALUE) {
			newNode.next = start.next;
			start.next = newNode;
			return true;
		} else {
			currentNode = start.next;
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
	public int getSize() {
		int size = 0;
		currentNode = start.next;
		while (currentNode != null) {
			size++;
			currentNode = currentNode.next;
		}
		return size;
	}
	
	// method to sort the list
	public void sort() {
		int size = this.getSize();
		mergeSort(0, size-1);
	}
    private void mergeSort(int low, int high) {
    	if (low < high) {
    		int middle = low + (high - low) / 2;
    		mergeSort(low, middle);
    		mergeSort(middle + 1, high);
    		merge(low, middle, high);
    		}
    	}
public Integer set( Integer object , Integer index) {
	currentNode = start.next;
	int counter=0;
	if(index < getSize()-1) {
		while (currentNode != null && counter < index) {
			counter++;
			currentNode = currentNode.next;
		}
		currentNode.value = object;
		return currentNode.value;
	} else {
		throw new IndexOutOfBoundsException();
	}
} 
    private void merge(int low, int middle, int high) {
    	Integer[] helper = new Integer[getSize()];
    		for (int i = low; i <= high; i++) {
    			helper[i] = getItem(i);
    		}
    		int lowerBound = low;
    		int middleIndex = middle + 1;
    		int lowerIndex = low;
    		while (lowerBound <= middle && middleIndex <= high) {
    			if (((Comparable) helper[lowerBound]).compareTo(helper[middleIndex]) < 0) {
    				Integer old=getItem(lowerIndex);
    				old = helper[lowerBound];
    				set(old,lowerIndex);
    				lowerBound++;
    			} else {
    				Integer old=getItem(lowerIndex);
    				old = helper[middleIndex];
    				set(old,lowerIndex);
    				middleIndex++;
    			}
    			lowerIndex++;
    		}
    		while (lowerBound <= middle) {
    			Integer old=getItem(lowerIndex);
    			old = helper[lowerBound];
    			set(old,lowerIndex);
    			lowerIndex++;
    			lowerBound++;
    		}
    }
}