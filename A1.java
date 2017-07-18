package PF_Session1;
//import for pow() function
import java.lang.Math;
import java.util.Scanner;
//Main class
public class A1 {
	public static void main(String[] args){
		int number;
		Scanner sc = new Scanner(System.in);
	  System.out.print("Enter the number String");
	  number = sc.nextInt();					//taking strings from user.
	  System.out.println(String.valueOf(BinaryToOctal.convertBinaryToOctal(number)));
  }
}

//class used for conversion
class BinaryToOctal{
	// function used for conversion
static int convertBinaryToOctal(int n){
		/*
			Taking a binary number into the groups of
			4 digit binary number and finding corresponding
			decimal equivalent for it and adding to the overall result
		*/		
		int j = 0, result = 0; //result: overall result
		while(n!=0){
			int rem = n%1000; //   rem : group of 3 binary 							
			int i = 0,rem_to_dec = 0; //rem_to_dec:decimal 							
			while(rem!=0){
				rem_to_dec = (rem%10)*(int)Math.pow(2,i)+rem_to_dec;
				rem = rem/10;
				i++;
			}
			result = rem_to_dec*(int)Math.pow(10,j)+result;
			n = n/1000;
			j++;
		}
		return result;
	}
}