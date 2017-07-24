package PF_Session3;
import static org.junit.Assert.*;
import org.junit.Test;
public class A1_1_2_Test {
	@Test
	public void gcdTest() {
		int fExpected1 = 1;				//expected GCD for 2,1
		int fExpected2 = 4;				//expected GCD for 12,8
		int fExpected3 = 1;				//expected GCD for 100,3
		GreatestCommonDivisors gTest = new GreatestCommonDivisors();
		assertEquals(fExpected1, gTest.greatestCommonDivisor(2,1));
		assertEquals(fExpected2, gTest.greatestCommonDivisor(12,8));
		assertEquals(fExpected3, gTest.greatestCommonDivisor(100,3));
	}
}
