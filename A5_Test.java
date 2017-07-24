package PF_Session1;
import static org.junit.Assert.*;
import org.junit.Test;
public class A5_Test {
	@Test
	//test method
	public void sortedArrayTest() {
		int[] input = {1,2,3,4,5};				//input array
		int expected_output = 1;				
		int actual_output = SortArray.CheckSortedArray(input);		//getting actual output
		assertEquals(expected_output, actual_output);				//comparing results.
	}
}
