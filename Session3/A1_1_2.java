package PF_Session3;
import java.util.Scanner;
public class A1_1_2{
	public static void main (String[] args){
		GreatestCommonDivisors gc = new GreatestCommonDivisors();
		int number1 , number2;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first number");
		number1 = sc.nextInt();						//taking first number
		System.out.print("Enter second number");
		number2 = sc.nextInt();						//taking second number
		gc.greatestCommonDivisor(number1, number2);
	}
}
 class GreatestCommonDivisors{
	//Method to find Greatest Common DIvisor between two numbers
	public int greatestCommonDivisor(int number1, int number2){
		if (number2 != 0)
		       return greatestCommonDivisor(number2, number1%number2);
		    else 
		       return number1;						//when number2 is zero
	}
}
