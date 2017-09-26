package DS7;
import static org.junit.Assert.*;
import org.junit.Test;
public class LeftOccuranceTest {
	BinarySearch test = new BinarySearch();
	int array1[] = new int[]{55,56,57,58,59,60},
		array2[] = null;
	int expected1 = 2, 
		expected2 = -1;	
	@Test
	public void leftOccuranceTest_intArrayNvaluePresent_positionofValue() {
		assertEquals(expected1, test.startSearch(array1, 57));			//if value is present in array
	}
	@Test
	public void leftOccuranceTest_intArrayNvalueNotPresent_positionofValue() {
		assertEquals(expected2, test.startSearch(array1, 65));			//false test case, if value not present
	}
	@Test
	public void leftOccuranceTest_nullArray_negativeValue() {
		assertEquals(expected2, test.startSearch(array2, 57));			//returns -1 i array is null
	}
}
