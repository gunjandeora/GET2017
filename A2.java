package PF_Session1;
import java.util.Scanner;
// class used only for calling
public class A2 {
	public static void main (String[] args) {
		int len , i=0;
		Scanner sc = new Scanner(System.in);
		Node start = new Node(0);					//Initializing linked list.
		Node p ;
		p = start;
		System.out.println("Enter number of elements of input array");
		len = sc.nextInt();				//taking length of input array from user.
		int[] input = new int[len];
		System.out.println("Enter elements of input array");
		while (i!=len) {
			Node temp = new Node(0);
			p.i = sc.nextInt();
			input[i] = p.i;						//bcz we have to send int array to removeDupicate method.
			p.next = temp;
			p = p.next;
			i++;
		}
		Duplicate dp = new Duplicate();
		dp.removeDuplicate(input);				//sending start to removeDuplicate object			
}
}
// Remove duplicate class
class Duplicate {
	Node start = new Node(0);
	public Duplicate(){
		
	}
	
	public Duplicate(Node startNode){
		this.start = startNode;
	}
	int count =0;
	Node p = new Node(0);
	public int[] removeDuplicate(int[] input) {
		Node outerPointer = new Node(0) , innerPointer = new Node(0);
		for(outerPointer=start;outerPointer.next!=null;outerPointer= outerPointer.next){
			for(innerPointer=outerPointer.next;innerPointer.next!=null;innerPointer= innerPointer.next){
				if(outerPointer.next.i == innerPointer.next.i){			//if duplicates found
					innerPointer.next = innerPointer.next.next;			//removing duplicates
				}
			}
		}
		for(p=start;p.next!=null;p=p.next){
			count++;								//counting length of linked list
			System.out.print(p.i);
		}
		System.out.println("^count "+ count);
		int[] finalArray = new int[count];				//initializing final array.
		p=start;
		for(int a=0;a<count;a++){
			finalArray[a] = p.i;						//setting values from linked list to int array
			//System.out.println("(");
		}
		return finalArray;
	}
}
// class used for making linked list's nodes.
class Node {
	int i , count;
	Node next;
	public Node (int x){
		i = x;
	}
}