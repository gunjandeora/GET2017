package PF_Session4;
import static org.junit.Assert.*;
import org.junit.Test;
public class A2_Test {
	@Test
	public void testPermutation() {
		A2 p = new A2();
		A2 p1 = new A2();
		A2 p2 = new A2();
		A2 p3 = new A2();
		//Test 1
		System.out.println("Test 1");
		p.permute("AABC".toCharArray());
		assertEquals(12, p.count);						//Total number of permutations for string "AABC" should be 12.
		//Test 2
		System.out.println("Test 2");
		p1.permute("AA".toCharArray());
		assertEquals(1, p1.count);						//Total number of permutations for string "AA" should be 1.
		//Test 3
		System.out.println("Test 3");
		p2.permute("ABC".toCharArray());
		assertEquals(6, p2.count);						//Total number of permutations for string "ABC" should be 6.
//		//Test 4
		System.out.println("Test 4");
		p3.permute("ABCA".toCharArray());
		assertEquals(12, p3.count);						//Total number of permutations for string "ABCA" should be 12.
	}

}
