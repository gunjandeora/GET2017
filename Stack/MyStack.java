package ds2.Stack;
import java.util.NoSuchElementException;
public class MyStack {
    Node head;
    int size;
    public MyStack() {
        head=null;
        size=0;
    }	
    public boolean isEmpty(){
        return head==null;
    }
    public int size(){
        return size;
    }	
    public void push(Character data){
        Node newNode= new Node(data);

        if(head==null){
            head=newNode;
        }
        else{
            newNode.next = head;
            head=newNode;
        }
        size++;
    }
	
    public Character pop(){
        if(isEmpty()){
            throw new NoSuchElementException("Underflow Exception") ;
        }
        Node temp=head;
        head=temp.next;
        size--;	
        return temp.value;
    }
	
    public Character peek(){
        if(isEmpty()){
            throw new NoSuchElementException("Underflow Exception") ;
        }
        return head.value;
    }
	
    public void display(){
        System.out.print("\nStack = ");
        if(isEmpty()){
            System.out.println("No Element");
            return;
        }
        Node temp = head;

        while(temp != null){
            System.out.print(temp.value+" ");
            temp=temp.next;
        }
        System.out.println();
    }
}