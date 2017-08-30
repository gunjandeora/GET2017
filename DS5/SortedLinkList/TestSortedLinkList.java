package DS5.SortedLinkList;
import static org.junit.Assert.*;

import org.junit.Test;
public class TestSortedLinkList {
	static MyLinkList<Integer> testList = new MyLinkList<Integer>();
	Node<Integer> head ;
	@Test
	public void testEmptyList(){
		assertEquals(true, testList.isEmpty());
		Node<Integer> head = testList.insert(testList.getHead(), 2);
		testList.setHead(head);
		testList.insertNode(4);
		testList.insertNode(6);
		testList.insertNode(8);
		testList.insertNode(10);
		assertEquals(false, testList.isEmpty());
	}
	@Test
	public void testSize() {
		Node<Integer> head = testList.insert(testList.getHead(), 2);
		testList.setHead(head);
		testList.insertNode(4);
		testList.insertNode(6);
		testList.insertNode(8);
		testList.insertNode(10);
		System.out.println(testList.getSize());
		assertEquals(5, testList.size);
	}
}
