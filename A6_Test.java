package PF_Session1;
import static org.junit.Assert.*;
import org.junit.Test;
public class A6_Test {
	@Test
	public void sortarray() {
		  MergeArray sa = new MergeArray();
		  int a[] = {2,5,7,9,12} , 
				b[] = {1,2,4,5,7,11,12};
		  int expected[] = {1,2,2,4,5,5,7,7,9,11,12,12} ,
			c[] = new int[20],
		  result[] = new int[a.length+ b.length];
		  Boolean flag = true;
		  result = sa.mergeArrayFunction(a, b, c);  //actual output.  
		  if(expected.equals(result)){			//used as assertEquals has void return type
			  flag = true;						//if merged properly.
		  }
		  else {
			  flag = false;						//if not merged properly.
		  }
		System.out.print(flag);
	}
}
