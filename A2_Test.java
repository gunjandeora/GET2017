package OOPs_Session1;
import static org.junit.Assert.*;
import org.junit.Test;
public class A2_Test {

	Matrix m = new Matrix();
	int matrix1[][] = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
	int expectedMatrix1[][] = new int[][]{{1,4,7},{2,5,8},{3,6,9}};
	int matrix2[][] = new int[][]{{4,5,6},{11,14,12},{76,78,77}};
	int expectedMatrix2[][] = new int[][]{{4,11,76},{5,14,78},{6,12,77}};
	int matrix3[][];
	int expectedMatrix3[][] = new int[][]{{5 ,7 ,9},{15 ,19 ,18}, {83, 86 ,86 }};
	int expectedMatrix4[][] = new int[][]{{3,3 ,3},{7, 9, 6},{69 ,70, 68} };
	int expectedMatrix5[][] = new int[][]{{2,2,3},{5,7,6},{38,38,36}};
	int i1=4, i2=5 , i3=0, i4=5 , i5=2;	
	@Test
	//test transpose.
	public void testTranspose(){
//		assertArrayEquals(expectedMatrix1, m.transposeMatrix(matrix1));
//		assertArrayEquals(expectedMatrix2, m.transposeMatrix(matrix2));
	}
	//checking addElements Method.
	public void testingAddElements(){
		m.addElements(i1,i2,i3);
	}	
	//checking multipleMatrix Method.
	public void testMultiplyMatrix(){
		//getting rows and columns for multiplication.
		assertArrayEquals(matrix3, m.multiplyMatrix(matrix1, matrix2));
	}
	//checking addMatrix Method.
	public void testAddMatrix(){
		assertArrayEquals(expectedMatrix3, m.addMatrix(matrix1, matrix2));
	}
	//checking subtractMatrix Method.
	public void testSubMatrix(){
		assertArrayEquals(expectedMatrix4, m.addMatrix(matrix2, matrix1));
	}
	//checking divideMatrix Method.
	public void testDivide(){
		assertArrayEquals(expectedMatrix5, m.divideMatrix(matrix2, 2));
	}
}
