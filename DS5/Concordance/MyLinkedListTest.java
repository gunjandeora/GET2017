package DS5.Concordance;
import static org.junit.Assert.*;
import org.junit.Test;
public class MyLinkedListTest {
	MyLinkList<Integer> list = new MyLinkList<Integer>();
	@Test
	public void getAtLoc_validLocation_valueAtLocation() {
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
	public void getAtLoc_invalidLocation_null() {
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
	public void deleteAtLoc_validLocation_boolean(){
		Integer expected = 14;		
		insertValues();
		assertEquals(true, list.deleteAtLoc(3));
		assertEquals(expected, list.getAtLoc(3));		
	}
	@Test
	public void deleteAtLoc_invalidLocation_boolean(){
		Integer expected = 14;		
		insertValues();
		assertEquals(false, list.deleteAtLoc(333));		
	}
	@Test
	public void deleteByValue_valuePresent_boolean(){
		Integer expected = 13;
		insertValues();
		assertEquals(true, list.deleteByValue(12));		
		System.out.println("value" + list.getAtLoc(2));
		assertEquals(expected, list.getAtLoc(2));	
		assertEquals(false, list.deleteByValue(122));
	}
	@Test
	public void deleteByValue_valueNotPresent_boolean(){
		insertValues();	
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
