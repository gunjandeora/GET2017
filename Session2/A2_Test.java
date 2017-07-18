package PF_Session2;
import static org.junit.Assert.*;
import org.junit.Test;
public class A2_Test {
		String expected1 = "   123";					//key = 6 and row = 3
		String expected2 = "1234567";					//key = 7 and row = 0
		String expected3 = "     ";						//key = 7 and row = 5
		String fexpected1 = " ";						//expected output for wrong input
		String fexpected2 = " ";						//expected output for wrong input
		String fexpected3 = " ";						//expected output for wrong input
	DrawPattern2 drawp = new DrawPattern2();
	@Test
	// Method to test "MergeStrings" method
	public void testMergedStrings() {
		assertEquals(expected1, drawp.MergeStrings(3, 6));		//when input is correct.
		assertEquals(fexpected1, drawp.MergeStrings(-3, -6));		//false input , when both negative values
	}
	// Method to test "space" method
	public void testSpaces () { 
		assertEquals(expected3, drawp.space(5, 7));				//when input is correct.
		assertEquals(fexpected3, drawp.space(14, 7));				//when input is not correct.
	}// Method to test "number" method.
	public void testNumbers () {
		assertEquals(expected2, drawp.number(0, 7));				//when input is correct.
		assertEquals(fexpected2, drawp.number(-12, 7));				//false input , when both negative values	
	}
}
