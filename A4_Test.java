package PF_Session1;
import static org.junit.Assert.*;
//Test Class
import org.junit.Test;
public class A4_Test {
	@Test
	public void FCFS() {
		FCFSClass fc = new FCFSClass();
		int[] a_time = {1,5,9,25};		//given arrival time
		int[] job_size = {12,7,2,5};	//given job size
		int[][] result = { {1,0,1,12},		//expected result as 2D array.
						   {5,8,13,19},
						  {9,11,20,21},
						  {25,0,25,29}};
		// comparing both expected and actual outputs.
		assertArrayEquals(result,fc.JobSchedulingFunction(a_time, job_size) );
	}
}
