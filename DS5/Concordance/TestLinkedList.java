package DS5.Concordance;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLinkedList {
	MyLinkList<Integer> list = new MyLinkList<Integer>();
	@Test
	public void testGetAtLocation() {
		Integer expected1 = 1,
				expected2 = 3, 
				expected3 = 5;
		list.insert(expected1);
		list.insert(3);
		list.insert(5);
		assertEquals(expected2, list.getAtLoc(2));
	}
	@Test
	public void testInsertAtLocation(){
		Integer expected = 13;
		list.insert(11);
		list.insert(12);
		list.insert(14);
		list.insert(15);
		list.insertAtLoc(13, 3);
		assertEquals(expected, list.getAtLoc(3));		
	}
	
	@Test
	public void testDeleteAtLocation(){
		Integer expected = 14;
		list.insert(11);
		list.insert(12);
		list.insert(13);
		list.insert(14);
		list.insert(15);
		list.deleteAtLoc(3);
		System.out.println("value" + list.getAtLoc(3));
		assertEquals(expected, list.getAtLoc(3));		
	}
	
	@Test
	public void testDeleteByValue(){
		Integer expected = 13;
		list.insert(11);
		list.insert(12);
		list.insert(13);
		list.insert(14);
		list.insert(15);
		list.deleteByValue(12);
		System.out.println("value" + list.getAtLoc(2));
		assertEquals(expected, list.getAtLoc(2));		
	}
}
