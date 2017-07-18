package PF_Session2;
import java.util.Scanner;
// main class
public class A2 {
	public static void main (String[] args) {
		DrawPattern2 dp = new DrawPattern2(1);		
	}
}
//class used to draw pattern 2
 class DrawPattern2 {
	 int key, row, col;
	 public DrawPattern2() {
	}
	 //constructor used to initialize some variables.
	 DrawPattern2(int n){
		 while(true){									//condition used to check input.
			 try {
				 System.out.print("Enter number of rows");
				 Scanner sc = new Scanner(System.in);
				 key = sc.nextInt();
				 break;							//break loop if we get integer value.
			 }
			 catch (Exception e){						//if it's not an integer input.
				System.out.println("Please enter an Interger");
				continue;						//sent back to top row of loop.
			 }
		 }
		 PrintPatt();								//calling print function.
	 } 
	 /* this function is used to frame space string using common variables row and col */
	 public String space(int row , int key){
		 String s = "";
		 if((row > key) || key<0 || row<0){					//condition for false testing
			 s = " ";
			 System.out.println("Incorrect input values");
			 return s;
		 }
		 for(col=1;col<=row;col++){
			 s = s + " ";										//updating value of space string.
		 }
		 return s;												//returning final space string.
	 }
	 /* this function is used to frame number string using common variables key, row and col */
	 public String number(int row, int key){
		 String s = "";
		 if((row > key) || key<0 || row<0){						//condition for false testing
			 s = " ";
			 System.out.print("Incorrect input values");
			 return s;
		 }
		 for(col=1;col<=key-row;col++){
			 s = s + col;								//updating value of number string.
		 }
		 return s;									//returning final space string.
	 }
	 /* Function that will return array of strings using above two functions
		 * that is space(row,key) and number(row,key)*/
	 public String MergeStrings (int row , int key){
		 String spaceString , numberString , finalString;
		 if((row > key) || key<0 || row<0){						//condition for false testing
			 finalString = " ";
			 System.out.print("Incorrect input values");
			 return finalString;
		 
			 spaceString = space(row , key);					//getting final space string.
			 numberString = number(row , key);					//getting final number string.
			 finalString = spaceString + numberString;			//getting final space and number string.
		 return finalString;
	 }
	 /* Final function to first call merge function for final string and then print final strings*/
	 public void PrintPatt () {
		 String finalString;
		 for(row=0;row<key;row++){
			finalString = MergeStrings(row , key);
			System.out.println(finalString);
		 }
	 }
 }
