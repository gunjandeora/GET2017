package DS8.TreeSort;
import java.util.ArrayList;
import java.util.List;
public class TreeSetMain {

	public static void main(String[] args) {
		Student stud1 = new Student(101, "Abhishek");
		Student stud2 = new Student(102, "Rohit");
		Student stud3 = new Student(103, "Akash");
		Student stud4 = new Student(104, "Maynk");
		Student stud5 = new Student(105, "Shobhit");

		MyBinarySearchTree bt = new MyBinarySearchTree();
		bt.insertNode(stud2);
		bt.insertNode(stud1);
		bt.insertNode(stud3);
		bt.insertNode(stud4);
		bt.insertNode(stud5);
		
		System.out.println(bt.size(bt.getRoot()));
		
		List<Integer> sortedList = new ArrayList<Integer>(); 
		sortedList= bt.inOrder(bt.getRoot() , sortedList);
		
		System.out.println(sortedList);

	}

}