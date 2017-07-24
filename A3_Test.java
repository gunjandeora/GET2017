package PF_Session4;
import static org.junit.Assert.*;

import org.junit.Test;
public class A3_Test {
	@Test
	public void testQueenProblem() {
		Queens Q = new Queens(4);			//checking for 4 queens
		 Q.callplaceNqueens();
	}

}
