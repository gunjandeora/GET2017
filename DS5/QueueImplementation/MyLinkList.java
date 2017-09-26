package DS5.QueueImplementation;
public class MyLinkList<T> {
	MyNode<T> start;
    int size ;
    public MyLinkList(){
        start = null;
        size = 0;
    }
	// get start node link
    public MyNode<T> getStart(){
    	return start;
    }
	//reset start node 
    public void setStart(MyNode<T> node){
    	start = node;
    }
    public boolean isEmpty(){
        return start == null;
    }
	//size of MyLinkedList
    public int getSize(){
        return size;
    }    
    /*
     * This method will insert an item at specific location
     */
    
    public void insert(T value){
    	MyNode<T> newNode = new MyNode<T>(value, null);         //initializing node pointer       
        if(start == null ){
        	setStart(newNode);									//start = nptr;
        	//System.out.println("Start set");
        }
        else {
        	MyNode<T> nodePointer = new MyNode<T>();
        	nodePointer = getStart();
        	while(nodePointer.getLink()!= null){
        		nodePointer = nodePointer.getLink();
        	}
        	nodePointer.setLink(newNode);
        }
        ++size;
    }
	//insert at a particular location
    public boolean insertAtLoc(T val , int loc){
    	++size ;
    	boolean flag = false;
    	MyNode<T> nptr = new MyNode<T>(val, null);         //initializing node pointer       
        if( loc == 1 && start == null ){
        	setStart(nptr);									//start = nptr;
        	flag = true;
        }
        else if(loc == 1){
        	nptr.setLink(getStart());
        	setStart(nptr);
        	flag = true;
        }
        else{
        	MyNode<T> ptr = getStart();
	        loc = loc - 1 ;
	        for (int i = 1; i <= size; i++){
	            if(i == loc){
	            	MyNode<T> tmp = ptr.getLink() ;
	                ptr.setLink(nptr);
	                nptr.setLink(tmp);
	                break;
	            }
	            ptr = ptr.getLink();
	        }
	        flag = true;
        }
        size--;
        return flag;
    }
    // delete from a particular location
    public int deleteAtLoc(int location){      
    	int data = 0;
        if(location == 1) {        	
        	data = (Integer) start.getData();
            start = start.getLink();
            size--; 
            return data;
        }
        if (location == size) {
        	MyNode<T> current = getStart();
        	MyNode<T> temp = getStart();
        	MyNode<T> next = current.getLink();
            while (next != null){
                temp = current;
                current = current.getLink();
                next= next.getLink();
            }
            data = (Integer)temp.getData();
            temp.setLink(null);
            size--;
            return data;
        }
        MyNode<T> ptr = getStart();
        location = location - 1 ;
        for (int i = 1; i < size - 1; i++) {
            if(i == location) {
            	data = (int) ptr.getData();
            	MyNode<T> tmp = ptr.getLink();
                tmp = tmp.getLink();
                ptr.setLink(tmp);
                break;
            }
            ptr = ptr.getLink();
        }
        size-- ;
        return data;
    }    
    // delete by from a location by comparing value at each location
    public void deleteByValue(T val){
    	if(getStart().getData() == val){
    		if(getStart().getLink() == null){
    			setStart(null);
    		}else{
	    		start= start.getLink();
    		}
    		System.out.println("deleted "+val);
    		size--;
    	}
    	else{
    		MyNode<T> nextptr = getStart();
    		MyNode<T> prevptr = new MyNode<T>();
	    	boolean flag= false;
	    	 for (int i = 1; i <= size ; i++) {
		            if (val == nextptr.getData()){
		                prevptr.setLink(nextptr.getLink());
		                flag= true;
		                break;
		            }
		            prevptr= nextptr;
		            nextptr = nextptr.getLink();
		        }
	    	 if(flag){
	    		 size-- ;
	    		 System.out.println("deleted "+val);
	    	 }
	    	 else
	    		 System.out.println("Value Not Found");	
    	}
    }
    // get value at particular location
    public T getAtLoc(int location){
    	MyNode<T> ptr = getStart();
       // location = location - 1 ;
        for (int i = 1; i <= size ; i++){
            if (i == location) {
            	System.out.println(ptr.getData());
                System.out.println("Value on "+location+" is "+ptr.getData());
                return ptr.getData();
            }
            ptr = ptr.getLink();
        }
        return null;
    }
    // reverse the MyLinkedList
    public void reverseLinkedList(){
    	MyNode<T> reversedPart = null;
    	MyNode<T> current = getStart();
    	while (current != null) {
    		MyNode<T> next = current.getLink();
    	    current.setLink(reversedPart);
    	    reversedPart = current;
    	    current = next;
    	}
    	setStart(reversedPart);
    }
    //sort MyLinkedList
    public void sortLinkedList(){
    	if(size == 0){
    		System.out.println("No elements to sort");
    	}else{
    		MyNode<T> currentNode= getStart();
    		MyNode<T> nextNode= start.getLink();
    		for(int i= 0; i < size;i++){
	    		while(nextNode != null){
		    		if((Integer)currentNode.getData()> (Integer)nextNode.getData()){
		    			T temp= currentNode.getData();
		    			currentNode.setData(nextNode.getData());
		    			nextNode.setData(temp);
		    		}
		    		
		    		currentNode= nextNode;
		    		nextNode= nextNode.getLink();
		    	}
	    		currentNode= getStart();
	    		nextNode= getStart().getLink();
	    	}
    	}
    }
    // clear MyLinkedList, reset start
    public void clearList(){
    	setStart(null);
    }
    
    /*  Function to display LinkedList  */
    public void display(){
//        System.out.print("Singly Linked List = ");
        if(size == 0) {
            System.out.print("empty\n");
            return;
        }    
        if(getStart().getLink() == null){
            System.out.println(start.getData() );
            return;
        }
        MyNode<T> ptr = getStart();
        System.out.print(start.getData()+ "->");
        ptr = getStart().getLink();
        while (ptr.getLink() != null){
            System.out.print(ptr.getData()+ "->");
            ptr = ptr.getLink();
        }
        System.out.print(ptr.getData()+ "\n");
    }
}