package PF_Session1;
import static org.junit.Assert.*;
import PF_Session1.*;
import org.junit.Test;
public class A2_Test {
	@Test
	public void removeDuplicate() {
		int[] given = {2,5,4,6,3,8,5,9,3,3,6,3,9,0};	//input array
		int[] result = {2,5,4,6,3,8,9,0};				//expected output
		Duplicate dp2 = new Duplicate();
		assertArrayEquals(result, dp2.removeDuplicate(given));	//checking both outputs
	}
}
