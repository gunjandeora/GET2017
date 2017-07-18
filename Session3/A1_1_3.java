package PF_Session3;
public class A1_1_3 {
	int maxNumber = -1;						//Assuming initially maxNumber is -1.
	//Finding largest digit.
	public int largestDigit(int number){
		if(number%10>maxNumber){
			maxNumber = number%10;			//updating new digit
		}
		if (number/10==0){
			return maxNumber;
		}
		return largestDigit(number/10);			//recursive calling
	}
}
