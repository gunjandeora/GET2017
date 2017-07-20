package OOPs_Session1;
import java.util.Scanner;
//Matrix class , each object will represent a matrix
class Matrix {
	public int[][] matrix;
	int row , column;
	// Default constructor for initializing an object.
	Matrix(){
	}
	// constructor for initializing a matrix;
	Matrix(int row, int column){
		matrix = new int[row][column];
		this.row = row;
		this.column = column;
	}
	//adding elements to matrix.
	void addElements (int row , int column , int value){
			if(row<=this.row || column<=this.column) {
				matrix[(int)row][(int)column] = (int)value;
			}
	}
	//transpose matrix
	int[][] transposeMatrix(int[][] inputMatrix){
		int inner , outer;
		int[][] temp = new int[inputMatrix.length][inputMatrix[0].length];
		for(outer=0;outer<row;outer++){
			for(inner=0;inner<column;inner++){
				temp[inner][outer] = inputMatrix[outer][inner];
			}
		}
		return temp;
	}
	
	void printMatrix(int[][] inputMatrix){
		int inner , outer;
		for(outer=0;outer<row;outer++){
			for(inner=0;inner<column;column++){
				System.out.print(inputMatrix[row][column]);
			}
			System.out.println();
		}
	}
	// multiplying 2 matrix and storing values in third matrix
	int[][] multiplyMatrix(int[][] a, int[][]b ){
		
		int inner , outer , row , column ,k;
		row = a.length;
		column = b[0].length;
		int[][] c = new int[column][row];
		if(a[0].length==b.length){						////checking conditions
			for(outer=0;outer<row;outer++){
				for(inner=0;inner<column;inner++){
					for(k=0;k<b.length;k++){					//number of times for addition performed
						c[inner][outer] = c[inner][outer] + a[inner][k] * b[k][outer];
					}
				}
			} 
		}
		return c;
	}
	//adding 2 matrix
	int[][] addMatrix(int[][] a, int[][]b){
		int[][] c = new int[a.length][a[0].length];
		if(a.length == b.length && a[0].length==b[0].length){				//checking conditions
			int inner , outer ;
			row = a.length;
			column = a[0].length;
			for(outer=0;outer<row;outer++){
				for(inner=0;inner<column;inner++){
					c[outer][inner] = a[outer][inner] + b[outer][inner];
				}
			}	
			
		}
		return c;
	}
	//subtracting 2 matrix
	int[][] subtractMatrix(int[][] a, int[][]b){
		int[][] c = new int[a.length][a[0].length];
		if(a.length == b.length && a[0].length==b[0].length){		//checking conditions
			int inner , outer ;										//initializing local variables
			row = a.length;
			column = a[0].length;
			for(outer=0;outer<row;outer++){
				for(inner=0;inner<column;inner++){
					c[outer][inner] = a[outer][inner] - b[outer][inner];
				}
			}	
		}
		return c;
	}
	//dividing matrix with a number
	int[][] divideMatrix(int[][] a, int divisor){
			int inner , outer ;
			row = a.length;
			column = a[0].length;
			for(outer=0;outer<row;outer++){
				for(inner=0;inner<column;inner++){
					a[inner][outer] = a[inner][outer] /divisor;
				}
			}	
			return a;
	}
}