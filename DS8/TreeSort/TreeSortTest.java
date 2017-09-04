package DS8.TreeSort;
import static org.junit.Assert.*;
import DS2.Queue.MyArrayList;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
public class TreeSortTest {
	MyBinarySearchTree bSTree = new MyBinarySearchTree();
	@Test
	public void insertNode_Student_boolean() {
		assertEquals(true, bSTree.insertNode(new Student(101 , "Abhishek")));
		assertEquals(true, bSTree.insertNode(new Student(103 , "Akash")));
	}
	@Test
	public void inOrder_parentNode_List_soretedList(){
		// adding student objects in MyArrayList
		Student stud1 = new Student(101 , "Abhishek");
		Student stud2 = new Student(102 , "Rohit");
		Student stud3 = new Student(103 , "Akash");
		Student stud4 = new Student(104 , "Maynk");
		Student stud5 = new Student(105 , "Shobhit");			
		bSTree.insertNode(stud2);
		bSTree.insertNode(stud1);
		bSTree.insertNode(stud3);
		bSTree.insertNode(stud4);
		bSTree.insertNode(stud5);	
		MyArrayList sortedList = new MyArrayList();			
		sortedList.add(101);
		sortedList.add(105);
		sortedList.add(104);
		sortedList.add(102);
		sortedList.add(103);
		MyArrayList actualList = sortedList.sort();
		MyArrayList expected = bSTree.inOrder(bSTree.getRoot(), new MyArrayList());
		assertEquals(expected, actualList);
		assertEquals(5, bSTree.size(bSTree.getRoot()));			// checking number of students, ie size of MyArrayList
	}
}
