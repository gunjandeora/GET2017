package PF_Session1;

import static org.junit.Assert.*;
import org.junit.Test;
public class A4_Test {
	@Test
	public void FCFS() {
		
		FCFSClass fc = new FCFSClass();
		int[] a_time = {1,5,9,25};
		int[] job_size = {12,7,2,5};
		int[][] result = { {1,0,1,12},
						   {5,8,13,19},
						  {9,11,20,21},
						  {25,0,25,29}};
		
		assertArrayEquals(result,fc.JobSchedulingFunction(a_time, job_size) );
	}

}
