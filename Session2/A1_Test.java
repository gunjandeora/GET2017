package PF_Session2;
import static org.junit.Assert.*;
import org.junit.Test;
public class A1_Test {
	@Test
	public void test() {
		DrawPattern1 drawp = new DrawPattern1();
		String expected1 = "   12321";					//row = 9 and key = 6
		String expected2 = "1234321";					//row = 3 and key = 7 
		String expected3 = "   ";					//row = 8 and key = 5 
		String fexpected1 = " ";
		String fexpected2 = " ";
		String fexpected3 = " ";
		
		assertEquals(expected1, drawp.MergeStrings(9, 6));
		assertEquals(expected2, drawp.number(3, 7));
		assertEquals(expected3, drawp.space(8, 5));
		assertEquals(fexpected1, drawp.MergeStrings(16, 6));
		assertEquals(fexpected2, drawp.number(-5, 7));
		assertEquals(fexpected3, drawp.space(21, 7));
	}
}
