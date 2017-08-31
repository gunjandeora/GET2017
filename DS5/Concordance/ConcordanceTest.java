package DS5.Concordance;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import DS2.CounsellingSystem.MyArrayList;
public class ConcordanceTest {
	@Test
	public void concordanceCharacter_NoInputValue_intValue() {
		Concordance cor = new Concordance();
		Map<Character, MyLinkList> map = new HashMap<Character, MyLinkList>();
		String testString1 = "hello world!", 
			testString2 = " ";
		Integer expected1 = 4,
			expected2 = 9,
			expected3 = 11,
			expected4 = 0;
		MyLinkList<Integer> testList = new MyLinkList<Integer>();
		cor.concordanceCharacter(testString1);
		cor.concordanceCharacter(testString2);
//		testList = cor.map.get('o');
//		System.out.println("%%%%%%%" + testList.getAtLoc(1));
		assertEquals(expected1, cor.map.get('o').getAtLoc(1));							//location of 'o' stored in MyLinkedList
		assertEquals(expected2, cor.map.get('l').getAtLoc(3));							//location of second 'l' in MyLinkedList
		assertEquals(expected3, cor.map.get('!').getAtLoc(1));							//location of '!' in MyLinkedList 
		assertEquals(expected4, cor.map.get(' ').getAtLoc(1));
	}
}
