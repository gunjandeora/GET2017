package DS1;
import java.util.NoSuchElementException;
class Node {
	Integer value;
	Node next;
	Node previous;
   	public Node(Integer item){
            value = item;	
	}
        public Node(){}
}
public class A4 {
    public static void main (String[] args) {
        DoublyLinkedList dlist = new DoublyLinkedList();
    }
}
class DoublyLinkedList {
	private static final int BASE_VALUE = 0;
	Node start = new Node();
	Node currentNode = null;
	public void add(Integer data) {
		Node nodeNew = new Node();
		nodeNew.value = data;
		if (start.next == null) {
			start.next = nodeNew;
		} else {
			currentNode = start.next;
			while (currentNode.next != null) {
			currentNode = currentNode.next;
			}
			nodeNew.previous = currentNode;
			currentNode.next = nodeNew;
		}
	}
	public boolean addItemAtLocation(Integer position, Integer data) {
		Integer incrementor = BASE_VALUE;
		Node newNode = new Node();
		newNode.value = data;
		currentNode = start.next;
		if (position == BASE_VALUE) {
			newNode.next = start.next;
			start.next = newNode;
			currentNode.previous = newNode;
			return true;
		} 
                else {
			while (incrementor < position - 1) {
                            currentNode = currentNode.next;
                            if (currentNode == null) {
                                throw new IndexOutOfBoundsException();
                            }
				incrementor++;
			}
			newNode.next = currentNode.next;
			currentNode.next.previous = newNode;
			currentNode.next = newNode;
			newNode.previous = currentNode;
			return true;
		}
	}
	void forwardTraverse() {
		System.out.println("forward traversed list is");
		currentNode = start.next;
		while (currentNode != null) {			
			System.out.println(currentNode.value);
			currentNode = currentNode.next;
		}
	}
	void backwardTraverse() {
		System.out.println("Backward traversed list is");
		currentNode = start.next;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		while (currentNode != null) {
			System.out.println(currentNode.value);
			currentNode = currentNode.previous;
		}
	}
	public boolean removeDataItem(Integer dataItem) {
		Node previousNode = new Node();
		currentNode = start.next;
		if (currentNode.value == dataItem) {
			start.next = currentNode.next;
			currentNode.next.previous = null;
			return true;
		} 
                else {
			while (currentNode != null) {
				if (currentNode.value == dataItem) {
					previousNode.next = currentNode.next;
					currentNode.next.previous = previousNode;
					return true;
				}
				previousNode = currentNode;
				currentNode = currentNode.next;
			}
		}
		throw new NoSuchElementException();
	}
	boolean removeItemOnIndex(Integer index) {
		Node previousNode = new Node();
		currentNode = start.next;
		int incrementor = BASE_VALUE;
		if (index == BASE_VALUE) {
			start.next = currentNode.next;
			currentNode.next.previous = null;
			return true;
		} else {
			while (currentNode != null) {
				if (index == incrementor) {	
					previousNode.next = currentNode.next;
					currentNode.next.previous = previousNode;
					return true;
				}
				previousNode = currentNode;
				currentNode = currentNode.next;
				incrementor++;
			}
		}
		throw new IndexOutOfBoundsException();
	}
	public Integer getItem(Integer index) { 		
		int incrementor = BASE_VALUE;
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

