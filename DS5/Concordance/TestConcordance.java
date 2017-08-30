package DS5.Concordance;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import DS2.CounsellingSystem.MyArrayList;
public class TestConcordance {
	Concordance cor = new Concordance();
	String testString = "hello world!";
	Integer expected1 = 4,
		expected2 = 9,
		expected3 = 11;
	Map<Character, MyLinkList> map = new HashMap<Character, MyLinkList>();
	@Test
	public void testStringConcordance() {
		MyLinkList<Integer> testList = new MyLinkList<Integer>();
		cor.concordanceCharacter(testString);
//		testList = cor.map.get('o');
//		System.out.println("%%%%%%%" + testList.getAtLoc(1));
		assertEquals(expected1, cor.map.get('o').getAtLoc(1));				//location of 'o' stored in MyLinkedList
		assertEquals(expected2, cor.map.get('l').getAtLoc(3));				//location of second 'l' in MyLinkedList
		assertEquals(expected3, cor.map.get('!').getAtLoc(1));				//location of '!' stored in MyLinkedList
	}
}
