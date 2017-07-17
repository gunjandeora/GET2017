package PF_Session2;
import java.util.Scanner;

/*main class*/
public class A1 {
public static void main (String[] args){
	DrawPattern1 dp = new DrawPattern1(1);
	}
}

/*class for drawing pattern*/
class DrawPattern1{
	int key, row, col;
	public DrawPattern1() {
	}
	public DrawPattern1(int n){
	while(true){											//condition used to check input.
		try {
			System.out.print("Enter number of rows");
			Scanner sc = new Scanner(System.in);
			key = sc.nextInt();
			break;											//break loop if we get integer value.
			 }
			 catch (Exception e){								//if it's not an integer input.
			 System.out.println("Please enter an Interger");
			 continue;										
			 }
		 }
		 PrintPatt();											//calling print function.
	}
	/* this function is used to frame space string using common variables row and col */
	 public String space(int row , int key){
		 String s = "";
		 if((row > (2*key)) || key<0 || row<0){								//condition for false testing
			 s = " ";
			 System.out.println("Incorrect input values");
			 return s;
		 }
		 if(row<=key){
		 for(col=1;col<key-row;col++){
			 s = s + " ";										//updating value of space string.
		 }
	}
		 else {
			 for(col=1;col<=row-key;col++){
				 s = s + " ";									//updating value of space string.
			 }
		 }
		 return s;												//returning final space string.
	 }
	
	/* this function is used to frame number string using common variables key, row and col */
	 public String number(int row, int key){
		 String s = "";
		 if((row > (2*key)) || key<0 || row<0){								//condition for false testing
			 s = " ";
			 System.out.println("Incorrect input values");
			 return s;
		 }
		 if(row<=key){
		 for(col=0;col<=row;col++){
			 s = s + (col+1);										//updating value of number string.
		 }
		 for(int i=col-1;i>0;i--){
			 s = s + (i) ;
		 }
		 }
		 else {
			 for(col=1;col<=key-(row-key);col++){
				 s = s + (col);										//updating value of number string.
			 }
			 
			 for(int i=col-2;i>0;i--){
				 s = s + (i) ;
				 //System.out.print("col is" + col);
			 }
		 }
		 return s;												//returning final space string.
	 }
	/* Function that will return array of strings using above two functions
	 * that is space(row,key) and number(row,key)*/
	 public String MergeStrings (int row , int key){
		 String spaceString , numberString , finalString;
		 if((row > (2*key)) || key<0 || row<0){								//condition for false testing
			 finalString = " ";
			 System.out.println("Incorrect input values");
			 return finalString;
		 }
		
			 spaceString = space(row , key);					//getting final space string.
			 numberString = number(row , key);					//getting final number string.
			 finalString = spaceString + numberString;			//getting final space and number string.
			 return finalString;
	 }
	 /* Final function to first call merge function for final string and then print final strings*/
	 	public void PrintPatt(){
		int newKey;
		String finalString = "";
		 for(row=0;row<(key);row++){
			 finalString = MergeStrings(row , key);					//calling function to merge space amd number strings
			 System.out.println(finalString);
		 }
		 newKey = (key*2)-1;							//condition for lower half figure
		 for(row=key+1;row<=newKey;row++){
			 finalString = MergeStrings(row, key);
			 System.out.println(finalString);
		 }
		 //return finalString;
	}
}
