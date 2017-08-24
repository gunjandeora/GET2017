package DS1;
public class QuickSortSingleLinkedList {
	Node<Integer> end;
    public Node<Integer> quickSort(Node<Integer> start, Node<Integer> end){
        // If the list contains one or less node, return the start node itself.
        if(null == start || null == start.getNext() || start == end){
            return start;
        }
        // Result contains start/end of left and right segments and the pivot.
        Node[] result = partition(start, end);
        Node resultLeft = null; 
        if(null != result[0]) {
            resultLeft = quickSort(result[0], result[1]);
        }
        Node resultRight = null; 
        if(null != result[3]){
            resultRight = quickSort(result[3], result[4]);
        }
        if(resultRight !=null) {
            result[2].setNext(resultRight);
        }
        if(null == resultLeft){
            return result[2];						// If left segment has nothing, return pivot.
        }else{            
            return  resultLeft;						// Else return the start of left.
        }
    }
    private Node[] partition (Node<Integer> start, Node<Integer> end){
        // We are not moving pivot but the other nodes.
    	Node<Integer> pivot = end;
    	Node<Integer> tail = end;
    	Node<Integer> newStart = null;
    	Node<Integer> current = start;
    	Node<Integer> previous = null;
        boolean isFirstNodeWithoutMove = true;
        while(null != current && end != current){
        	Node<Integer> next = current.getNext();
            if(current.getData() > pivot.getData()){
                moveNodeToEnd(current, previous, tail);
                tail = tail.getNext();
            }else{
                if(isFirstNodeWithoutMove){
                    newStart = current;
                    isFirstNodeWithoutMove = false;
                }
                // Advance iteration pointers.
                if(null != previous){
                    previous.setNext(current);
                }
                previous = current;
            }
            current = next;
        }
        /* Prepare result for returning */
        Node[] result = new Node[5];
        result[0] = newStart;
        result[1] = previous;
        result[2] = pivot;
        result[3] = pivot.getNext();
        result[4] = tail;
        return result;
    }
    private void moveNodeToEnd(Node current, Node previous, Node tail) {
        if(null != previous){
            previous.setNext(current.getNext());
        }
        current.setNext(null);
        tail.setNext(current);
    }
}
