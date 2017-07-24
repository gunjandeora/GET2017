package PF_Session3;
import static org.junit.Assert.*;
import org.junit.Test;
public class A1_1_3_Test {
	@Test
	public void largestDigitTest() {
		//Test Input 1: 1257369
		int fExpected1 = 9;
		//Test Input 2: 44
		int fExpected2 = 4;
		//Test Input 3: 2
		int fExpected3 = 2;
		//Test Input 4: 0
		int fExpected4 = 0;
		A1_1_3 lg = new A1_1_3();
		assertEquals(fExpected1, lg.largestDigit(1257369));
		assertEquals(fExpected2, lg.largestDigit(44));
		assertEquals(fExpected3, lg.largestDigit(2));
		assertEquals(fExpected4, lg.largestDigit(0));
	}

}
