package PF_Session2;
import static org.junit.Assert.*;
import org.junit.Test;
public class A1_Test {
		String expected1 = "   12321";					//row = 9 and key = 6
		String expected2 = "1234321";					//row = 3 and key = 7 
		String expected3 = "   ";					//row = 8 and key = 5 
		String fexpected1 = " ";					//output expected for incorrect input.
		String fexpected2 = " ";					//output expected for incorrect input.
		String fexpected3 = " ";					//output expected for incorrect input.
	DrawPattern1 drawp = new DrawPattern1();
	@Test
	// Method to test "MergeStrings" method
	public void testMergedStrings() {
		assertEquals(expected1, drawp.MergeStrings(9, 6));	//when input is correct.	
		assertEquals(fexpected1, drawp.MergeStrings(16, 6));	//when input is not correct.
	}
	// Method to test "space" method
	public void testSpaces () {
		assertEquals(expected3, drawp.space(8, 5));		//when input is correct.
		assertEquals(fexpected3, drawp.space(21, 7));		//when input is not correct.
	}
	// Method to test "number" method.
	public void testNumbers () {
		assertEquals(expected2, drawp.number(3, 7));		//when input is correct.
		assertEquals(fexpected2, drawp.number(-5, 7));		//when input is not correct.
	}
}
