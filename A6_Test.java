package PF_Session1;

import static org.junit.Assert.*;

import org.junit.Test;

public class A6_Test {
	@Test
	public void sortarray() {
		
		  MergeArray sa = new MergeArray();
		  int a[] = {2,5,7,9,12} , b[] = {1,2,4,5,7,11,12};
		  int expected[] = {1,2,2,4,5,5,7,7,9,11,12,12} , c[] = new int[20];
		  int result[] = new int[a.length+ b.length];
		  Boolean flag = true;
		  
		  result = sa.mergeArrayFunction(a, b, c);
		  
		  if(expected.equals(result)){
			  flag = true;
		  }
		  else {
			  flag = false;
		  }
		System.out.print(flag);
	}
}
