package PF_Session1;
import static org.junit.Assert.*;
import org.junit.Test;
public class A1_Test {
	@Test
	public void convertBinaryToOctalTest() {
		int expected = 65;			//expected output
		int actual_output = BinaryToOctal.convertBinaryToOctal(110101);
		assertEquals(expected, actual_output);		//comparing expected and actual outputs.
	}
}
