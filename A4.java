package DS1;
import java.util.NoSuchElementException;
public class A4 {
    public static void main (String[] args) {
        DoublyLinkedList dlist = new DoublyLinkedList();
    }
}
class DoublyLinkedList {
	private static final int BASE_VALUE = 0;
	Node<Integer> start = new Node<Integer>();
	Node<Integer> currentNode = null;
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
	public void add(Integer data) {
		Node<Integer> nodeNew = new Node<Integer>();
		nodeNew.setData(data);
		if (getStartNode().next == null) {
			start.setNext(nodeNew); 
		} else {
			currentNode = getStartNode().next;
			while (currentNode.next != null) {
			currentNode = currentNode.getNext();
			}
			nodeNew.previous = currentNode;
			currentNode.next = nodeNew;
		}
	}
	public boolean addItemAtLocation(Integer position, Integer data) {
		Integer incrementor = BASE_VALUE;
		Node<Integer> newNode = new Node<Integer>();
		newNode.setData(data);
		currentNode = getStartNode().getNext();
		if (position == BASE_VALUE) {
			newNode.setNext(getStartNode().getNext());
			start.setNext(newNode);
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
		currentNode = getStartNode().getNext();
		while (currentNode != null) {			
			System.out.println(currentNode.getData());
			currentNode = currentNode.next;
		}
	}
	void backwardTraverse() {
		System.out.println("Backward traversed list is");
		currentNode = getStartNode().next;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		while (currentNode != null) {
			System.out.println(currentNode.getData());
			currentNode = currentNode.previous;
		}
	}
	public boolean removeDataItem(Integer dataItem) {
		Node<Integer> previousNode = new Node<Integer>();
		currentNode = getStartNode().next;
		if (currentNode.getData() == dataItem) {
			getStartNode().next = currentNode.next;
			currentNode.next.previous = null;
			return true;
		} 
                else {
			while (currentNode != null) {
				if (currentNode.getData() == dataItem) {
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
		Node<Integer> previousNode = new Node<Integer>();
		currentNode = getStartNode().next;
		int incrementor = BASE_VALUE;
		if (index == BASE_VALUE) {
			getStartNode().next = currentNode.next;
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
		currentNode = getStartNode().next;		
		while (incrementor < index) {			
			currentNode = currentNode.next;
			incrementor++;
			if (currentNode == null) {				
				throw new IndexOutOfBoundsException();
			}
		}
		return currentNode.getData();
	} 
        public int getSize() {
		int size = 0;
		currentNode = getStartNode().next;
		while (currentNode != null) {
			size++;
			currentNode = currentNode.next;
		}
		return size;
	}
        
        // method to sort the list
	public void sort() {
		QuickSortDoubleLinkedList q = new QuickSortDoubleLinkedList();
		q.quickSort(getLastNode(), getStartNode());
	}
}