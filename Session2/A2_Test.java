package PF_Session2;
import static org.junit.Assert.*;
import org.junit.Test;
public class A2_Test {
	@Test
	public void space() {		
		DrawPattern2 drawp = new DrawPattern2();
		String expected1 = "   123";					//key = 6 and row = 3
		String expected2 = "1234567";					//key = 7 and row = 0
		String expected3 = "     ";						//key = 7 and row = 5
		String fexpected1 = " ";						//expected output for wrong input
		String fexpected2 = " ";						//expected output for wrong input
		String fexpected3 = " ";						//expected output for wrong input
		
		assertEquals(expected1, drawp.MergeStrings(3, 6));
		assertEquals(expected2, drawp.number(0, 7));
		assertEquals(expected3, drawp.space(5, 7));
		assertEquals(fexpected1, drawp.MergeStrings(-3, -6));		//false input , when both negative values
		assertEquals(fexpected2, drawp.number(-12, 7));				//false input , when both negative values
		assertEquals(fexpected3, drawp.space(14, 7));	
	}
}
