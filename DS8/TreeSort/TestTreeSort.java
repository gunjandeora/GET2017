package DS8.TreeSort;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestTreeSort {

	@Test
	public void test() {
		MyBinarySearchTree bSTree = new MyBinarySearchTree();

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
		
		List<Integer> sortedList = new ArrayList<Integer>();
		sortedList.add(101);
		sortedList.add(102);
		sortedList.add(103);
		sortedList.add(104);
		sortedList.add(105);
		
		Object actual[] = sortedList.toArray();
		
		List<Integer> expected= bSTree.inOrder(bSTree.getRoot(), new ArrayList<Integer>());
		Object[] exp1= expected.toArray();
		assertArrayEquals(exp1, actual);
	}

}