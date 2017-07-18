package PF_Session3;
import static org.junit.Assert.*;
import org.junit.Test;
// class used for test cases
public class A1_1_1_Test {
	@Test
	public void remainderTest() {
		//Test Input 1 when unique whole numbers as inputs where number1<number2.
		int number1 = 3;
		int number2 = 5;
		int Expected1 = 3;
		//Test Input 2 when same whole numbers as input
		int number3 = 5;
		int number4 = 5;
		int Expected2 = 0;
		//Test Input 3 when whole numbers as inputs where number1>number2.
		int number5 = 25;
		int number6 = 4;
		int Expected3 = 1;
		//Test Input 4 when whole numbers as inputs where number2=0.
		int number7 = 5;
		int number8 = 0;
		int Expected4 = -1;
		A1_1_1 q = new A1_1_1();			//initializing object.
		assertEquals(Expected1, q.rem(number1, number2));
		assertEquals(Expected2, q.rem(number3, number4));
		assertEquals(Expected3, q.rem(number5, number6));
		assertEquals(Expected4, q.rem(number7, number8));
	}
}
