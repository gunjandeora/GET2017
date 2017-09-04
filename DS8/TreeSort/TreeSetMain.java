package DS8.TreeSort;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import DS2.Queue.MyArrayList;
public class TreeSetMain {
	Scanner sc = new Scanner(System.in);
	MyBinarySearchTree bt = new MyBinarySearchTree();
	public static void main(String[] args) {
		TreeSetMain treeSet = new TreeSetMain();
		treeSet.takeInput();		
	}
	public void takeInput(){
		String name, choice="y";
		int roll;
		while(choice.equals("y") || choice.equals("Y")){
			System.out.println("Enter Name of Student ");
			name = sc.nextLine();
			System.out.println("Enter Roll Number of Student");
			try{									//exception handling for wrong roll number
				roll = sc.nextInt();
			}
			catch(Exception e){
				System.out.println("Enter valid roll number");
				continue;
			}
			bt.insertNode(new Student(roll, name));	
			System.out.println("Do you wish to add more students?? Enter y or n");
			choice = sc.nextLine();
		}
		System.out.println(" Number of Students: "+ bt.size(bt.getRoot()));		
		MyArrayList sortedList = new MyArrayList();
		sortedList= bt.inOrder(bt.getRoot() , sortedList);			//retrieving sorted list of roll numbers
		System.out.println(sortedList);	
	}
}
