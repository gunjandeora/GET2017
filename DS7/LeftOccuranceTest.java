package DS7;
import static org.junit.Assert.*;
import org.junit.Test;
public class LeftOccuranceTest {
	@Test
	public void leftOccuranceTest() {
		BinarySearch test = new BinarySearch();
		int array[] = new int[]{55,56,57,58,59,60};
		int expected1 = 2, 
			expected2 = -1;	
		assertEquals(expected1, test.startSearch(array, 57));			//if value is present in array
		assertEquals(expected2, test.startSearch(array, 65));			//false test case
	}
}
