package PF_Session1;
import static org.junit.Assert.*;
import org.junit.Test;
public class A3_Test {
	@Test
	public void longestSequence() {
		int[] input = {1,2,3,2,3,4,5,3,4,2,2,3,4,5,6,7,8,1,2,4,5,6,7,8,9}; //input array
		int[] expected_output = {1,2,4,5,6,7,8,9};						//expected output
		int[] actual_output = LongestSequence.longestSequence(input);
		assertArrayEquals(expected_output, actual_output);  //checking expected and actual outputs
	}
}