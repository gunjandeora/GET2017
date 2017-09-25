package DS5.QueueImplementation;
import static org.junit.Assert.*;

import org.junit.Test;

import DS5.Concordance.MyLinkList;
public class MyLinkedListTest {
	MyLinkList<Integer> list = new MyLinkList<Integer>();
	@Test
	public void getAtLoc_location_valueAtLocation() {
		Integer expected1 = 1,
				expected2 = 3, 
				expected3 = 5;
		list.insert(expected1);
		list.insert(3);
		list.insert(5);
		assertEquals(expected2, list.getAtLoc(2));
		assertEquals(null, list.getAtLoc(23));
	}
	@Test
	public void getAtLoc_location_null() {
		list.insert(1);
		list.insert(3);
		list.insert(5);
		assertEquals(null, list.getAtLoc(23));
	}
	@Test
	public void insertAtLoc_LocationValue_null(){
		Integer expected = 13;
		list.insert(11);
		list.insert(12);
		list.insert(14);
		list.insert(15);
		list.insertAtLoc(13, 3);
		assertEquals(expected, list.getAtLoc(3));		
	}
	
	@Test
	public void deleteAtLoc_location_boolean(){
		Integer expected = 14;		
		insertValues();
		assertEquals(true, list.deleteAtLoc(3));
		assertEquals(expected, list.getAtLoc(3));		
	}
	@Test
	public void deleteByValue_value_boolean(){
		Integer expected = 13;
		insertValues();
		assertEquals(true, list.deleteByValue(12));		
		System.out.println("value" + list.getAtLoc(2));
		assertEquals(expected, list.getAtLoc(2));	
		assertEquals(false, list.deleteByValue(122));
	}
	public void insertValues(){
		list.insert(11);
		list.insert(12);
		list.insert(13);
		list.insert(14);
		list.insert(15);
	}
}
