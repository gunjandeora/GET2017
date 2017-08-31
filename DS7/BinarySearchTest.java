package DS7;
import static org.junit.Assert.*;
import org.junit.Test;
public class BinarySearchTest {
	@Test
	public void startSearch_array_intValue () {
		BinarySearch test = new BinarySearch();
		int array[] = new int[]{55,56,57,58,59,60},array2[] = new int[1];
		int expected1 = 2, 
			expected2 = -1;	
		assertEquals(expected1, test.startSearch(array, 57));			//if value is present in array
		assertEquals(expected2, test.startSearch(array, 65));			//false test case
		assertEquals(expected2, test.startSearch(array2, 57));
	}
}
