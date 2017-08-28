package DS5.Concordance;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import DS2.CounsellingSystem.MyArrayList;
public class TestConcordance {
	Concordance cor = new Concordance();
	String testString = "Hi";
	MyArrayList l1 = new MyArrayList();
	MyArrayList l2 = new MyArrayList();
	Map<Character, MyArrayList> map = new HashMap<Character, MyArrayList>();
	
	@Test
	public void testStringConcordance() {		
		Map<Character, MyArrayList> map = new HashMap<Character, MyArrayList>();
		l1.add(0);
		map.put('H', l1);
		l2.add(1);
		map.put('i', l2);
		System.out.println(map);
		System.out.println(cor.concordanceCharacter(testString));
		assertEquals(map, cor.concordanceCharacter(testString));
	}
}
