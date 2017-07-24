package PF_Session3;
import static org.junit.Assert.*;
import org.junit.Test;
public class A2_Test {
	int[] input1 = new int[]{2,5,8,9,10,55,77},
		 input2 = new int[]{2,5,8,9,10,77,55,11},
		 input3;
	int search1 = 77,
		search2 = 88,
		search3 = -5;
	LinearSearch ls = new LinearSearch();
	BinarySearch1 bs = new BinarySearch1();
	@Test
	public void testLinearSearchCorrectInputs() {
		assertEquals(6, ls.search(input1 , 0 , search1));		//test case when value is present in an array.
		assertEquals(5, ls.search(input2 , 0 , search1));		//test case when value is present in an array.
	}
	public void testLinearSearchIncorrectInputs(){
		assertEquals(-1, ls.search(input1 , 0  ,search3));		//test case when value is present in an array.
		assertEquals(-1, ls.search(input2 , 0 , search3));		//test case when value is not present in an array.
		assertEquals(-1, ls.search(input3 , 0 , search1));		//test case when wrong value is sent to array.
		assertEquals(-1, ls.search(input3 , 0 , search2));		//test case when wrong value is sent to array.
		assertEquals(-1, ls.search(input3 , 0 , search3));		//test case when value is not present in an array.		
	}
	public void testLinearSearchValueNotPresent() {
		assertEquals(-1, ls.search(input1 , 0 , search2));		//test case when value is not present in an array.
		assertEquals(-1, ls.search(input2 , 0 , search2));		//test case when value is not present in an array.		
	}
	public void testBinarySearchCorectInputs() {
		assertEquals(6, bs.search(input1 , 0 ,(input1.length),  search1));		//test case when value is present in an array.
		assertEquals(6, bs.search(input2 , 0 ,input2.length  , search1));		//test case when value is present in an array.
	}
	public void testBinarySearchValueNotPresent(){
		assertEquals(-1, bs.search(input1 , 0 ,input1.length ,  search2));		//test case when value is not present in an array.
		assertEquals(-1, bs.search(input2 , 0 ,input2.length , search2));		//test case when value is not present in an array.
	}
	public void testBinarySearchIncorrectInputs(){ 
		assertEquals(-1, bs.search(input1 , 0 ,input1.length , search3));		//test case when value is present in an array.
		assertEquals(-1, bs.search(input2 , 0 ,input2.length , search3));		//test case when value is not present in an array.
		assertEquals(-1, bs.search(input3 , 0 ,input3.length , search1));		//test case when wrong value is sent to array.
		assertEquals(-1, bs.search(input3 , 0 ,input3.length , search2));		//test case when value is present in an array.
		assertEquals(-1, bs.search(input3 , 0 ,input3.length , search3));		//test case when value is not present in an array.		
	}
}
	

